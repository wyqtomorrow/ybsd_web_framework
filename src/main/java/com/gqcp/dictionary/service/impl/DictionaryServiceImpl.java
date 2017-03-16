package com.gqcp.dictionary.service.impl;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.redisson.core.RList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.gqcp.common.exception.business.BusinessException;
import com.gqcp.common.page.ResponseEntity;
import com.gqcp.common.page.ResponseEntityUtil;
import com.gqcp.dictionary.DictionaryConstant;
import com.gqcp.dictionary.dao.mapper.DictionaryItemMapper;
import com.gqcp.dictionary.dao.mapper.DictionaryMapper;
import com.gqcp.dictionary.dao.model.DictionaryExample;
import com.gqcp.dictionary.dao.model.DictionaryItem;
import com.gqcp.dictionary.dao.model.DictionaryItemExample;
import com.gqcp.dictionary.service.DictionaryService;
import com.gqcp.redis.service.RedisService;

/**
 * Created by hh on 2016/11/29.
 */
@Service
public class DictionaryServiceImpl implements DictionaryService {
  static Logger logger = LoggerFactory.getLogger(DictionaryServiceImpl.class);
  @Resource
  DictionaryMapper dictionaryMapper;
  @Resource
  DictionaryItemMapper dictionaryItemMapper;
  @Resource
  RedisService redisService;

  /**
   * 缓存数据字典表的数据
   *
   * @author hh
   * @date 2016-11-29
   */
  @Override
  public void initSystemDictionaryCache() {
    logger.info("加载数据字典开始...");
    Long start = Calendar.getInstance().getTimeInMillis();
    // 1、清空redis,重新加载
    // redisService.deleteByPattern("*dictionary_key*");
    redisService.getList(DictionaryConstant.ALL_SYSTEM_DICT_ITEMS).delete();
    DictionaryExample dictionaryExample = new DictionaryExample();
    DictionaryExample.Criteria criteria = dictionaryExample.createCriteria();
    criteria.andIsEnabledEqualTo(DictionaryConstant.SYSTEM_DICT_IS_ENABLE);
    List<com.gqcp.dictionary.dao.model.Dictionary> dictionaryList = dictionaryMapper.selectByExample(dictionaryExample);
    // key为dict_id,value为user_type在字表的列表
    List<Map<String, Object>> allSystemDictItems =
        redisService.getList(DictionaryConstant.ALL_SYSTEM_DICT_ITEMS);
    if (dictionaryList != null && dictionaryList.size() > 0) {
      for (com.gqcp.dictionary.dao.model.Dictionary dictionary : dictionaryList) {
        boolean isShut = true;
        DictionaryItem dictionaryItem = new DictionaryItem();
        dictionaryItem.setDictId(dictionary.getId());
        List<DictionaryItem> dictionaryItems = this.selectSystemItemById(dictionaryItem);
        if (dictionaryItems != null && dictionaryItems.size() > 0) {
          Map<String, Object> map = new HashMap<String, Object>();
          for (DictionaryItem item : dictionaryItems) {
            if (isShut) {
              redisService.getRList(DictionaryConstant.SYSTEM_DICTIONARY_KEY + dictionary.getId()
                  + item.getSystemId()).delete();
              isShut = false;
            }
            RList<Object> rList = redisService.getRList(
                DictionaryConstant.SYSTEM_DICTIONARY_KEY + dictionary.getId() + item.getSystemId());
            rList.add(item);
          }
          map.put(dictionary.getId(), dictionaryItems);
          allSystemDictItems.add(map);
        }
      }
    }
    Long end = Calendar.getInstance().getTimeInMillis();
    logger.info("加载数据字典结束...");
    logger.info("用时:" + (end - start) / 1000);
  }

  @Override
  public List<DictionaryItem> selectSystemItemById(DictionaryItem dictionaryItem) {
    DictionaryItemExample dictionaryItemExample = new DictionaryItemExample();
    dictionaryItemExample.setOrderByClause("sort asc");
    DictionaryItemExample.Criteria criteria = dictionaryItemExample.createCriteria();
    if (StringUtils.isNotBlank(dictionaryItem.getDictId())) {
      criteria.andDictIdEqualTo(dictionaryItem.getDictId());
    }
    List<DictionaryItem> dictionaryItemList =
        dictionaryItemMapper.selectByExample(dictionaryItemExample);
    return dictionaryItemList;
  }

  @Override
  public List<DictionaryItem> selectItemListFromRedis(String id, String systemId) {
    RList<DictionaryItem> rList =
        redisService.getRList(DictionaryConstant.SYSTEM_DICTIONARY_KEY + id + systemId);
    return rList;
  }

  @Override
  public DictionaryItem selectItemEntityFromRedis(String id, String code, String systemId) {
    RList<DictionaryItem> rList =
        redisService.getRList(DictionaryConstant.SYSTEM_DICTIONARY_KEY + id + systemId);
    for (DictionaryItem item : rList) {
      if (item.getCode().equals(code)) {
        return item;
      }
    }
    return null;
  }

  @Override
  public ResponseEntity selectDictParamsByParams(String dictParams, String sysId)
      throws BusinessException {
    Map<String, Object> map = new HashMap<String, Object>();
    RList<Object> rList =
        redisService.getRList(DictionaryConstant.SYSTEM_DICTIONARY_KEY + dictParams + sysId);
    map.put(dictParams, rList);
    return ResponseEntityUtil.success(map);
  }


}

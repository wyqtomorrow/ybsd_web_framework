package com.gqcp.area.service.impl;

import java.util.*;

import javax.annotation.Resource;

import com.gqcp.area.dao.model.AreaExample;
import com.gqcp.area.mcontroller.res.AreaResponseForm;
import com.gqcp.area.service.AreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.gqcp.area.dao.mapper.AreaMapper;
import com.gqcp.common.Constant;
import com.gqcp.redis.service.RedisService;

@Service
public class AreaServiceImpl implements AreaService {
  static Logger logger = LoggerFactory.getLogger(AreaServiceImpl.class);

  @Resource
  AreaMapper areaMapper;

  @Resource
  RedisService redisService;

  @Override
  public void initArea() {
    logger.info("加载省市区数据开始...");
    Long start = Calendar.getInstance().getTimeInMillis();
    // 1、清空redis,重新加载
    redisService.getList("allProvinces").delete();
    redisService.getMap("allCities").delete();
    // 省数据
    List<Map<Long, Object>> redisAllProvinces = redisService.getList("allProvinces");
    // 每个省份对应的城市:key为省份ID,value为省下的有城市列表
    Map<Long, List<Map<Long, Object>>> allCities = new HashMap<Long, List<Map<Long, Object>>>();
    // 2、查询数据库数据
    AreaExample example = new AreaExample();
    byte isEnabled = 1;
    example.createCriteria().andParentIdIsNotNull().andIsEnabledEqualTo(isEnabled);
    List<AreaResponseForm> listAll = areaMapper.selectAreaListByExample(example);
    // 3、构造数据
    for (AreaResponseForm area : listAll) {
      if (area.getParentId() != null) {
        Long areaId = area.getAreaId().longValue();
        redisService.getRBucket(Constant.SESSION_SYSTEM_AREA_KEY + "" + areaId).set(area);
        redisService.getRBucket(Constant.SESSION_SYSTEM_AREA_KEY + "" + area.getAxis()).set(area);
        Map<Long, Object> map = new HashMap<Long, Object>();
        map.put(area.getAreaId().longValue(), area);
        if (area.getParentId() == 0 && area.getRank() == 1) {
          // 放入redis
          redisAllProvinces.add(map);
        } else {
          if (allCities.containsKey(area.getParentId().longValue())) {
            List<Map<Long, Object>> listCity = allCities.get(area.getParentId().longValue());
            listCity.add(map);
          } else {
            List<Map<Long, Object>> cityList = new LinkedList<Map<Long, Object>>();
            cityList.add(map);
            allCities.put(area.getParentId().longValue(), cityList);
          }
        }
      }
    }
    Map<Long, List<Map<Long, Object>>> redisAllCities = redisService.getMap("allCities");
    for (Map.Entry<Long, List<Map<Long, Object>>> entry : allCities.entrySet()) {
      redisAllCities.put(entry.getKey(), entry.getValue());
    }
    Long end = Calendar.getInstance().getTimeInMillis();
    logger.info("加载省市区数据结束...");
    logger.info("用时:" + (end - start) / 1000);
  }

  @Override
  public List<Map<Long, Object>> getAllProvinces() {
    List<Map<Long, Object>> list = redisService.getList("allProvinces");
    return list;
  }

  @Override
  public List<Map<Long, Object>> getAllCitysByProvinceId(Long provinceId) {
    List<Map<Long, Object>> list = (LinkedList) redisService.getMap("allCities").get(provinceId);
    return list;
  }

  @Override
  public List<Long> getChilderByProvinceId(List<Long> ids, Integer level, List<Long> listRet) {
    while (level > 0) {
      List<Long> listChild = new ArrayList<Long>();
      // 获取孩子节点
      for (Long parentId : ids) {
        List<Map<Long, Object>> list = getAllCitysByProvinceId(parentId);
        for (Map<Long, Object> map : list) {
          for (Map.Entry entry : map.entrySet()) {
            String key = (String) entry.getKey();
            listChild.add(Long.parseLong(key));
            listRet.add(Long.parseLong(key));
          }
        }
      }
      level--;
      getChilderByProvinceId(listChild, level, listRet);
    }
    return listRet;
  }

  public List<String> getChilderAxisByProvinceId(List<Long> ids, Integer level,
      List<String> listRet) {
    while (level > 0) {
      List<Long> listChild = new ArrayList<Long>();
      // 获取孩子节点
      for (Long parentId : ids) {
        List<Map<Long, Object>> list = getAllCitysByProvinceId(parentId);
        for (Map<Long, Object> map : list) {
          for (Map.Entry entry : map.entrySet()) {
            String key = (String) entry.getKey();
            AreaResponseForm af = (AreaResponseForm) entry.getValue();
            listChild.add(Long.parseLong(key));
            listRet.add(af.getAxis());
          }
        }
      }
      level--;
      getChilderAxisByProvinceId(listChild, level, listRet);
    }
    return listRet;
  }

  @Override
  public AreaResponseForm getAreaById(Long areaId) {
    AreaResponseForm areaResponseForm = (AreaResponseForm) redisService
        .getRBucket(Constant.SESSION_SYSTEM_AREA_KEY + "" + areaId).get();
    return areaResponseForm;
  }

  @Override
  public AreaResponseForm getAreaByAxis(String axis) {
    AreaResponseForm areaResponseForm = (AreaResponseForm) redisService
        .getRBucket(Constant.SESSION_SYSTEM_AREA_KEY + "" + axis).get();
    return areaResponseForm;
  }
}

package com.gqcp.dictionary.service;

import com.gqcp.common.exception.business.BusinessException;
import com.gqcp.common.page.ResponseEntity;
import com.gqcp.dictionary.dao.model.DictionaryItem;

import java.util.List;

/**
 * Created by hh on 2016/11/29.
 */
public interface DictionaryService {

    /**
     * 缓存数据字典表的数据
     * @author hh
     * @date 2016-11-29
     */
    void initSystemDictionaryCache();

    /**
     * 根据主表ID查询字表集合
     * @author hh
     * @date 2016-11-29
     */
    List<DictionaryItem> selectSystemItemById(DictionaryItem dictionaryItem);

    /**
     * 从缓存取，根据主表id查询字表list
     *@author hh
     *@date 21:17 2016/12/1
     */
    List<DictionaryItem> selectItemListFromRedis(String id,String systemId);

    /**
     * 从缓存区，根据主表id和从表code，获取详细的从表实体
     *@author hh
     *@date 21:24 2016/12/1
     */
    DictionaryItem selectItemEntityFromRedis(String id,String code,String systemId);


    /**
     * 根据页面传值，返回查询所需信息
     *@author hh
     *@date 15:38 2016/12/2
     */
    ResponseEntity selectDictParamsByParams(String dictParams,String sysId)throws BusinessException;
}

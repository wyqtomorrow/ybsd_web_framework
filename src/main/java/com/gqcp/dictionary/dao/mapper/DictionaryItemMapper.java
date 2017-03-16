package com.gqcp.dictionary.dao.mapper;

import com.gqcp.dictionary.dao.model.DictionaryItem;
import com.gqcp.dictionary.dao.model.DictionaryItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DictionaryItemMapper {
    int countByExample(DictionaryItemExample example);

    int deleteByExample(DictionaryItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DictionaryItem record);

    int insertSelective(DictionaryItem record);

    List<DictionaryItem> selectByExample(DictionaryItemExample example);

    DictionaryItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DictionaryItem record, @Param("example")
    DictionaryItemExample example);

    int updateByExample(@Param("record") DictionaryItem record, @Param("example")
    DictionaryItemExample example);

    int updateByPrimaryKeySelective(DictionaryItem record);

    int updateByPrimaryKey(DictionaryItem record);
}

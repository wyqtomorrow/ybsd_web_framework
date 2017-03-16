package com.gqcp.dictionary.dao.mapper;

import com.gqcp.dictionary.dao.model.Dictionary;
import com.gqcp.dictionary.dao.model.DictionaryExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DictionaryMapper {
    int countByExample(DictionaryExample example);

    int deleteByExample(DictionaryExample example);

    int deleteByPrimaryKey(String id);

    int insert(Dictionary record);

    int insertSelective(Dictionary record);

    List<Dictionary> selectByExample(DictionaryExample example);

    Dictionary selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Dictionary record, @Param("example")
    DictionaryExample example);

    int updateByExample(@Param("record") Dictionary record, @Param("example")
    DictionaryExample example);

    int updateByPrimaryKeySelective(Dictionary record);

    int updateByPrimaryKey(Dictionary record);
}

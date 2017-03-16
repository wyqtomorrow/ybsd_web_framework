package com.gqcp.simple.dao.mapper;

import java.util.List;

import com.gqcp.simple.dao.model.Simple;
import org.apache.ibatis.annotations.Param;

import com.gqcp.simple.dao.model.SimpleExample;
import org.springframework.stereotype.Repository;

@Repository
public interface SimpleMapper {
    int countByExample(SimpleExample example);

    int deleteByExample(SimpleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Simple record);

    int insertSelective(Simple record);

    List<Simple> selectByExample(SimpleExample example);

    Simple selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Simple record, @Param("example") SimpleExample example);

    int updateByExample(@Param("record") Simple record, @Param("example") SimpleExample example);

    int updateByPrimaryKeySelective(Simple record);

    int updateByPrimaryKey(Simple record);
}
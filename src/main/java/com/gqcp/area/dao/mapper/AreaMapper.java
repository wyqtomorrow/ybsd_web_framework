package com.gqcp.area.dao.mapper;

import java.util.List;

import com.gqcp.area.dao.model.AreaExample;
import com.gqcp.area.mcontroller.res.AreaResponseForm;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.gqcp.area.dao.model.Area;

@Repository
public interface AreaMapper {
  int countByExample(AreaExample example);

  int deleteByExample(AreaExample example);

  int deleteByPrimaryKey(Integer areaId);

  int insert(Area record);

  int insertSelective(Area record);

  List<Area> selectByExample(AreaExample example);

  Area selectByPrimaryKey(Integer areaId);

  int updateByExampleSelective(@Param("record") Area record, @Param("example") AreaExample example);

  int updateByExample(@Param("record") Area record, @Param("example") AreaExample example);

  int updateByPrimaryKeySelective(Area record);

  int updateByPrimaryKey(Area record);

  /**
   * 
   * @Title: selectAreaListByExample
   * @Description: 返回列表
   * @param example
   * @return List<AreaResponseForm>
   *
   */
  List<AreaResponseForm> selectAreaListByExample(AreaExample example);
}

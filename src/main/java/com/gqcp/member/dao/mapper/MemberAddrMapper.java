package com.gqcp.member.dao.mapper;

import com.gqcp.member.dao.model.MemberAddr;
import com.gqcp.member.dao.model.MemberAddrExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberAddrMapper {
  int countByExample(MemberAddrExample example);

  int deleteByExample(MemberAddrExample example);

  int deleteByPrimaryKey(Long id);

  int insert(MemberAddr record);

  int insertSelective(MemberAddr record);

  List<MemberAddr> selectByExample(MemberAddrExample example);

  MemberAddr selectByPrimaryKey(Long id);

  int updateByExampleSelective(@Param("record") MemberAddr record,
      @Param("example") MemberAddrExample example);

  int updateByExample(@Param("record") MemberAddr record,
      @Param("example") MemberAddrExample example);

  int updateByPrimaryKeySelective(MemberAddr record);

  int updateByPrimaryKey(MemberAddr record);
}

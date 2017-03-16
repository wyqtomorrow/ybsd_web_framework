package com.gqcp.member.dao.mapper;

import com.gqcp.member.dao.model.MemberLogin;
import com.gqcp.member.dao.model.MemberLoginExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberLoginMapper {
    int countByExample(MemberLoginExample example);

    int deleteByExample(MemberLoginExample example);

    int deleteByPrimaryKey(Long boId);

    int insert(MemberLogin record);

    int insertSelective(MemberLogin record);

    List<MemberLogin> selectByExample(MemberLoginExample example);

    MemberLogin selectByPrimaryKey(Long boId);

    int updateByExampleSelective(@Param("record") MemberLogin record, @Param("example") MemberLoginExample example);

    int updateByExample(@Param("record") MemberLogin record, @Param("example") MemberLoginExample example);

    int updateByPrimaryKeySelective(MemberLogin record);

    int updateByPrimaryKey(MemberLogin record);
}
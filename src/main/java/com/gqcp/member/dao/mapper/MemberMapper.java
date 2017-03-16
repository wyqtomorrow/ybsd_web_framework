package com.gqcp.member.dao.mapper;

import com.gqcp.member.dao.model.Member;
import com.gqcp.member.dao.model.MemberExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface MemberMapper {
    int countByExample(MemberExample example);

    int deleteByExample(MemberExample example);

    int deleteByPrimaryKey(Long boId);

    int insert(Member record);

    int insertSelective(Member record);

    List<Member> selectByExample(MemberExample example);

    Member selectByPrimaryKey(Long boId);

    int updateByExampleSelective(@Param("record") Member record, @Param("example") MemberExample example);

    int updateByExample(@Param("record") Member record, @Param("example") MemberExample example);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);
}
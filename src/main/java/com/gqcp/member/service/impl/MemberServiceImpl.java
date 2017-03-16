package com.gqcp.member.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.gqcp.common.exception.business.BusinessException;
import com.gqcp.member.dao.mapper.MemberMapper;
import com.gqcp.member.dao.model.Member;
import com.gqcp.member.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
  static Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
  @Resource
  MemberMapper memberMapper;

  @Override
  public Member selMemberByBoId(Long boId) throws BusinessException {
    return memberMapper.selectByPrimaryKey(boId);
  }
}

package com.gqcp.member.service;

import com.gqcp.common.exception.business.BusinessException;
import com.gqcp.member.dao.model.Member;

public interface MemberService {

  Member selMemberByBoId(Long boId) throws BusinessException;
}

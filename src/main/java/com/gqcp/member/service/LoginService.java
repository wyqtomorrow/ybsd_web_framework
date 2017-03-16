package com.gqcp.member.service;

import com.gqcp.member.mcontroller.res.MemberResForm;

public interface LoginService {

  /**
   * @MethodName: loginMember
   * @Description: 登录
   * @author YS
   * @createTime 2016/12/2 16:04
   */
  MemberResForm loginMember(String username, String password);

}

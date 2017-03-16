package com.gqcp.member.mcontroller;

import javax.annotation.Resource;
import javax.validation.Valid;

import com.gqcp.member.mcontroller.res.MemberResForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gqcp.common.page.ResponseEntity;
import com.gqcp.common.page.ResponseEntityUtil;
import com.gqcp.common.web.BaseController;
import com.gqcp.member.mcontroller.req.LoginReqForm;
import com.gqcp.member.service.LoginService;

/**
 * @author YS yanshuang@nxin.com
 * @ClassName: LoginMController
 * @Description: 登录移动端
 * @createTime 2016/12/1 19:01
 */
@RestController
@RequestMapping(value = "/mob/member", produces = MediaType.APPLICATION_JSON_VALUE)
public class LoginMController extends BaseController {

  static Logger logger = LoggerFactory.getLogger(LoginMController.class);
  @Resource
  LoginService loginService;

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public ResponseEntity<MemberResForm> sendLogin(@Valid LoginReqForm form) throws Exception {
    MemberResForm memberResForm =
        loginService.loginMember(form.getMobilePhone(), form.getPassword());
    return ResponseEntityUtil.success(memberResForm);
  }
}

package com.gqcp.member.service.impl;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.gqcp.common.Constant;
import com.gqcp.common.exception.Errors;
import com.gqcp.common.exception.business.BusinessException;
import com.gqcp.common.security.TokenRedisHandler;
import com.gqcp.common.utils.MD5;
import com.gqcp.common.utils.copy.BeanUtilsEx;
import com.gqcp.member.dao.mapper.MemberLoginMapper;
import com.gqcp.member.dao.model.Member;
import com.gqcp.member.dao.model.MemberLogin;
import com.gqcp.member.dao.model.MemberLoginExample;
import com.gqcp.member.mcontroller.res.MemberResForm;
import com.gqcp.member.service.LoginService;
import com.gqcp.member.service.MemberService;
import com.gqcp.redis.service.RedisService;

@Service
public class LoginServiceImpl implements LoginService {
  static Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
  @Resource
  RedisService redisService;
  @Resource
  MemberService memberService;
  @Resource
  MemberLoginMapper memberLoginMapper;

  @Override
  public MemberResForm loginMember(String mobilePhone, String password) throws BusinessException {
    String encryption = MD5.encryption(password + Constant.SYS_ID);
    // 1、判断用户是否存在
    MemberLogin memberLogin = getMemberLoginUserInfo(mobilePhone);
    // 2、判断用户密码是否正确
    if (!encryption.equals(memberLogin.getLoginPwd())) {
      logger.info("密码错误");
      throw new BusinessException(Errors.BUSI_PASSWORD_WRONG_ERROR);
    }
    Member member = memberService.selMemberByBoId(memberLogin.getBoId());
    if (null == member) {
      logger.info("用户信息错误");
      throw new BusinessException(Errors.BUSI_USER_IS_NOT_HAVE_ERROR);
    }
    if (member.getIsEnabled() == 0) {
      logger.info("由于您的账号存在异常情况，已被官方工作人员禁用");
      throw new BusinessException(Errors.BUSI_MEMBER_STATUS_DISABLED);
    }

    // 将member放入redis
    String token = TokenRedisHandler.generatorRedisCookieToken(member.getMobilePhone());
    MemberResForm mrf = new MemberResForm();
    try {
      BeanUtilsEx.copyProperties(mrf,member);
    } catch (Exception e) {
      e.printStackTrace();
    }
    mrf.setToken(token);
    // 将当前时间设置到缓存中
    mrf.setUpTokenTime(new Date());
    // 存储token-->boid
    redisService.getRBucket(Constant.CURR_USER_INFO_TOKEN + ":" + token).set(mrf.getBoId(),
        Constant.LOGIN_LOCKING_TIME, TimeUnit.DAYS);
    // 存储boid-->userInfo
    redisService.getRBucket(Constant.CURR_USER_TICKET + String.valueOf(mrf.getBoId())).set(mrf,
        Constant.LOGIN_LOCKING_TIME, TimeUnit.DAYS);
    return mrf;
  }

  private MemberLogin getMemberLoginUserInfo(String userName) throws BusinessException {
    MemberLoginExample example = new MemberLoginExample();
    example.createCriteria().andLoginNameEqualTo(userName);
    // .andIsEnabledEqualTo(new Byte(Constant.COMMONE_ONE));
    List<MemberLogin> list = memberLoginMapper.selectByExample(example);
    if (list == null) {
      logger.info("用户不存在");
      throw new BusinessException(Errors.BUSI_USER_IS_NOT_HAVE_ERROR);
    }
    if (list.size() != 1) {
      logger.info("用户多余一条记录");
      throw new BusinessException(Errors.BUSI_USER_IS_NOT_HAVE_ERROR);
    }
    MemberLogin memberLogin = list.get(0);
    if (memberLogin.getIsEnabled() == 0) {
      logger.info("由于您的账号存在异常情况，已被官方工作人员禁用");
      throw new BusinessException(Errors.BUSI_MEMBER_STATUS_DISABLED);
    }
    return memberLogin;
  }
}

package com.gqcp.common.web;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.gqcp.common.Constant;
import com.gqcp.common.exception.Errors;
import com.gqcp.common.exception.business.BusinessException;
import com.gqcp.common.utils.Base64ImageUtils;
import com.gqcp.common.utils.cookie.CookieUtils;
import com.gqcp.common.utils.copy.BeanUtilsEx;
import com.gqcp.member.dao.model.Member;
import com.gqcp.member.mcontroller.res.MemberResForm;
import com.gqcp.member.service.MemberService;
import com.gqcp.redis.service.RedisService;

@Component
public class BaseController {
  static Logger logger = LoggerFactory.getLogger(BaseController.class);

  @Resource
  private RedisService redisService;
  @Resource
  private MemberService memberService;

  /**
   *
   * @Description: 获得UserInfo缓存
   * @author YS
   * @createTime 2016/12/6 20:05
   */
  public MemberResForm getUserInfo(HttpServletRequest request) throws BusinessException {
    String tokenId = CookieUtils.getCookieTokenId(request);
    logger.info("tokenId===" + tokenId);
    Long boId = (Long) redisService.getRBucket(Constant.CURR_USER_INFO_TOKEN + tokenId).get();
    if (boId == null) {
      logger.info("获取用户信息失败!");
      throw new BusinessException(Errors.SYSTEM_NOT_LOGIN);
    }
    MemberResForm member = (MemberResForm) redisService
        .getRBucket(Constant.CURR_USER_TICKET + String.valueOf(boId)).get();
    if (member == null) {
      logger.info("获取用户信息失败!");
      throw new BusinessException(Errors.SYSTEM_NOT_LOGIN);
    }
    return member;
  }

  /**
   *
   * @Description: 修改UserInfo缓存
   * @author YS
   * @createTime 2016/12/6 20:06
   */
  public boolean updUserInfo(HttpServletRequest request, Long boId)
      throws BusinessException, UnsupportedEncodingException {
    String tokenId = CookieUtils.getCookieTokenId(request);
    MemberResForm memberForm = new MemberResForm();
    Member member = memberService.selMemberByBoId(boId);
    try {
      BeanUtilsEx.copyProperties(memberForm,member);
    } catch (Exception e) {
      e.printStackTrace();
    }
    memberForm.setToken(tokenId);

    // 存储token-->boid
    redisService.getRBucket(Constant.CURR_USER_INFO_TOKEN + ":" + tokenId).set(memberForm.getBoId(),
            Constant.LOGIN_LOCKING_TIME, TimeUnit.DAYS);
    // 存储boid-->userInfo
    redisService.getRBucket(Constant.CURR_USER_TICKET + String.valueOf(memberForm.getBoId()))
        .set(memberForm, Constant.LOGIN_LOCKING_TIME, TimeUnit.DAYS);

    if (null == redisService.getRBucket(Constant.CURR_USER_INFO_TOKEN + tokenId).get()) {
      return false;
    }
    return true;
  }

  /**
   * 输入参数转换
   * 
   * @param request
   * @param clazz
   * @return
   */
  public Object getZntRequestParaJson(HttpServletRequest request, Class<?> clazz) {
    Object object = null;
    try {
      InputStream is = request.getInputStream();
      String zntObj = IOUtils.toString(is, "UTF-8");
      String jsonStr = Base64ImageUtils.getFromBase64(zntObj);
      logger.info("请求数据:___" + jsonStr);
      object = JSON.parseObject(jsonStr, clazz);
    } catch (Exception e) {
      e.printStackTrace();
      logger.error("___请求失败参数错误____");
    }
    return object;
  }
}

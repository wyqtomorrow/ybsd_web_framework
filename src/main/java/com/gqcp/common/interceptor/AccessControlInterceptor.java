package com.gqcp.common.interceptor;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gqcp.common.security.TokenHelper;
import com.gqcp.common.interceptor.core.ICoreNxinCheckInterceptor;
import com.gqcp.common.interceptor.wrapper.CoreNxinInterceptorUserAuthWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.gqcp.common.Constant;
import com.gqcp.common.interceptor.core.CheckResult;
import com.gqcp.common.interceptor.core.CheckResult.Result;
import com.gqcp.common.interceptor.wrapper.CoreNxinInterceptorCheckTokenWrapper;
import com.gqcp.redis.service.RedisService;

@Component
public class AccessControlInterceptor extends HandlerInterceptorAdapter {
  static Logger logger = LoggerFactory.getLogger(AccessControlInterceptor.class);
  @Resource
  private RedisService redisService;

  @Resource(name = "core")
  ICoreNxinCheckInterceptor core;

  @Resource
  CoreNxinInterceptorCheckTokenWrapper coreCheckTokenWrapper;

  @Resource
  CoreNxinInterceptorUserAuthWrapper coreUserAuthWrapper;

  @PostConstruct
  public void init() {
    coreCheckTokenWrapper.setiCoreNxinCheckInterceptor(core);
    coreUserAuthWrapper.setiCoreNxinCheckInterceptor(coreCheckTokenWrapper);
  }

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {

    CheckResult checkResult = coreUserAuthWrapper.doWork(request, response, handler);
    if (checkResult.getResult() == Result.SUCCESS) {
      return true;
    } else {
      if (checkResult.getIsRedirect()) {
        try {
          response.sendRedirect(checkResult.getRedirectUrl());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      return false;
    }
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView) throws Exception {

    // 2、方法授权
    HandlerMethod handlerMethod = (HandlerMethod) handler;
    Method method = handlerMethod.getMethod();
    AccessToken annotation = method.getAnnotation(AccessToken.class);
    if (annotation != null) {
      if (annotation.is_access()) {
        // 1、生成token
        String token = TokenHelper.generateGUID();
        logger.info("_____存入token值_" + token);
        redisService.getRBucket(Constant.REDIS_FORM_TOKEN_KEY + token).set(token, 60,
            TimeUnit.MINUTES);

        // 2、设置token(redis/cookie)
        TokenHelper.setCookieToken(token, response);
      }
    }
  }
}

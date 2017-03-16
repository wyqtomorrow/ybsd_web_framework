package com.gqcp.common.interceptor.core;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;

import com.gqcp.common.interceptor.SysAuthority;
import com.gqcp.common.interceptor.SysAuthority.PrivilegeLevel;
import com.gqcp.common.interceptor.core.CheckResult.Builder;
import com.gqcp.common.interceptor.core.CheckResult.Result;

@Component("core")
public class CoreNxinCheckInterceptor implements ICoreNxinCheckInterceptor {
  static Logger logger = LoggerFactory.getLogger(CoreNxinCheckInterceptor.class);

  private static final List<String> noLoginResources = new ArrayList<String>() {
    private static final long serialVersionUID = 1L;
    {
      // swagger相关资源不需要登录
    }
  };

  @Override
  public CheckResult doWork(HttpServletRequest rq, HttpServletResponse rs, Object handler) {
    Builder builder = new CheckResult.Builder();

    // 1、 手动定义不需要进行访问控制的资源过滤
    String uri = rq.getRequestURI();
    for (String resource : noLoginResources) {
      if (uri.startsWith(resource)) {
        return builder.result(Result.SUCCESS).build();
      }
    }

    // 2、方法授权
    HandlerMethod handlerMethod = (HandlerMethod) handler;
    Method method = handlerMethod.getMethod();
    SysAuthority annotation = method.getAnnotation(SysAuthority.class);
    if (annotation != null) {
      PrivilegeLevel level = annotation.level();
      if (level == PrivilegeLevel.ALL_PRIVILEGE) {
        builder.result(Result.SUCCESS);
      } else {
        logger.info("权限配置错误");
        builder.result(Result.FAIL).message("权限配置错误");
      }
    }else{
      builder.result(Result.FAIL);
    }
    return builder.build();
  }

}

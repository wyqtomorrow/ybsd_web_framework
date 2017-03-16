package com.gqcp.common.interceptor.wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gqcp.common.interceptor.core.ICoreNxinCheckInterceptor;
import org.springframework.stereotype.Component;

import com.gqcp.common.interceptor.core.CheckResult;

/**
 * 
 * @ClassName: CoreNxinInterceptorWrapper
 * @Description: 装饰器类-用来装饰核心类
 * @author wangyongqing
 * @date 2016-9-18 下午3:26:14
 * 
 */
@Component("coreCheckWrapper")
public class CoreNxinCheckInterceptorWrapper implements ICoreNxinCheckInterceptor {

  ICoreNxinCheckInterceptor iCoreNxinCheckInterceptor;

  @Override
  public CheckResult doWork(HttpServletRequest rq, HttpServletResponse rs, Object handler) {
    return iCoreNxinCheckInterceptor.doWork(rq, rs, handler);
  }

  public ICoreNxinCheckInterceptor getiCoreNxinCheckInterceptor() {
    return iCoreNxinCheckInterceptor;
  }

  public void setiCoreNxinCheckInterceptor(ICoreNxinCheckInterceptor iCoreNxinCheckInterceptor) {
    this.iCoreNxinCheckInterceptor = iCoreNxinCheckInterceptor;
  }
}

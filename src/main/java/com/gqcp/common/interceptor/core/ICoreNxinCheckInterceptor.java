package com.gqcp.common.interceptor.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ICoreNxinCheckInterceptor {

  /**
   * <p>
   * Description: 每一个角色实现的具体方法
   * </p>
   * 
   * @author wyq
   * @date 创建时间：2016-9-14 上午9:14:26
   * @version 1.0
   * @return
   */
  public CheckResult doWork(HttpServletRequest rq, HttpServletResponse rs, Object handler);
}

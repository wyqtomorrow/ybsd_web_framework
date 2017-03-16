package com.gqcp.common.exception;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.stereotype.Component;

@Component
public class AsyncExceptionHandler implements AsyncUncaughtExceptionHandler {
  static Logger logger = LoggerFactory.getLogger(AsyncExceptionHandler.class);
  @Override
  public void handleUncaughtException(Throwable ex, Method method, Object... params) {
    logger.info("调用异步任务出错了, message : " + ex.getMessage());
  }

}

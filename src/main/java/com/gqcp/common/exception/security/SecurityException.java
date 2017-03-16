package com.gqcp.common.exception.security;

import com.gqcp.common.exception.common.CommonException;

/**
 * 安全异常时抛出该异常
 * 
 */
public class SecurityException extends CommonException {

  private static final long serialVersionUID = 1L;

  public SecurityException(String msg, Throwable t) {
    super(msg, t);
  }

  public SecurityException(String msg) {
    super(msg);
  }

  public SecurityException() {
    super();
  }

  public SecurityException(Throwable cause) {
    super(cause);
  }

  protected SecurityException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

}

package com.gqcp.common.exception.common;

public class CommonException extends RuntimeException {

  private static final long serialVersionUID = 1L;
  
  public CommonException() {
    super();
  }
  
  public CommonException(String msg, Throwable t) {
      super(msg, t);
  }

  public CommonException(String msg) {
      super(msg);
  }

  public CommonException(Throwable cause) {
      super(cause);
  }

  protected CommonException(String message, Throwable cause,
                             boolean enableSuppression,
                             boolean writableStackTrace) {
      super(message, cause, enableSuppression, writableStackTrace);
  }
}

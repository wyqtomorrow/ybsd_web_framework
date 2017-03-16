package com.gqcp.common.exception.other;

import com.gqcp.common.exception.common.CommonException;

public class AjaxException extends CommonException {
  private static final long serialVersionUID = 1L;

  public AjaxException(String msg, Throwable t) {
    super(msg, t);
  }

  public AjaxException(String msg) {
    super(msg);
  }

  public AjaxException() {
    super();
  }

  public AjaxException(Throwable cause) {
    super(cause);
  }

  protected AjaxException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}

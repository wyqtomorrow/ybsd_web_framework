package com.gqcp.common.exception.business;

import com.gqcp.common.exception.Errors;
import com.gqcp.common.exception.security.AuthenticationException;

public class ParameterException extends AuthenticationException{
  private static final long serialVersionUID = -4310721413425427596L;
  /**
   * 错误码
   */
  private int code = Errors.SYSTEM_ERROR.code;

  /**
   * 分类错误
   */
  private String category = Errors.SYSTEM_ERROR.categoryLable;

  /**
   * 错误码的说明
   */
  private String label = Errors.SYSTEM_ERROR.label;

  public ParameterException() {
    super();
  }

  /**
   * 构造函数
   * 
   * @param code：错误码
   * @param codeLabel：错误码说明
   */
  public ParameterException(int code, String categoryLable, String codeLabel) {
    super(codeLabel);
    setCode(code);
    setLabel(codeLabel);
    setCategory(categoryLable);
  }

  /**
   * 构造函数
   * 
   * @param code：错误码
   * @param codeLabel：错误码说明
   * @param message：异常说明
   */
  public ParameterException(int code, String categoryLable, String codeLabel, String message) {
    super(message);
    setCode(code);
    setLabel(codeLabel);
    setCategory(categoryLable);
  }

  /**
   * 构造函数
   * 
   * @param code：错误码
   * @param codeLabel：错误码说明
   * @param message：异常说明
   * @param cause
   */
  public ParameterException(int code, String categoryLable, String codeLabel, String message,
      Throwable cause) {
    super(message, cause);
    setCode(code);
    setLabel(codeLabel);
    setCategory(categoryLable);
  }


  /**
   * 构造函数
   * 
   * @param error：错误码
   */
  public ParameterException(Errors error) {
    super(error.label);
    setCode(error.code);
    setLabel(error.label);
    setCategory(error.categoryLable);
  }

  /**
   * 构造函数
   * 
   * @param error：错误码
   * @param message：异常说明
   */
  public ParameterException(Errors error, String message) {
    super(message);
    setCode(error.code);
    setLabel(error.label);
    setCategory(error.categoryLable);
  }

  /**
   * 构造函数
   * 
   * @param error：错误码
   * @param message：异常说明
   * @param cause
   */
  public ParameterException(Errors error, String message, Throwable cause) {
    super(message, cause);
    setCode(error.code);
    setLabel(error.label);
    setCategory(error.categoryLable);
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }


  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }
}

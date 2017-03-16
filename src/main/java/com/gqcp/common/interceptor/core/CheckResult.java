package com.gqcp.common.interceptor.core;

public class CheckResult {

  private Result result;

  /**
   * 失败信息
   */
  private String message;

  /**
   * 是否需要重定向
   */
  private Boolean isRedirect;

  /**
   * 重定向url
   */
  private String redirectUrl;

  public Result getResult() {
    return result;
  }

  public void setResult(Result result) {
    this.result = result;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Boolean getIsRedirect() {
    return isRedirect;
  }

  public void setIsRedirect(Boolean isRedirect) {
    this.isRedirect = isRedirect;
  }

  public String getRedirectUrl() {
    return redirectUrl;
  }

  public void setRedirectUrl(String redirectUrl) {
    this.redirectUrl = redirectUrl;
  }

  public static class Builder {

    private Result result;

    /**
     * 失败信息
     */
    private String message;

    /**
     * 是否需要重定向
     */
    private Boolean isRedirect;

    /**
     * 重定向url
     */
    private String redirectUrl;

    public Builder result(Result result) {
      this.result = result;
      return this;
    }

    public Builder message(String message) {
      this.message = message;
      return this;
    }

    public Builder isRedirect(Boolean isRedirect) {
      this.isRedirect = isRedirect;
      return this;
    }

    public Builder redirectUrl(String redirectUrl) {
      this.redirectUrl = redirectUrl;
      return this;
    }

    public CheckResult build() { // 构建，返回一个新对象
      return new CheckResult(this);
    }

  }

  public CheckResult(Builder b) {
    this.result = b.result;
    this.message = b.message;
    this.isRedirect = b.isRedirect;
    this.redirectUrl = b.redirectUrl;
  }

  public enum Result {
    SUCCESS(1, "成功"), FAIL(2, "失败");
    private int code;
    private String desc;

    private Result(int code, String desc) {
      this.code = code;
      this.desc = desc;
    }

    public int getCode() {
      return code;
    }

    public void setCode(int code) {
      this.code = code;
    }

    public String getDesc() {
      return desc;
    }

    public void setDesc(String desc) {
      this.desc = desc;
    }

  }
}

package com.gqcp.common.enums;

/**
 * Created with IntelliJ IDEA. User: lenovo Date: 2016/12/7 Time: 12:54 To change this template use
 * File | Settings | File Templates.
 */
public enum UserAuditStatus {
  CS("CS", "初始"), TG("TG", "审核通过"), BTG("BTG", "审核不通过"), DSH("DSH", "申请待审核");
  private String code;
  private String desc;

  private UserAuditStatus(String code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }
}

package com.gqcp.common.enums;

/**
 * Created with IntelliJ IDEA. User: lenovo Date: 2016/12/10 Time: 12:00 To change this template use
 * File | Settings | File Templates.
 */
public enum BusTypeEnum {
  TX("TX", "用户头像"), SP("SP", "商品图片");
  private String code;
  private String desc;

  private BusTypeEnum(String code, String desc) {
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

package com.gqcp.common.enums;

/**
 * Created with IntelliJ IDEA. User: lenovo Date: 2016/12/3 Time: 15:43 To change this template use
 * File | Settings | File Templates.
 */
public enum GoodsSaleTypeEnum {
  ZY("ZY", "自营"), DX("DX", "代销"), JJ("JJ", "竞价");
  private String code;
  private String desc;

  private GoodsSaleTypeEnum(String code, String desc) {
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

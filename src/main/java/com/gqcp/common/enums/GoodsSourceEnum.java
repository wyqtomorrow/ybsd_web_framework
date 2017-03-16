package com.gqcp.common.enums;

/**
 * Created with IntelliJ IDEA. User: lenovo Date: 2016/12/3 Time: 15:58 To change this template use
 * File | Settings | File Templates.
 */
public enum GoodsSourceEnum {
  PC("PC", "PC"), APP("APP", "APP"), H5("H5", "H5"), ZNT("ZNT", "智农通"), WX("WX", "微信"), HT("HT",
      "后台");
  private String code;
  private String desc;

  private GoodsSourceEnum(String code, String desc) {
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

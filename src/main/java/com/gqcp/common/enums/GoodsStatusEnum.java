package com.gqcp.common.enums;

/**
 * Created with IntelliJ IDEA. User: lenovo Date: 2016/12/3 Time: 14:53 To change this template use
 * File | Settings | File Templates.
 */
public enum GoodsStatusEnum {
  INIT("CS", "初始"), UN_VERIFY("WSH", "未审核"), VERIFY_PASS("TG", "审核通过"), VERIFY_UN_PASS("BTG",
      "审核不通过"), WAIT_SELL("DS",
          "等待出售"), ON_LIEN("SJ", "上架"), OFF_LIEN("XJ", "下架"), SELLED("YS", "已售");
  private String code;
  private String desc;

  private GoodsStatusEnum(String code, String desc) {
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

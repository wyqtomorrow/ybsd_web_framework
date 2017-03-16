package com.gqcp.common.enums;

/**
 * Created with IntelliJ IDEA. User: lenovo Date: 2016/12/10 Time: 12:01 To change this template use
 * File | Settings | File Templates.
 */
public enum FileTypeEnum {
  IMAGE("IMAGE", "图片"), VIDEO("VIDEO", "视频");
  private String code;
  private String desc;

  private FileTypeEnum(String code, String desc) {
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

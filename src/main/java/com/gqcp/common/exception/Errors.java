package com.gqcp.common.exception;

/**
 * 错误码
 *
 */
public enum Errors {
  // 0-200 系统级
  SUCCESS(0, "系统错误", "操作成功"),
  //
  SYSTEM_ERROR(1, "系统错误", "系统错误"),
  // 自定义错误，可以修改label
  SYSTEM_CUSTOM_ERROR(2, "系统错误", "自定义错误"),
  //
  SYSTEM_DATA_ERROR(3, "系统错误", "数据异常"),
  //
  SYSTEM_DATA_NOT_FOUND(4, "系统错误", "数据不存在"),
  //
  SYSTEM_NOT_LOGIN(5, "系统错误", "请登录"),
  //
  SYSTEM_UPDATE_ERROR(6, "系统错误", "数据更新失败"),
  //
  SYSTEM_NO_ACCESS(7, "系统错误", "无权限访问"),
  //
  SYSTEM_REQUEST_PARAM_ERROR(8, "系统错误", "请求参数错误"),

  SYSTEM_BUSINESS_ERROR(9, "系统错误", "系统繁忙,请您稍后再试"),
  //
  SYSTEM_DATE_TRANS_ERROR(101, "业务错误", "日期转换错误"),
  //
  BUSI_USER_AGREE_ERROR(102, "业务错误", "用户正在审核中"),
  //
  BUSI_GOODS_VERSION_ERROR(103, "业务错误", "插入商品版本错误"),
  //
  BUSI_GOODS_ATTR_VERSION_ERROR(104, "业务错误", "插入商品属性版本错误"),
  //
  BUSI_GOODS_SPEC_VERSION_ERROR(105, "业务错误", "插入商品规格版本错误"),
  //
  BUSI_GOODS_QUERY_ERROR(106, "业务错误", "该商品不存在"),
  //
  BUSI_GOODS_DELETED_ERROR(107, "业务错误", "该商品已经删除"),
  //
  BUSI_GOODS_SPEC_RET_MORE_ERROR(108, "业务错误", "该商品无规格信息"),
  //
  BUSI_GOODS_SPEC_COUNT_NOT_ENOUGH_ERROR(109, "业务错误", "该商品数量不足"),
  //
  BUSI_GOODS_IS_NOT_SJ_ERROR(110, "业务错误", "商品非上架状态，无法下单"),
  //
  BUSI_GOODS_SPEC_NUM_NOT_ENOUGH_ERROR(111, "业务错误", "商品库存量小于下单数量，无法下单"),
  //
  BUSI_ORDER_IS_NOT_FOUND_ERROR(112,"业务错误","该订单不存在"),
  //
  BUSI_ORDER_IS_DELETE_ERROR(113,"业务错误","该订单已经删除"),
  //
  BUSI_ORDER_IS_DONE_ERROR(114,"业务错误","该订单已经完成"),
  //
  BUSI_ORDER_IS_CLOSED_ABNORMAL_ERROR(115,"业务错误","该订单已经取消"),
  //
  BUSI_ORDER_IS_PAYMENT_ERROR(116,"业务错误","该订单已经支付"),
  //
  BUSI_GOODS_IS_SELF_ERROR(117,"业务错误","不可购买自己的商品"),
  //
  BUSI_SEND_MSG_ERROR(201, "业务错误", "发送短信错误"),
  //
  BUSI_SEND_MSG_REDIS_ERROR(202, "业务错误", "5分钟内不能重复发送短信"),
  //
  BUSI_SEND_MSG_OUT_TIME_ERROR(203, "业务错误", "验证码输入错误，请重新填写"),
  //
  BUSI_SEND_MSG_IDENTIFYINGCODE_ERROR(204, "业务错误", "验证码错误"),
  //
  BUSI_USER_IS_HAVE_ERROR(205, "业务错误", "用户已经存在"),
  //
  BUSI_USER_IS_NOT_HAVE_ERROR(206, "业务错误", "账号输入错误，请重新填写!"),
  //
  BUSI_LOGIN_WROMG_MAX_ERROR(207, "业务错误", "错误达到上限"),
  //
  BUSI_PASSWORD_WRONG_ERROR(208, "业务错误", "密码输入错误，请重新填写！"),

  BUSI_USER_RET_NUMBER_ERROR(209, "业务错误", "返回用户记录数错误"),

  BUSI_USER_UPD_HEAD_ICON_ERROR(210, "业务错误", "上传图片失败"),

  BUSI_MEMBER_FAV_IS_NOT_ISENABLED(211, "业务错误", "已取消收藏"),

  BUSI_MEMBER_FAV_IS_ISENABLED(212, "业务错误", "已收藏"),

  BUSI_MEMBER_STATUS_DISABLED(213, "业务错误", "由于您的账号存在异常情况，已被官方工作人员禁用"),

  BUSI_USER_LOGIN_ERROR(-2, "业务错误", "登录错误"),

  BUSI_USER_TOKEN_INVALID_ERROR(-1, "业务错误", "token invalid"),

  BUSI_USER_UPDATE_INVALID_ERROR(-3, "业务错误", "更新失败"),

  BUSI_USER_DELETE_TOKEN_INVALID_ERROR(-4, "业务错误", "删除原TOKEN失败"),

  BUSI_DICTIONARY_REDIS_ERROR(301, "缓存错误", "数据字典表缓存不存在"),

  FORM_TOKEN_INVALID_ERROR(302, "业务错误", "token invalid be form submit"),

  FORM_TOKEN_DIFFERENCE_ERROR(303, "业务错误", "token值不同"),

  BUSI_UPD_SHOP_WRONG_ERROR(401, "业务错误", "店铺更新失败"),

  BUSI_ADD_TAG_WRONG_ERROR(501, "业务错误", "标签插入失败");


  public int code;
  public String categoryLable;
  public String label;

  private Errors(int code, String categoryLable, String label) {
    this.code = code;
    this.categoryLable = categoryLable;
    this.label = label;
  }

  /**
   * 
   * @param code
   * @return
   */
  public static String getLabel(int code) {
    String result = "";
    for (Errors status : Errors.values()) {
      if (status.code == code) {
        result = status.label;
      }
    }
    return result;
  }

}

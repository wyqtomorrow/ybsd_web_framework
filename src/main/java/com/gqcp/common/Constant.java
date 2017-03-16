package com.gqcp.common;

public class Constant {

  /**
   * 生成token,存储该token对应的boid
   */
  public static final String CURR_USER_INFO_TOKEN = "ticketCookie:";

  /**
   * 存储BOID对应的form
   */
  public static final String CURR_USER_TICKET = "ticketUserInfoCookie:";

  /**
   * 表单token属性
   */
  public static final String REDIS_FORM_TOKEN_KEY = "redis:formToken:";

  public static final String COOKIE_FORM_TOKEN_KEY = "cookie:formToken";

  public static final String RES_FORM_TOKEN_KEY = "formToken";


  /**
   * redis nxds_system_area 地区表
   */
  public static final String SESSION_SYSTEM_AREA_KEY = "redis:system_area:";


  /**
   * 通用0
   */
  public static final byte COMMONE_ZERO = 0;

  /**
   * 通用1
   */
  public static final byte COMMONE_ONE = 1;

  /**
   * 系统ID
   */
  public static final byte SYS_ID = 1;

  /**
   * @Description: redis用户过期时间
   * @author YS
   * @createTime 2016/12/5 23:10
   */
  public static Integer USERINFO_OUT_TIME = 30;

  /**
   * TOKEN存活时间5个小时
   */
  public static final int TOKEN_EXITS_TIME = 5 * 3600 * 1000;

  /**
   * 数据在缓存中存活时间
   */
  public static Integer LOGIN_LOCKING_TIME = 7;

  /**
   * 七牛配置
   */
  public static final String QINIU_BACK_PATH = "QINIU_BACK_PATH";
  public static final String ACCESS_KEY = "ACCESS_KEY";
  public static final String SECRET_KEY = "SECRET_KEY";
  public static final String BUCKET_NAME = "BUCKET_NAME";
  public static final String MOVIES_TO_IMG_1 = "?vframe/jpg/offset/1";
  public static final String PIPELINE_KEY = "PIPELINE";
}

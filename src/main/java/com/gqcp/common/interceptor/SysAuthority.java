package com.gqcp.common.interceptor;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysAuthority {
  /**
   * 模块名称
   * 
   * @return
   */
  String moduleName();

  /**
   * 权限级别
   * 
   * @return
   */
  PrivilegeLevel level();


  public enum PrivilegeLevel {
    ALL_PRIVILEGE(10, false, "可以被任何人访问"), LOGIN_GET_PRIVILEGE(20, true,
        "只能被GET方法请求"), LOGIN_DELETE_PRIVILEGE(30, true, "只能被删除方法请求"), LOGIN_PUT_PRIVILEGE(40, true,
            "只能被添加方法请求"), LOGIN_POST_PRIVILEGE(50, true, "只能被修改方法请求");

    /**
     * 是否需要登录
     */
    private Boolean isLogin;

    /**
     * 权限级别
     */
    private Integer level;

    /**
     * 级别描述
     */
    private String levelDesc;

    private PrivilegeLevel(Integer p_level, Boolean p_isLogin, String p_desc) {
      this.level = p_level;
      this.isLogin = p_isLogin;
      this.levelDesc = p_desc;
    }

    public Boolean getIsLogin() {
      return isLogin;
    }

    public void setIsLogin(Boolean isLogin) {
      this.isLogin = isLogin;
    }

    public Integer getLevel() {
      return level;
    }

    public void setLevel(Integer level) {
      this.level = level;
    }

    public static PrivilegeLevel resolve(Integer level) {
      switch (level) {
        case 10:
          return ALL_PRIVILEGE;
        case 20:
          return LOGIN_GET_PRIVILEGE;
        case 30:
          return LOGIN_DELETE_PRIVILEGE;
        case 40:
          return LOGIN_PUT_PRIVILEGE;
        case 50:
          return LOGIN_POST_PRIVILEGE;
        default:
          return null;
      }
    }
  }
}

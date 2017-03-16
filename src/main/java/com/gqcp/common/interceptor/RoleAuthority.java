package com.gqcp.common.interceptor;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RoleAuthority {
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
  Role level();


  public enum Role {
    TRANSACTION(101, "驴交易大数据"), MANAGER(102, "驴管理大数据");

    /**
     * 权限级别
     */
    private Integer level;

    /**
     * 级别描述
     */
    private String levelDesc;

    private Role(Integer p_level, String p_desc) {
      this.level = p_level;
      this.levelDesc = p_desc;
    }

    public Integer getLevel() {
      return level;
    }

    public void setLevel(Integer level) {
      this.level = level;
    }

    public String getLevelDesc() {
      return levelDesc;
    }

    public void setLevelDesc(String levelDesc) {
      this.levelDesc = levelDesc;
    }

    public static Role resolve(Integer level) {
      switch (level) {
        case 101:
          return TRANSACTION;
        case 102:
          return MANAGER;
        default:
          return null;
      }
    }
  }
}

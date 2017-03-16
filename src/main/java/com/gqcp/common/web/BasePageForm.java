package com.gqcp.common.web;

import java.io.Serializable;

public class BasePageForm implements Serializable  {

  /**  
  * @Fields serialVersionUID : TODO
  */  
  private static final long serialVersionUID = 1L;

  /**
   * 当前页
   */
  private Integer pageNum;
  
  /**
   * 每页多少条
   */
  private Integer pageSize;
  /**
   * 排序参数
   */
  private Integer sortParam;
  /**
   *分组参数
   */
  private Integer groupParam;
  /**
   * 查询条件参数
   */
  private Integer typeParam;

  public Integer getPageNum() {
    return pageNum;
  }

  public void setPageNum(Integer pageNum) {
    this.pageNum = pageNum;
  }

  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public Integer getSortParam() {
    return sortParam;
  }

  public void setSortParam(Integer sortParam) {
    this.sortParam = sortParam;
  }

  public Integer getGroupParam() {
    return groupParam;
  }

  public void setGroupParam(Integer groupParam) {
    this.groupParam = groupParam;
  }

  public Integer getTypeParam() {
    return typeParam;
  }

  public void setTypeParam(Integer typeParam) {
    this.typeParam = typeParam;
  }
}

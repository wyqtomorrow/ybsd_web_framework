package com.gqcp.common.page;

import java.io.Serializable;

public class PageResult implements Serializable {

  private static final long serialVersionUID = 1L;

  private int currPageNum; // 当前页数
  private int totalPage; // 总页数

  public int getCurrPageNum() {
    return currPageNum;
  }

  public void setCurrPageNum(int currPageNum) {
    this.currPageNum = currPageNum;
  }

  public int getTotalPage() {
    return totalPage;
  }

  public void setTotalPage(int totalPage) {
    this.totalPage = totalPage;
  }


}

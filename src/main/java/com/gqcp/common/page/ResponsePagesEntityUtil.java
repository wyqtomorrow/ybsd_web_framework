package com.gqcp.common.page;

import com.github.pagehelper.PageInfo;

public class ResponsePagesEntityUtil<T> extends ResponseEntity<T> {
  private static final long serialVersionUID = 1L;
  /**
   * pagination相关信息
   */
  private PageInfo<?> page;

  public PageInfo<?> getPage() {
    return page;
  }

  public void setPage(PageInfo<?> page) {
    this.page = page;
  }
}

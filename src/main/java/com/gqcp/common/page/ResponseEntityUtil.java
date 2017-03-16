package com.gqcp.common.page;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.github.pagehelper.PageInfo;
import com.gqcp.common.exception.Errors;

public class ResponseEntityUtil {

  public static <T> ResponseEntity<T> success(T data) {
    ResponseEntity<T> entity = new ResponseEntity<T>();
    entity.setData(data);
    entity.setCode(Errors.SUCCESS.code);
    entity.setHttpStatus(HttpStatusCode.OK.value());
    return entity;
  }

  public static <T> ResponsePagesEntityUtil<List<?>> successPages(List<?> data) {
    ResponsePagesEntityUtil<List<?>> entity = new ResponsePagesEntityUtil<List<?>>();
    entity.setData(data);
    entity.setCode(Errors.SUCCESS.code);
    entity.setHttpStatus(HttpStatusCode.OK.value());
    entity.setPage(new PageInfo(data));
    return entity;
  }

  public static <T> ResponsePagesEntityUtil<List<?>> successPages(List<?> data, PageInfo pageInfo) {
    ResponsePagesEntityUtil<List<?>> entity = new ResponsePagesEntityUtil<List<?>>();
    entity.setData(data);
    entity.setCode(Errors.SUCCESS.code);
    entity.setHttpStatus(HttpStatusCode.OK.value());
    entity.setPage(pageInfo);
    return entity;
  }

  public static ResponseEntity<Void> success() {
    ResponseEntity<Void> entity = build();
    entity.setCode(Errors.SUCCESS.code);
    entity.setHttpStatus(HttpStatusCode.OK.value());
    return entity;
  }

  public static ResponseEntity<Void> fail(Integer httpStatus, Integer code, String message,
      HttpServletRequest request) {
    ResponseEntity<Void> entity = build();
    entity.setCode(code);
    entity.setHttpStatus(httpStatus);
    entity.setException(message);
    if (null != request) {
      entity.setPath(request.getRequestURI());
    }
    return entity;
  }

  public static ResponseEntity<Void> fail(Errors error) {
    ResponseEntity<Void> entity = build();
    entity.setCode(error.code);
    entity.setException(error.label);
    return entity;
  }

  private static ResponseEntity<Void> build() {
    ResponseEntity<Void> entity = new ResponseEntity<Void>();
    entity.setTimestamp(Long.valueOf(System.currentTimeMillis()));
    return entity;
  }

}

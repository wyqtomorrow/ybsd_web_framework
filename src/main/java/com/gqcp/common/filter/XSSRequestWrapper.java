package com.gqcp.common.filter;

import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletRequest;

public class XSSRequestWrapper extends HttpServletRequestWrapper {
  public XSSRequestWrapper(HttpServletRequest servletRequest) {
    super(servletRequest);
  }

  @Override
  public String[] getParameterValues(String parameter) {
    String[] values = super.getParameterValues(parameter);
    if (values == null) {
      return null;
    }
    int count = values.length;
    String[] encodedValues = new String[count];
    for (int i = 0; i < count; i++) {
      encodedValues[i] = stripXSS(values[i]);
    }
    return encodedValues;
  }

  @Override
  public String getParameter(String parameter) {
    String value = super.getParameter(parameter);
    return stripXSS(value);
  }

  @Override
  public String getHeader(String name) {
    String value = super.getHeader(name);
    return stripXSS(value);
  }

  private String stripXSS(String s) {
    if (s == null || s.equals("")) {
      return s;
    }
    StringBuilder sb = new StringBuilder(s.length() + 16);
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      switch (c) {
        case '>':
          sb.append('＞');// 全角大于号
          break;
        case '<':
          sb.append('＜');// 全角小于号
          break;
        case '\'':
          sb.append('‘');// 全角单引号
          break;
        case '\"':
          sb.append('“');// 全角双引号
          break;
        case '&':
          sb.append('＆');// 全角
          break;
        case '\\':
          sb.append('＼');// 全角斜线
          break;
        // case '#':
        // sb.append('＃');//全角井号
        // break;
        default:
          sb.append(c);
          break;
      }
    }
    return sb.toString();
  }
}

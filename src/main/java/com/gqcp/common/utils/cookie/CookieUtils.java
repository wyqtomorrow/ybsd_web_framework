package com.gqcp.common.utils.cookie;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.gqcp.common.Constant;
import com.gqcp.common.exception.business.BusinessException;
import org.apache.commons.lang.StringUtils;


/**
 * @author wyq
 * @ClassName: CookieUtils
 * @Description: 操作cookies(这里用一句话描述这个类的作用)
 * @date 2016/12/7 10:09
 */
public class CookieUtils {
  public static String getCookieTokenId(HttpServletRequest request) throws BusinessException {
    // 1、从cookie中获取token
    Cookie[] cookies = request.getCookies();// 这样便可以获取一个cookie数组
    for (Cookie cookie : cookies) {
      String cookieName = cookie.getName();
      if (cookieName.equals(Constant.CURR_USER_INFO_TOKEN)) {
        // 2、根据token获取用户信息
        // 对特殊字符反编码
        try {
          if (StringUtils.isNotBlank(cookie.getValue()) && !cookie.getValue().equals("null")) {
            String cookieValue = URLDecoder.decode(cookie.getValue(), "UTF-8");
            return cookieValue;
          }
        } catch (UnsupportedEncodingException e) {
          e.printStackTrace();
        }
      }
    }
    return "";
  }
}

package com.gqcp.common.security;

import com.gqcp.common.utils.MD5;
import com.gqcp.common.utils.date.DateFormatUtils;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.Date;

/**
 * @author wyq
 * @ClassName: TokenRedisHandler
 * @Description: 生成token(这里用一句话描述这个类的作用)
 * @date 2016/12/7 15:19
 */
public class TokenRedisHandler {
  public static String generatorRedisCookieToken(String username) {
    String hashed = BCrypt.hashpw(username, BCrypt.gensalt());
    return hashed;
  }

  public static String generatorCookieToken(Long boId, Date createTime) {
    String encryToken = MD5.encryption(boId + "" + DateFormatUtils.formatDate(createTime, "yyyyMMddHHmmss"));
    return encryToken;
  }

  public static void main(String[] args) {
    Date date  = new Date();
    System.out.println(generatorCookieToken(1l, date));
    System.out.println(generatorCookieToken(1l,date));
  }
}

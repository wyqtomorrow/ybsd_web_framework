package com.gqcp.common.exception;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.gqcp.common.exception.business.BusinessException;
import com.gqcp.common.exception.business.ParameterException;
import com.gqcp.common.page.ResponseEntity;

@Component
public class CommonExceptionHandler implements HandlerExceptionResolver {
  static Logger logger = LoggerFactory.getLogger(CommonExceptionHandler.class);
  @Override
  public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
      Object handler, Exception ex) {
    logger.error("error--->" + DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss") + "异常信息",
        ex);
    Map<String, Object> model = new HashMap<String, Object>();
    model.put("ex", ex);

    if ((request.getHeader("accept") != null
        && request.getHeader("accept").contains("application/json"))
        || (request.getHeader("content-type") != null
            && request.getHeader("content-type").contains("application/json"))
        || (request.getHeader("X-Requested-With") != null
            && request.getHeader("X-Requested-With").contains("XMLHttpRequest"))) {
      logger.error("content-type:" + request.getHeader("content-type"));
      logger.error("ajax异常:"+ex.getMessage());
      String messaget = ex.getMessage();

      // ajax请求异常拦截
      try {
        PrintWriter writer = response.getWriter();
        ResponseEntity re = new ResponseEntity();
        BusinessException be = (BusinessException) ex;
        if(messaget.contains("断开的管道")){
          re.setCode(10001);
          re.setException("断开的管道");
        }else{
          re.setCode(be.getCode());
          re.setException(ex.getMessage());
        }
        String jsonErr = JSON.toJSONString(re);
        writer.write(jsonErr);
        writer.flush();
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else {
      logger.error("普通异常");
      if (ex instanceof NumberFormatException) {
        return new ModelAndView("exception/error", model);
      } else if (ex instanceof NullPointerException) {
        return new ModelAndView("exception/error", model);
      } else if (ex instanceof BusinessException) {
        BusinessException bs = (BusinessException) ex;
        ModelAndView view = new ModelAndView("exception/error");
        view.addObject("ex", bs);
        return view;
      } else if (ex instanceof ParameterException) {
        return new ModelAndView("exception/error", model);
      } else if (ex instanceof SocketTimeoutException || ex instanceof ConnectException) {
        try {
          PrintWriter writer = response.getWriter();
          writer.write("网络异常");
          writer.flush();
        } catch (IOException e) {
          e.printStackTrace();
        }
        return new ModelAndView("exception/net_error", model);
      }
    }
    return new ModelAndView("exception/exception", model);
  }
}

package com.gqcp.common.utils.http;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.util.Map;

import org.apache.commons.httpclient.ConnectTimeoutException;
import org.apache.commons.lang.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

public class HttpUtils extends HttpclientBaseConfig {
  private static final Logger log = LoggerFactory.getLogger(HttpUtils.class);

  public static JSONObject doPost(String url, String jsonFormString) throws Exception {
    HttpClient client = HttpClients.createDefault();
    HttpPost post = new HttpPost(url);
    post.addHeader("text/plain", "UTF-8");
    post.addHeader("Content-Type", "application/json");

    log.info("POST请求内容：{}", jsonFormString);

    StringEntity s = new StringEntity(jsonFormString, "UTF-8");
    post.setEntity(s);
    HttpResponse httpResponse = client.execute(post);

    JSONObject response = null;
    if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
      String result = EntityUtils.toString(httpResponse.getEntity());// 返回json格式：
      response = JSONObject.parseObject(result);
    } else {
      String errorMsg = EntityUtils.toString(httpResponse.getEntity());
      throw new RuntimeException(errorMsg);
    }

    return response;
  }

  public static String doGet(String url) throws Exception {
    HttpClient client = HttpClients.createDefault();
    HttpGet get = new HttpGet(url);
    get.setHeader("Content-Type", "application/json; charset=UTF-8");

    String response = null;
    HttpResponse httpResponse = client.execute(get);
    if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
      response = EntityUtils.toString(httpResponse.getEntity());// 返回json格式：
    } else {
      String errorMsg = EntityUtils.toString(httpResponse.getEntity());
      throw new RuntimeException(errorMsg);
    }

    return response;
  }

  public static String doPostForm(String url, Map<String, String> params)
      throws ConnectTimeoutException, SocketTimeoutException, Exception {
    return getDataByForm(url, params, 60000, 120000);
  }

  @SuppressWarnings("all")
  public final static String getDataByForm(String url, Map<String, String> params,
      Integer connectTimeout, Integer socketTimeout)
      throws ConnectTimeoutException, SocketTimeoutException, Exception {
    if (StringUtils.isBlank(url)) {
      throw new IllegalAccessException("请求地址为空");
    }
    HttpPost postMethoed = new HttpPost(url);
    Header[] headers = setFormHeader();
    postMethoed.setHeaders(headers);

    try {
      UrlEncodedFormEntity urlEntity = setReqParams(params);
      if (null != urlEntity) {
        postMethoed.setEntity(urlEntity);
      }
    } catch (UnsupportedEncodingException e) {
      log.error("set request params error<url:" + url + ">,error info:" + e.getMessage());
      throw new IllegalAccessException(e.getMessage());
    }

    RequestConfig reqConfig = setReqConfig(connectTimeout, socketTimeout);
    if (null != reqConfig) {
      postMethoed.setConfig(reqConfig);
    }
    CloseableHttpResponse response = null;
    String result = null;
    HttpEntity entity = null;
    try {
      response = getHttpclient().execute(postMethoed);
      entity = response.getEntity();
      if (null != entity) {
        result = EntityUtils.toString(entity, "UTF-8");
      }
    } catch (ClientProtocolException e) {
      log.error("get reqeust data errro<url:" + url + ">,error info:" + e.getMessage());
    } catch (IOException e) {
      log.error("get reqeust data errro<url:" + url + ">,error info:" + e.getMessage());
      if (e instanceof ConnectTimeoutException) {
        throw new ConnectTimeoutException("请求连接超时");
      } else if (e instanceof SocketTimeoutException) {
        throw new SocketTimeoutException("服务器响应超时");
      } else {
        throw e;
      }
    } finally {
      try {
        close(entity, postMethoed, response);
      } catch (IOException io) {
        throw new IOException("关闭HttpClient请求异常");
      }
    }
    return result;
  }
}

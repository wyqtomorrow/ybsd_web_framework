package com.gqcp.common.utils.http;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;

public class HttpclientBaseConfig extends HttpclientBaseBuilder {

	protected static final String CONTENT_TYPE_FORM = "application/x-www-form-urlencoded;charset=utf-8";
	protected static final String USER_AGENT = "Mozilla/4.0 (compatible;MSIE 6.0; Windows NT 5.1; SV1; .NET CLR 1.1.4322)";
	// 请求连接超时时间
	protected static final Integer HTTP_CLIENT_CONNECTION_TIME_OUT = 60000;
	// 服务器响应超时时间
	protected static final Integer HTTP_CLIENT_SOCKET_TIME_OUT = 120000;

	/**
	 * 设置Http Request请求配置信息
	 * 
	 * @param connectTimeout
	 * @param socketTimeout
	 * @return
	 */
	protected static final RequestConfig setReqConfig(Integer connectTimeout,
			Integer socketTimeout) {
		if (null == connectTimeout && null == socketTimeout) {
			return null;
		}
		if (null != connectTimeout && null != socketTimeout
				&& connectTimeout <= 0 && socketTimeout <= 0) {
			return null;
		}
		RequestConfig.Builder builder = RequestConfig.custom();
		if (null != connectTimeout && connectTimeout.intValue() > 0) {
			// 设置请求连接超时时间
			builder.setConnectTimeout(connectTimeout);
			builder.setConnectionRequestTimeout(connectTimeout);
		}
		if (null != socketTimeout && socketTimeout.intValue() > 0) {
			// 设置服务器响应超时时间
			builder.setSocketTimeout(socketTimeout);
		}
		return builder.build();
	}

	/**
	 * 设置请求参数
	 * 
	 * @param params
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	protected static final UrlEncodedFormEntity setReqParams(
			Map<String, String> params) throws UnsupportedEncodingException {
		if (null == params || params.isEmpty()) {
			return null;
		}
		List<NameValuePair> paramsList = new ArrayList<NameValuePair>(
				params.size());
		for (Map.Entry<String, String> param : params.entrySet()) {
			paramsList.add(new BasicNameValuePair(param.getKey(), param
					.getValue()));
		}
		try {
			return new UrlEncodedFormEntity(paramsList, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new UnsupportedEncodingException("设置请求参数异常");
		}
	}

	/**
	 * 设置请求头部信息
	 * 
	 * @return
	 */
	protected static final Header[] setFormHeader() {
		BasicHeader type = new BasicHeader("Content-Type", CONTENT_TYPE_FORM);
		BasicHeader agent = new BasicHeader("User-Agent", USER_AGENT);
		return new Header[] { type, agent };
	}

	/**
	 * 关闭
	 * 
	 * @param entity
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	protected static void close(HttpEntity entity, HttpRequestBase request,
			CloseableHttpResponse response) throws IOException {
		if (null != request) {
			request.releaseConnection();
		}
		if (null != entity) {
			entity.getContent().close();
		}
		if (null != response) {
			response.close();
		}
	}
}

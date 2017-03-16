package com.gqcp.common.utils.http;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLContext;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;

import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
/**
 * 同时支持http,https(信任所有证书,不进行域名校验)双协议,采用连接池管理,在并发情况下效果会好一些
 * 
 * @author duan
 * ps : PoolingHttpClientConnectionManager和CloseableHttpClient:ThreadSafe, HttpPost:NotThreadSafe
 */
public class HttpclientBaseBuilder {
	private static CloseableHttpClient httpClient = null;
	// 创建httpclient连接池
	private static PoolingHttpClientConnectionManager httpClientConnectionManager = null;
	
	private final static byte[] syncLock = new byte[0];
	
	protected static CloseableHttpClient getHttpclient(){
		if(httpClient == null){
			synchronized (syncLock) {
				if(httpClient == null){
					httpClient = initHttpClient();
				}				
			}
		}
		return httpClient;
	}
		
	private static CloseableHttpClient initHttpClient() {
		RegistryBuilder<ConnectionSocketFactory> registryBuilder = RegistryBuilder.<ConnectionSocketFactory> create();
		PlainConnectionSocketFactory plainsf = PlainConnectionSocketFactory.getSocketFactory();
		SSLContext sslContext;
		CloseableHttpClient httpClient = null;
		try {
			sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
				@Override
				public boolean isTrusted(java.security.cert.X509Certificate[] chain, String authType)throws CertificateException {
					return true;
				}
			}).build();
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext,SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
			registryBuilder = registryBuilder.register("https", sslsf);
			registryBuilder = registryBuilder.register("http", plainsf);
			httpClientConnectionManager = new PoolingHttpClientConnectionManager(registryBuilder.build());
			httpClientConnectionManager.setMaxTotal(100); 			// 最大连接数设置为100
			httpClientConnectionManager.setDefaultMaxPerRoute(5); 	// 每个域名最连接数为5
			CookieStore cookieStore = new BasicCookieStore();
			HttpClientBuilder httpClientBuilder = HttpClients.custom().setConnectionManager(httpClientConnectionManager).setDefaultCookieStore(cookieStore);
			RequestConfig globalconfig = RequestConfig.custom().setRedirectsEnabled(true).setCookieSpec(CookieSpecs.BROWSER_COMPATIBILITY).build();
			httpClient = httpClientBuilder.setDefaultRequestConfig(globalconfig).build();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (KeyStoreException e) {
			e.printStackTrace();
		}
		return httpClient;
	}
}
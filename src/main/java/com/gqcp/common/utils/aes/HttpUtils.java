package com.gqcp.common.utils.aes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.Principal;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 * Created by lenovo on 2017/3/13.
 */
public class HttpUtils {
    /**
     * 分析url字符串,采用utf-8解码
     * @param urlString
     * @return
     */
    public static Request parse(String urlString) {
        return parse(urlString, "utf-8");
    }

    /**
     * 分析url字符串,指定字符集进行解码
     * @param urlString
     * @param enc
     * @return
     */
    public static Request parse(String urlString, String enc) {
        if (urlString == null || urlString.length() == 0) {
            return new Request();
        }
        int questIndex = urlString.indexOf('?');
        if (questIndex == -1) {
            return new Request(urlString);
        }
        String url = urlString.substring(0, questIndex);
        String queryString = urlString.substring(questIndex + 1, urlString.length());
        return new Request(url, getParamsMap(queryString, enc));
    }

    private static Map getParamsMap(String queryString, String enc) {
        Map paramsMap = new HashMap();
        if (queryString != null && queryString.length() > 0) {
            int ampersandIndex, lastAmpersandIndex = 0;
            String subStr, param, value;
            String[] paramPair, values, newValues;
            do {
                ampersandIndex = queryString.indexOf('&', lastAmpersandIndex) + 1;
                if (ampersandIndex > 0) {
                    subStr = queryString.substring(lastAmpersandIndex, ampersandIndex - 1);
                    lastAmpersandIndex = ampersandIndex;
                } else {
                    subStr = queryString.substring(lastAmpersandIndex);
                }
                paramPair = subStr.split("=");
                param = paramPair[0];
                value = paramPair.length == 1 ? "" : paramPair[1];
                try {
                    value = URLDecoder.decode(value, enc);
                } catch (UnsupportedEncodingException ignored) {
                }
                if (paramsMap.containsKey(param)) {
                    values = (String[])paramsMap.get(param);
                    int len = values.length;
                    newValues = new String[len + 1];
                    System.arraycopy(values, 0, newValues, 0, len);
                    newValues[len] = value;
                } else {
                    newValues = new String[] { value };
                }
                paramsMap.put(param, newValues);
            } while (ampersandIndex > 0);
        }
        return paramsMap;
    }

    /**
     * 请求对象
     * @author yy
     * @date Jun 21, 2009 2:17:31 PM
     */
    public static class Request implements HttpServletRequest {
        private String requestURI;
        private Map parameterMap;

        Request() {
            this("");
        }

        Request(String requestURI) {
            this.requestURI = requestURI;
            parameterMap = new HashMap();
        }

        Request(String requestURI, Map parameterMap) {
            this.requestURI = requestURI;
            this.parameterMap = parameterMap;
        }

        /**
         * 获得指定名称的参数
         * @param name
         * @return
         */
        public String getParameter(String name) {
            String[] values = (String[])parameterMap.get(name);
            if (values != null && values.length > 0) {
                return values[0];
            }
            return null;
        }

        /**
         * 获得所有的参数名称
         * @return
         */
        public Enumeration getParameterNames() {
            return Collections.enumeration(parameterMap.keySet());
        }

        /**
         * 获得指定名称的参数值(多个)
         * @param name
         * @return
         */
        public String[] getParameterValues(String name) {
            return (String[])parameterMap.get(name);
        }

        /**
         * 获得请求的url地址
         * @return
         */
        public String getRequestURI() {
            return requestURI;
        }

        /**
         * 获得 参数-值Map
         * @return
         */
        public Map getParameterMap() {
            return parameterMap;
        }

        public String toString() {
            StringBuffer buf = new StringBuffer();
            buf.append("{");
            buf.append("\n  url = ").append(this.requestURI);
            buf.append("\n  paramsMap = {");
            if (this.parameterMap.size() > 0) {
                Iterator it = this.parameterMap.entrySet().iterator();
                while(it.hasNext()){
                    Map.Entry e=(Map.Entry)it.next();
                    buf.append(e.getKey()).append("=").append(Arrays.asList((Object[])e.getValue()).toString()).append(",");
                }
                buf.deleteCharAt(buf.length() - 1);
            }
            buf.append("}\n}");
            return buf.toString();
        }
        //  剩下的函数,自己根据需求实现了,一般返回0或者null即可
        //  这里就不贴了,HttpServletRequest的接口方法也太多了

        /* （非 Javadoc）
         * @see javax.servlet.http.HttpServletRequest#getAuthType()
         */
        public String getAuthType() {
            // TODO 自动生成方法存根
            return null;
        }

        /* （非 Javadoc）
         * @see javax.servlet.http.HttpServletRequest#getCookies()
         */
        public Cookie[] getCookies() {
            // TODO 自动生成方法存根
            return null;
        }

        /* （非 Javadoc）
         * @see javax.servlet.http.HttpServletRequest#getDateHeader(java.lang.String)
         */
        public long getDateHeader(String arg0) {
            // TODO 自动生成方法存根
            return 0;
        }

        /* （非 Javadoc）
         * @see javax.servlet.http.HttpServletRequest#getHeader(java.lang.String)
         */
        public String getHeader(String arg0) {
            // TODO 自动生成方法存根
            return null;
        }

        /* （非 Javadoc）
         * @see javax.servlet.http.HttpServletRequest#getHeaders(java.lang.String)
         */
        public Enumeration getHeaders(String arg0) {
            // TODO 自动生成方法存根
            return null;
        }

        /* （非 Javadoc）
         * @see javax.servlet.http.HttpServletRequest#getHeaderNames()
         */
        public Enumeration getHeaderNames() {
            // TODO 自动生成方法存根
            return null;
        }

        /* （非 Javadoc）
         * @see javax.servlet.http.HttpServletRequest#getIntHeader(java.lang.String)
         */
        public int getIntHeader(String arg0) {
            // TODO 自动生成方法存根
            return 0;
        }

        /* （非 Javadoc）
         * @see javax.servlet.http.HttpServletRequest#getMethod()
         */
        public String getMethod() {
            // TODO 自动生成方法存根
            return null;
        }

        /* （非 Javadoc）
         * @see javax.servlet.http.HttpServletRequest#getPathInfo()
         */
        public String getPathInfo() {
            // TODO 自动生成方法存根
            return null;
        }

        /* （非 Javadoc）
         * @see javax.servlet.http.HttpServletRequest#getPathTranslated()
         */
        public String getPathTranslated() {
            // TODO 自动生成方法存根
            return null;
        }

        /* （非 Javadoc）
         * @see javax.servlet.http.HttpServletRequest#getContextPath()
         */
        public String getContextPath() {
            // TODO 自动生成方法存根
            return null;
        }

        /* （非 Javadoc）
         * @see javax.servlet.http.HttpServletRequest#getQueryString()
         */
        public String getQueryString() {
            // TODO 自动生成方法存根
            return null;
        }

        /* （非 Javadoc）
         * @see javax.servlet.http.HttpServletRequest#getRemoteUser()
         */
        public String getRemoteUser() {
            // TODO 自动生成方法存根
            return null;
        }

        /* （非 Javadoc）
         * @see javax.servlet.http.HttpServletRequest#isUserInRole(java.lang.String)
         */
        public boolean isUserInRole(String arg0) {
            // TODO 自动生成方法存根
            return false;
        }

        /* （非 Javadoc）
         * @see javax.servlet.http.HttpServletRequest#getUserPrincipal()
         */
        public Principal getUserPrincipal() {
            // TODO 自动生成方法存根
            return null;
        }

        /* （非 Javadoc）
         * @see javax.servlet.http.HttpServletRequest#getRequestedSessionId()
         */
        public String getRequestedSessionId() {
            // TODO 自动生成方法存根
            return null;
        }

        /* （非 Javadoc）
         * @see javax.servlet.http.HttpServletRequest#getRequestURL()
         */
        public StringBuffer getRequestURL() {
            // TODO 自动生成方法存根
            return null;
        }

        /* （非 Javadoc）
         * @see javax.servlet.http.HttpServletRequest#getServletPath()
         */
        public String getServletPath() {
            // TODO 自动生成方法存根
            return null;
        }

        /* （非 Javadoc）
         * @see javax.servlet.http.HttpServletRequest#getSession(boolean)
         */
        public HttpSession getSession(boolean arg0) {
            // TODO 自动生成方法存根
            return null;
        }

        /* （非 Javadoc）
         * @see javax.servlet.http.HttpServletRequest#getSession()
         */
        public HttpSession getSession() {
            // TODO 自动生成方法存根
            return null;
        }

        @Override
        public String changeSessionId() {
            return null;
        }

        /* （非 Javadoc）
         * @see javax.servlet.http.HttpServletRequest#isRequestedSessionIdValid()
         */
        public boolean isRequestedSessionIdValid() {
            // TODO 自动生成方法存根
            return false;
        }

        /* （非 Javadoc）
         * @see javax.servlet.http.HttpServletRequest#isRequestedSessionIdFromCookie()
         */
        public boolean isRequestedSessionIdFromCookie() {
            // TODO 自动生成方法存根
            return false;
        }

        /* （非 Javadoc）
         * @see javax.servlet.http.HttpServletRequest#isRequestedSessionIdFromURL()
         */
        public boolean isRequestedSessionIdFromURL() {
            // TODO 自动生成方法存根
            return false;
        }

        /* （非 Javadoc）
         * @see javax.servlet.http.HttpServletRequest#isRequestedSessionIdFromUrl()
         */
        public boolean isRequestedSessionIdFromUrl() {
            // TODO 自动生成方法存根
            return false;
        }

        @Override
        public boolean authenticate(HttpServletResponse response) throws IOException, ServletException {
            return false;
        }

        @Override
        public void login(String username, String password) throws ServletException {

        }

        @Override
        public void logout() throws ServletException {

        }

        @Override
        public Collection<Part> getParts() throws IOException, ServletException {
            return null;
        }

        @Override
        public Part getPart(String name) throws IOException, ServletException {
            return null;
        }

        @Override
        public <T extends HttpUpgradeHandler> T upgrade(Class<T> handlerClass) throws IOException, ServletException {
            return null;
        }

        /* （非 Javadoc）
         * @see javax.servlet.ServletRequest#getAttribute(java.lang.String)
         */
        public Object getAttribute(String arg0) {
            // TODO 自动生成方法存根
            return null;
        }

        /* （非 Javadoc）
         * @see javax.servlet.ServletRequest#getAttributeNames()
         */
        public Enumeration getAttributeNames() {
            // TODO 自动生成方法存根
            return null;
        }

        /* （非 Javadoc）
         * @see javax.servlet.ServletRequest#getCharacterEncoding()
         */
        public String getCharacterEncoding() {
            // TODO 自动生成方法存根
            return null;
        }

        /* （非 Javadoc）
         * @see javax.servlet.ServletRequest#setCharacterEncoding(java.lang.String)
         */
        public void setCharacterEncoding(String arg0) throws UnsupportedEncodingException {
            // TODO 自动生成方法存根

        }

        /* （非 Javadoc）
         * @see javax.servlet.ServletRequest#getContentLength()
         */
        public int getContentLength() {
            // TODO 自动生成方法存根
            return 0;
        }

        @Override
        public long getContentLengthLong() {
            return 0;
        }

        /* （非 Javadoc）
         * @see javax.servlet.ServletRequest#getContentType()
         */
        public String getContentType() {
            // TODO 自动生成方法存根
            return null;
        }

        /* （非 Javadoc）
         * @see javax.servlet.ServletRequest#getInputStream()
         */
        public ServletInputStream getInputStream() throws IOException {
            // TODO 自动生成方法存根
            return null;
        }

        /* （非 Javadoc）
         * @see javax.servlet.ServletRequest#getProtocol()
         */
        public String getProtocol() {
            // TODO 自动生成方法存根
            return null;
        }

        /* （非 Javadoc）
         * @see javax.servlet.ServletRequest#getScheme()
         */
        public String getScheme() {
            // TODO 自动生成方法存根
            return null;
        }

        /* （非 Javadoc）
         * @see javax.servlet.ServletRequest#getServerName()
         */
        public String getServerName() {
            // TODO 自动生成方法存根
            return null;
        }

        /* （非 Javadoc）
         * @see javax.servlet.ServletRequest#getServerPort()
         */
        public int getServerPort() {
            // TODO 自动生成方法存根
            return 0;
        }

        /* （非 Javadoc）
         * @see javax.servlet.ServletRequest#getReader()
         */
        public BufferedReader getReader() throws IOException {
            // TODO 自动生成方法存根
            return null;
        }

        /* （非 Javadoc）
         * @see javax.servlet.ServletRequest#getRemoteAddr()
         */
        public String getRemoteAddr() {
            // TODO 自动生成方法存根
            return null;
        }

        /* （非 Javadoc）
         * @see javax.servlet.ServletRequest#getRemoteHost()
         */
        public String getRemoteHost() {
            // TODO 自动生成方法存根
            return null;
        }

        /* （非 Javadoc）
         * @see javax.servlet.ServletRequest#setAttribute(java.lang.String, java.lang.Object)
         */
        public void setAttribute(String arg0, Object arg1) {
            // TODO 自动生成方法存根

        }

        /* （非 Javadoc）
         * @see javax.servlet.ServletRequest#removeAttribute(java.lang.String)
         */
        public void removeAttribute(String arg0) {
            // TODO 自动生成方法存根

        }

        /* （非 Javadoc）
         * @see javax.servlet.ServletRequest#getLocale()
         */
        public Locale getLocale() {
            // TODO 自动生成方法存根
            return null;
        }

        /* （非 Javadoc）
         * @see javax.servlet.ServletRequest#getLocales()
         */
        public Enumeration getLocales() {
            // TODO 自动生成方法存根
            return null;
        }

        /* （非 Javadoc）
         * @see javax.servlet.ServletRequest#isSecure()
         */
        public boolean isSecure() {
            // TODO 自动生成方法存根
            return false;
        }

        /* （非 Javadoc）
         * @see javax.servlet.ServletRequest#getRequestDispatcher(java.lang.String)
         */
        public RequestDispatcher getRequestDispatcher(String arg0) {
            // TODO 自动生成方法存根
            return null;
        }

        /* （非 Javadoc）
         * @see javax.servlet.ServletRequest#getRealPath(java.lang.String)
         */
        public String getRealPath(String arg0) {
            // TODO 自动生成方法存根
            return null;
        }

        /* （非 Javadoc）
         * @see javax.servlet.ServletRequest#getRemotePort()
         */
        public int getRemotePort() {
            // TODO 自动生成方法存根
            return 0;
        }

        /* （非 Javadoc）
         * @see javax.servlet.ServletRequest#getLocalName()
         */
        public String getLocalName() {
            // TODO 自动生成方法存根
            return null;
        }

        /* （非 Javadoc）
         * @see javax.servlet.ServletRequest#getLocalAddr()
         */
        public String getLocalAddr() {
            // TODO 自动生成方法存根
            return null;
        }

        /* （非 Javadoc）
         * @see javax.servlet.ServletRequest#getLocalPort()
         */
        public int getLocalPort() {
            // TODO 自动生成方法存根
            return 0;
        }

        @Override
        public ServletContext getServletContext() {
            return null;
        }

        @Override
        public AsyncContext startAsync() throws IllegalStateException {
            return null;
        }

        @Override
        public AsyncContext startAsync(ServletRequest servletRequest, ServletResponse servletResponse) throws IllegalStateException {
            return null;
        }

        @Override
        public boolean isAsyncStarted() {
            return false;
        }

        @Override
        public boolean isAsyncSupported() {
            return false;
        }

        @Override
        public AsyncContext getAsyncContext() {
            return null;
        }

        @Override
        public DispatcherType getDispatcherType() {
            return null;
        }
    }
}

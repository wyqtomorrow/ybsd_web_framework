package com.gqcp.common.interceptor;

import java.lang.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 2017/1/3
 * Time: 13:45
 * To change this template use File | Settings | File Templates.
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AccessToken {
    /**
     * 模块名称
     *
     * @return
     */
    String moduleName();

    /**
     * 是否需要拦截
     * @return
     */
    boolean is_access();
}

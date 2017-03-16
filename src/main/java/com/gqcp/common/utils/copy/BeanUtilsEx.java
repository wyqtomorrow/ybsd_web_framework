package com.gqcp.common.utils.copy;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by lenovo on 2017/3/13.
 */
public class BeanUtilsEx extends BeanUtils {
    static {
        //注册util.date的转换器，即允许BeanUtils.copyProperties时的源目标的util类型的值允许为空
        ConvertUtils.register(new DateConvert(), java.util.Date.class);
        ConvertUtils.register(new DateConvert(), String.class);
    }


    public static void copyProperties(Object target, Object source) throws
            InvocationTargetException, IllegalAccessException {
        org.apache.commons.beanutils.BeanUtils.copyProperties(target, source);
    }
}

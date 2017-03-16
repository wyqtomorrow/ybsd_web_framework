package com.gqcp.dictionary;

/**
 * Created by hh on 2016/11/29.
 */
public class DictionaryConstant {

    /**
     * 数据字典表可用
     */
    public static final byte SYSTEM_DICT_IS_ENABLE = 1;
    /**
     * 数据字典表不可用
     */
    public static final byte SYSTEM_DICT_NOT_ENABLE = 0;

    /**
     * redis system_dictionary 系统数据字典key
     */
    public static final String SYSTEM_DICTIONARY_KEY = "redis:dictionary_key:";

    /**
     * redis SESSION_SYSTEM_DICTIONARY
     */
    public static final String ALL_SYSTEM_DICT_ITEMS = "redis:all_dict_items:";

    /**
     * 系统ID
     */
    public static final String SYSTEM_ID = "SYSTEM_ID";
    /**
     * 驴联网系统code
     */
    public static final String SYSTEM_CODE_LLW = "LLW";
    /**
     * 驴联网登录错误最大值
     */
    public static final String MEMBER_LOGIN_ERROR_MAX = "MEMBER_LOGIN_ERROR_MAX";
    /**
     * 驴联网登录错误最大值code
     */
    public static final String CODE_MLEM = "MLEM";

}

package com.gqcp.common.utils.signature;

/**
 * User: rizenguo
 * Date: 2014/10/29
 * Time: 14:40
 * 这里放置各种配置数据
 */
public class Configure {
	private static String key = "";

	public static String getKey() {
		return key;
	}

	public static void setKey(String key) {
		Configure.key = key;
	}
}

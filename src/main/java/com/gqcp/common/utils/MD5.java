package com.gqcp.common.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密
 * @author yhm
 */
public class MD5 {
	
	/**
	 * MD5加密
	 * @param plainText
	 * @return
	 */
	public static String md5(String plainText) {
		String result = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			//result = buf.toString(); //md5 32bit
			// result = buf.toString().substring(8, 24))); //md5 16bit
			result = buf.toString().substring(8, 24);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return result;
	}

    /**
     * 标准32位Md5加密
     * @param plainText
     * @return
     */
    public static String encryption(String plainText) {
        if(null == plainText || "".equals(plainText)){
            return "";
        }
        String re_md5 = new String();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes("utf-8"));
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            re_md5 = buf.toString();
        } catch (NoSuchAlgorithmException e) {
            return null;
        } catch (UnsupportedEncodingException e) {
            return null;
        }
        return re_md5;
    }
	public static void main(String[] args) {
		System.out.println(MD5.encryption( "2015/05/09 16:18:00" + "从猪管网到小贷~").toUpperCase());
	}
}

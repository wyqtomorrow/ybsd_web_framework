package com.gqcp.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64ImageUtils {
	/**
	 * 对Base64解码并生成图片
	 * @return 返回生成图片路径
	 * @auther lishen
	 * @date 2015-8-10
	 */
	public static boolean generateImage(String filepath, String imgStr) {
		// 对字节数组字符串进行Base64解码并生成图片12
		if (imgStr == null) // 图像数据为空
			return false;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// Base64解码 
			byte[] b = decoder.decodeBuffer(imgStr);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {// 调整异常数据
					b[i] += 256;
				}
			}
			String path = filepath.replaceAll("\\\\", "/");
			String dir = path.substring(0, path.lastIndexOf("/"));
			File file = new File(dir);
			file.mkdirs();
			// 生成jpeg图片
			OutputStream out = new FileOutputStream(filepath);
			out.write(b);
			out.flush();
			out.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	//图片转化成base64字符串  
    public static String getImageStr(String imgFile)  
    {//将图片文件转化为字节数组字符串，并对其进行Base64编码处理  
        InputStream in = null;  
        byte[] data = null;  
        //读取图片字节数组  
        try   
        {  
            in = new FileInputStream(imgFile);          
            data = new byte[in.available()];  
            in.read(data);  
            in.close();  
        }   
        catch (IOException e)   
        {  
            e.printStackTrace();  
        }  
        //对字节数组Base64编码  
        BASE64Encoder encoder = new BASE64Encoder();  
        return encoder.encode(data);//返回Base64编码过的字节数组字符串  
    }

	// 解密
	public static String getFromBase64(String s) {
		byte[] b = null;
		String result = null;
		if (s != null) {
			BASE64Decoder decoder = new BASE64Decoder();
			try {
				b = decoder.decodeBuffer(s);
				result = new String(b, "UTF-8");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	public static String getBase64(String str) {
		byte[] b = null;
		String s = null;
		try {
			b = str.getBytes("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if (b != null) {
			s = new BASE64Encoder().encode(b);
		}
		return s;
	}


	public static void main(String[] args) {
		String str="{\"d\":{\"attrs\":{\"cartNum\":\"\"},\"domains\":{\"lableList\":[{\"addrGeohash\":\"wx4eqytmxb4z\",\"addrLat\":39.983150,\"addrLon\":116.319912,\"areaId\":10,\"goodsId\":1601151405000001,\"manuId\":1,\"manuNum\":193,\"shopId\":1},{\"addrGeohash\":\"wxh13trj5f2j\",\"addrLat\":39.624787,\"addrLon\":118.200812,\"areaId\":2741,\"goodsId\":1601151423000001,\"manuId\":7,\"manuNum\":100,\"shopId\":6},{\"addrGeohash\":\"wx5jdy6rrhzs\",\"addrLat\":40.379710,\"addrLon\":116.843540,\"areaId\":21,\"goodsId\":1601151546000002,\"manuId\":9,\"manuNum\":362,\"shopId\":9},{\"addrGeohash\":\"wx4g0yk2q6jp\",\"addrLat\":39.937501,\"addrLon\":116.406358,\"areaId\":3,\"goodsId\":1601161107000001,\"manuId\":12,\"manuNum\":111,\"shopId\":12},{\"addrGeohash\":\"wwc2kdv77s1b\",\"addrLat\":38.029121,\"addrLon\":114.462999,\"areaId\":2718,\"goodsId\":1601151117000001,\"manuId\":2,\"manuNum\":20,\"shopId\":2},{\"addrGeohash\":\"ww0vc3wkh5np\",\"addrLat\":34.770676,\"addrLon\":113.618662,\"areaId\":3969,\"goodsId\":1601151544000001,\"manuId\":6,\"manuNum\":12,\"shopId\":5},{\"addrGeohash\":\"wwgqdc72y8fg\",\"addrLat\":39.118628,\"addrLon\":117.196338,\"areaId\":25,\"goodsId\":1601161449000001,\"manuId\":11,\"manuNum\":100,\"shopId\":10}]}},\"r\":0,\"m\":\"\"}";
		// Base64ImageUtils.generateImage("D://tmp1/222.jpg",Base64ImageUtils.getImageStr("D:\\IMG_0422.jpg"));
		str="eyJkIjp7ImF0dHJzIjp7ImNhcnROdW0iOiIifSwiZG9tYWlucyI6eyJsYWJsZUxpc3QiOlt7ImFk\nZHJHZW9oYXNoIjoid3g0ZXF5dG14YjR6IiwiYWRkckxhdCI6MzkuOTgzMTUwLCJhZGRyTG9uIjox\nMTYuMzE5OTEyLCJhcmVhSWQiOjEwLCJnb29kc0lkIjoxNjAxMTUxNDA1MDAwMDAxLCJtYW51SWQi\nOjEsIm1hbnVOdW0iOjE5Mywic2hvcElkIjoxfSx7ImFkZHJHZW9oYXNoIjoid3hoMTN0cmo1ZjJq\nIiwiYWRkckxhdCI6MzkuNjI0Nzg3LCJhZGRyTG9uIjoxMTguMjAwODEyLCJhcmVhSWQiOjI3NDEs\nImdvb2RzSWQiOjE2MDExNTE0MjMwMDAwMDEsIm1hbnVJZCI6NywibWFudU51bSI6MTAwLCJzaG9w\nSWQiOjZ9LHsiYWRkckdlb2hhc2giOiJ3eDVqZHk2cnJoenMiLCJhZGRyTGF0Ijo0MC4zNzk3MTAs\nImFkZHJMb24iOjExNi44NDM1NDAsImFyZWFJZCI6MjEsImdvb2RzSWQiOjE2MDExNTE1NDYwMDAw\nMDIsIm1hbnVJZCI6OSwibWFudU51bSI6MzYyLCJzaG9wSWQiOjl9LHsiYWRkckdlb2hhc2giOiJ3\nd2Mya2R2NzdzMWIiLCJhZGRyTGF0IjozOC4wMjkxMjEsImFkZHJMb24iOjExNC40NjI5OTksImFy\nZWFJZCI6MjcxOCwiZ29vZHNJZCI6MTYwMTE1MTExNzAwMDAwMSwibWFudUlkIjoyLCJtYW51TnVt\nIjoyMCwic2hvcElkIjoyfSx7ImFkZHJHZW9oYXNoIjoid3cwdmMzd2toNW5wIiwiYWRkckxhdCI6\nMzQuNzcwNjc2LCJhZGRyTG9uIjoxMTMuNjE4NjYyLCJhcmVhSWQiOjM5NjksImdvb2RzSWQiOjE2\nMDExNTE1NDQwMDAwMDEsIm1hbnVJZCI6NiwibWFudU51bSI6MTIsInNob3BJZCI6NX0seyJhZGRy\nR2VvaGFzaCI6Ind3Z3FkYzcyeThmZyIsImFkZHJMYXQiOjM5LjExODYyOCwiYWRkckxvbiI6MTE3\nLjE5NjMzOCwiYXJlYUlkIjoyNSwiZ29vZHNJZCI6MTYwMTE2MTQ0OTAwMDAwMSwibWFudUlkIjox\nMSwibWFudU51bSI6MTAwLCJzaG9wSWQiOjEwfV19fSwiciI6MCwibSI6IiJ9";
		//String baseStr=Base64ImageUtils.getBase64(str);
		str=str.replaceAll("\r\n", "");
		System.out.println(str);
		String baseStr=Base64ImageUtils.getFromBase64(str);
		System.out.println(baseStr);
		//System.out.println(baseStr);
	}
}

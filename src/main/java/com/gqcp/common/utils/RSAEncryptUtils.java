package com.gqcp.common.utils;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;



public class RSAEncryptUtils {
	
	
    

   
  public  static final String DEFAULT_PUBLIC_KEY =
    "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDT/VCO7FErEIvARallAv3wuDNJ" + "\r" +
    "dTkMc3UCqLDSvqBxDSqs9PF3A72a+iiQQNgO7X3EJVdi2Au7khMaPiHf7dz6QZ/u" + "\r" +
    "ri4V+2thLh2TtQAms4AfyHTmfFEiU9Cnf/qBDQ9Cmc4uAoIsC6Xzimga70Lkd3pm" + "\r" +
    "Zlv+QS67djhd5ev8nQIDAQAB" + "\r";
    
  
  public  static final String DEFAULT_PRIVATE_KEY =
     "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBANP9UI7sUSsQi8BF" + "\r" +
     "qWUC/fC4M0l1OQxzdQKosNK+oHENKqz08XcDvZr6KJBA2A7tfcQlV2LYC7uSExo+" + "\r" +
     "Id/t3PpBn+6uLhX7a2EuHZO1ACazgB/IdOZ8USJT0Kd/+oEND0KZzi4CgiwLpfOK" + "\r" +
     "aBrvQuR3emZmW/5BLrt2OF3l6/ydAgMBAAECgYAs6B13mVH8eG3SVi9zKXYX1z1u" + "\r" +
     "Ezn5jD++R3PlwOIF8M8Ygm7gUleJC/Mp08KxLtgUhACF/NRHcMNBLOZKJH5J1nRV" + "\r" +
     "dSifSICQ1DWiPJnuAUjTbPG78M5alpgOalEfii7OhGh9207mxmTLcOczAHEJiJa4" + "\r" +
     "cBmCOv6Cv8rLVr7hFQJBAPJh1Eh+qetILEjyJMoxtLgEldmHPi42k3cXVhUcQuGF" + "\r" +
     "s9URguQSqw2nn+ljdW6icXvnrr2UJiIOJJ2paqEGYI8CQQDf5lmB87cONEHhh0rO" + "\r" +
     "xluAEWeQ07b5JWS1sX/Xj5mD6boUZZc53CsOolVeLjFy6CTElLVbjkAmV5AljZVT" + "\r" +
     "pQ4TAkEA1+IStc87gPhzmTUzV3QWRqCu52TyGS87ASOj5IGbgEsZ9Xj3YDTQbgUT" + "\r" +
     "BUk02ymMcpPUq748iLCYJGU1N976OQJAPmE8INOY9bEjhcUe13s2NPkkZJpHySRc" + "\r" +
     "6a45UwJkH/d3a4VeW7V2nY4mwKWYC06YJ9jSql54ivYsZ/oJV5ON1wJAMeI+jjK4" + "\r" +
     "yxB7jLAOf6WayRuP5OD22DVSq+F5mBRJy4wisRXFQ44MFHlfEW/Oz0oll3PJ9zWP" + "\r" +
     "zDlN62+O7e4ywA==" + "\r"; 
     
     
     /**
      * 加密算法RSA
      */
     public static final String KEY_ALGORITHM = "RSA";
     
     /**
      * 签名算法
      */
     public static final String SIGNATURE_ALGORITHM = "MD5withRSA";

     
     
     /**
      * RSA最大加密明文大小
      */
     private static final int MAX_ENCRYPT_BLOCK = 117;
     
     /**
      * RSA最大解密密文大小
      */
     private static final int MAX_DECRYPT_BLOCK = 128;
     
     
    /** 
     * 私钥 
     */  
    private static RSAPrivateKey privateKey;  
  
    /** 
     * 公钥 
     */  
    private static RSAPublicKey publicKey;  
      
    /** 
     * 字节数据转字符串专用集合 
     */  
    private static final char[] HEX_CHAR= {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};  
      
  
    /** 
     * 获取私钥 
     * @return 当前的私钥对象 
     */  
    private static RSAPrivateKey getPrivateKey() {  
        return privateKey;  
    }  
  
    /** 
     * 获取公钥 
     * @return 当前的公钥对象 
     */  
    private static RSAPublicKey getPublicKey() {  
        return publicKey;  
    }  
  
    /** 
     * 随机生成密钥对 
     */  
    private static void genKeyPair(){  
        KeyPairGenerator keyPairGen= null;  
        try {  
            keyPairGen= KeyPairGenerator.getInstance("RSA");  
        } catch (NoSuchAlgorithmException e) {  
            e.printStackTrace();  
        }  
        keyPairGen.initialize(1024, new SecureRandom());  
        KeyPair keyPair= keyPairGen.generateKeyPair();  
        privateKey= (RSAPrivateKey) keyPair.getPrivate();  
        publicKey= (RSAPublicKey) keyPair.getPublic();  
    }  
  
    /** 
     * 从文件中输入流中加载公钥 
     * @param in 公钥输入流 
     * @throws Exception 加载公钥时产生的异常 
     */  
    public static void loadPublicKey(InputStream in) throws Exception{  
        try {  
            BufferedReader br= new BufferedReader(new InputStreamReader(in));  
            String readLine= null;  
            StringBuilder sb= new StringBuilder();  
            while((readLine= br.readLine())!=null){  
                if(readLine.charAt(0)=='-'){  
                    continue;  
                }else{  
                    sb.append(readLine);  
                    sb.append('\r');  
                }  
            }  
            loadPublicKey(sb.toString());  
        } catch (IOException e) {  
            throw new Exception("公钥数据流读取错误");  
        } catch (NullPointerException e) {  
            throw new Exception("公钥输入流为空");  
        }  
    }  
  
  
    /** 
     * 从字符串中加载公钥 
     * @param publicKeyStr 公钥数据字符串 
     * @throws Exception 加载公钥时产生的异常 
     */  
    public static void loadPublicKey(String publicKeyStr) throws Exception{  
        try {  
        	 
        	
           // byte[] buffer= org.apache.commons.codec.binary.Base64.decodeBase64(publicKeyStr);
            byte[] buffer=Base64.decode(publicKeyStr);
            KeyFactory keyFactory= KeyFactory.getInstance("RSA");  
            X509EncodedKeySpec keySpec= new X509EncodedKeySpec(buffer);  
            publicKey= (RSAPublicKey) keyFactory.generatePublic(keySpec);  
        } catch (NoSuchAlgorithmException e) {  
            throw new Exception("无此算法");  
        } catch (InvalidKeySpecException e) {  
            throw new Exception("公钥非法");  
        } catch (NullPointerException e) {  
            throw new Exception("公钥数据为空");  
        }  
    }  
  
    /** 
     * 从文件中加载私钥 
     * @param keyFileName 私钥文件名 
     * @return 是否成功 
     * @throws Exception  
     */  
    public static void loadPrivateKey(InputStream in) throws Exception{  
        try {  
            BufferedReader br= new BufferedReader(new InputStreamReader(in));  
            String readLine= null;  
            StringBuilder sb= new StringBuilder();  
            while((readLine= br.readLine())!=null){  
                if(readLine.charAt(0)=='-'){  
                    continue;  
                }else{  
                    sb.append(readLine);  
                    sb.append('\r');  
                }  
            }  
            loadPrivateKey(sb.toString());  
        } catch (IOException e) {  
            throw new Exception("私钥数据读取错误");  
        } catch (NullPointerException e) {  
            throw new Exception("私钥输入流为空");  
        }  
    }  
  
    public static void loadPrivateKey(String privateKeyStr) throws Exception{  
        try {  
        	
        	//byte[] buffer= org.apache.commons.codec.binary.Base64.decodeBase64(privateKeyStr);
            byte[] buffer=Base64.decode(privateKeyStr);
        	//byte[] buffer= base64Decoder.decodeBuffer(privateKeyStr);  
            PKCS8EncodedKeySpec keySpec= new PKCS8EncodedKeySpec(buffer);  
            KeyFactory keyFactory= KeyFactory.getInstance("RSA");  
            privateKey= (RSAPrivateKey) keyFactory.generatePrivate(keySpec);  
        } catch (NoSuchAlgorithmException e) {  
            throw new Exception("无此算法");  
        } catch (InvalidKeySpecException e) {  
        	e.printStackTrace();
            throw new Exception("私钥非法");  
        } catch (NullPointerException e) {  
            throw new Exception("私钥数据为空");  
        }  
    }  
  
  /*  *//** 
     * 加密过程 
     * @param publicKey 公钥 
     * @param plainTextData 明文数据 
     * @return 
     * @throws Exception 加密过程中的异常信息 
     *//*  
    public byte[] encrypt(RSAPublicKey publicKey, byte[] plainTextData) throws Exception{  
        if(publicKey== null){  
            throw new Exception("加密公钥为空, 请设置");  
        }  
        Cipher cipher= null;  
        try {  
           // cipher= Cipher.getInstance("RSA",new BouncyCastleProvider());//, );  
           // cipher.init(Cipher.ENCRYPT_MODE, publicKey);  
           // byte[] output= cipher.doFinal(plainTextData);  
            
            
            
            
      
             cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, publicKey);
            int inputLen = plainTextData.length;
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int offSet = 0;
            byte[] cache;
            int i = 0;
            // 对数据分段解密
            while (inputLen - offSet > 0) {
                if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
                    cache = cipher.doFinal(plainTextData, offSet, MAX_DECRYPT_BLOCK);
                } else {
                    cache = cipher.doFinal(plainTextData, offSet, inputLen - offSet);
                }
                out.write(cache, 0, cache.length);
                i++;
                offSet = i * MAX_DECRYPT_BLOCK;
            }
            byte[] decryptedData = out.toByteArray();
            out.close();
            return decryptedData;
            
            
            
     
        } catch (NoSuchAlgorithmException e) {  
            throw new Exception("无此加密算法");  
        } catch (NoSuchPaddingException e) {  
            e.printStackTrace();  
            return null;  
        }catch (InvalidKeyException e) {  
            throw new Exception("加密公钥非法,请检查");  
        } catch (IllegalBlockSizeException e) {  
            throw new Exception("明文长度非法");  
        } catch (BadPaddingException e) {  
            throw new Exception("明文数据已损坏");  
        }  
    }  
  
    *//** 
     * 解密过程 
     * @param privateKey 私钥 
     * @param cipherData 密文数据 
     * @return 明文 
     * @throws Exception 解密过程中的异常信息 
     *//*  
    public byte[] decrypt(RSAPrivateKey privateKey, byte[] cipherData) throws Exception{  
        if (privateKey== null){  
            throw new Exception("解密私钥为空, 请设置");  
        }  
        Cipher cipher= null;  
        try {  
            cipher= Cipher.getInstance("RSA", new BouncyCastleProvider()); 
            cipher.init(Cipher.DECRYPT_MODE, privateKey);  
            byte[] output= cipher.doFinal(cipherData);  
            return output;  
        } catch (NoSuchAlgorithmException e) {  
            throw new Exception("无此解密算法");  
        } catch (NoSuchPaddingException e) {  
            e.printStackTrace();  
            return null;  
        }catch (InvalidKeyException e) {  
            throw new Exception("解密私钥非法,请检查");  
        } catch (IllegalBlockSizeException e) {  
            throw new Exception("密文长度非法");  
        } catch (BadPaddingException e) {  
            throw new Exception("密文数据已损坏");  
        }         
    }  
  */
     
    
    
    
    
    /**
     * <P>
     * 私钥解密
     * </p>
     * 
     * @param encryptedData 已加密数据
     * @param privateKey 私钥(BASE64编码)
     * @return
     * @throws Exception
     */
    public static byte[] decryptByPrivateKey(byte[] encryptedData, RSAPrivateKey privateKey)
            throws Exception {
        
      //  Cipher cipher = Cipher.getInstance("RSA",new BouncyCastleProvider());
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        int inputLen = encryptedData.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段解密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
                cache = cipher.doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_DECRYPT_BLOCK;
        }
        byte[] decryptedData = out.toByteArray();
        out.close();
        return decryptedData;
    }

    /**
     * <p>
     * 公钥解密
     * </p>
     * 
     * @param encryptedData 已加密数据
     * @param publicKey 公钥(BASE64编码)
     * @return
     * @throws Exception
     */
    public static byte[] decryptByPublicKey(byte[] encryptedData, RSAPublicKey publicKey)
            throws Exception {
      
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        int inputLen = encryptedData.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段解密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
                cache = cipher.doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_DECRYPT_BLOCK;
        }
        byte[] decryptedData = out.toByteArray();
        out.close();
        return decryptedData;
    }
    
    /**
     * 使用私钥解密  入参为字符串， 出参为字符串
     * 先base64， 在解密
     * @param content
     * @return
     */
    public static String decryptByPublicKey(String content) throws Exception{
        
        try {
                
            loadPublicKey(RSAEncryptUtils.DEFAULT_PUBLIC_KEY); 
            byte[] returnByte = decryptByPublicKey(Base64.decode(content), getPublicKey());
            return new String(returnByte,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }  
        return "";
    }

    /**
     * <p>
     * 公钥加密
     * </p>
     * 
     * @param data 源数据
     * @param publicKey 公钥(BASE64编码)
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPublicKey(byte[] data, RSAPublicKey publicKey)
            throws Exception {
      
        // 对数据加密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        int inputLen = data.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段加密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
                cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(data, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_ENCRYPT_BLOCK;
        }
        byte[] encryptedData = out.toByteArray();
        out.close();
        return encryptedData;
    }

    /**
     * <p>
     * 私钥加密
     * </p>
     * 
     * @param data 源数据
     * @param privateKey 私钥(BASE64编码)
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPrivateKey(byte[] data, RSAPrivateKey privateKey)
            throws Exception {
      
        //Cipher cipher = Cipher.getInstance("RSA",new BouncyCastleProvider());
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        
      
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        int inputLen = data.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段加密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
                cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(data, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_ENCRYPT_BLOCK;
        }
        byte[] encryptedData = out.toByteArray();
        out.close();
        return encryptedData;
    }

     
    
    /** 
     * 字节数据转十六进制字符串 
     * @param data 输入数据 
     * @return 十六进制内容 
     */  
    public static String byteArrayToString(byte[] data){  
        StringBuilder stringBuilder= new StringBuilder();  
        for (int i=0; i<data.length; i++){  
            //取出字节的高四位 作为索引得到相应的十六进制标识符 注意无符号右移  
            stringBuilder.append(HEX_CHAR[(data[i] & 0xf0)>>> 4]);  
            //取出字节的低四位 作为索引得到相应的十六进制标识符  
            stringBuilder.append(HEX_CHAR[(data[i] & 0x0f)]);  
            if (i<data.length-1){  
                stringBuilder.append(' ');  
            }  
        }  
        return stringBuilder.toString();  
    }  
  
    
    
    /**
     * 使用私钥加密  入参为字符串， 出参为字符串
     * 
     * 先加密， 在base64
     * @param content
     * @return
     */
    public static String encryptByPrivateKey(String content) throws Exception{
    	
    	try {
	        	
			loadPrivateKey(RSAEncryptUtils.DEFAULT_PRIVATE_KEY); 
			byte[] returnByte = encryptByPrivateKey(content.getBytes("UTF-8"), getPrivateKey());
			return Base64.encode(returnByte);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return "";
    }
    
    /**
     * 使用公钥加密  入参为字符串， 出参为字符串
     * 
     * 先加密， 在base64
     * @param content
     * @return
     */
    public static String encryptByPublicKey(String content) throws Exception{
        try {
                
            loadPublicKey(RSAEncryptUtils.DEFAULT_PUBLIC_KEY); 
            byte[] returnByte = encryptByPublicKey(content.getBytes("UTF-8"), getPublicKey());
            return Base64.encode(returnByte);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            
        } catch (Exception e) {
            e.printStackTrace();
        }  
        return "";
    }
    
    /**
     * 使用私钥解密  入参为字符串， 出参为字符串
     * 先base64， 在解密
     * @param content
     * @return
     */
    public static String decryptByPrivateKey(String content) throws Exception{
    	
    	try {
	        	
			loadPrivateKey(RSAEncryptUtils.DEFAULT_PRIVATE_KEY); 
			byte[] returnByte = decryptByPrivateKey(Base64.decode(content), getPrivateKey());
			return new String(returnByte,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return "";
    }
    
    
    
    
    
    
    
    
    
    
  
    public static void main(String[] args){  
       
    	
    	long time1=System.currentTimeMillis();
    	
    	RSAEncryptUtils rsaEncrypt= new RSAEncryptUtils();  
       
       
  
        //加载公钥  
        try {  
            rsaEncrypt.loadPublicKey(RSAEncryptUtils.DEFAULT_PUBLIC_KEY);  
            System.out.println("加载公钥成功");  
        } catch (Exception e) {  
            System.err.println(e.getMessage());  
            System.err.println("加载公钥失败");  
        }  
  
        //加载私钥  
        try {  
            rsaEncrypt.loadPrivateKey(RSAEncryptUtils.DEFAULT_PRIVATE_KEY);  
            System.out.println("加载私钥成功");  
        } catch (Exception e) {  
            System.err.println(e.getMessage());  
            System.err.println("加载私钥失败");  
        }  
  
        
        //测试字符串  
        String encryptStr= "{'d':{'attrs':{'测试值53':'测试参数53','测试值32':'测试参数32','测试值82':'测试参数82','测试值11':'测试参数11','测试值59':'测试参数59','测试值61':'测试参数61','测试值38':'测试参数38','测试值88':'测试参数88','测试值40':'测试参数40','测试值0':'测试参数0','测试值17':'测试参数17','测试值67':'测试参数67','测试值90':'测试参数90','测试值46':'测试参测试参数61','测试值38':'测试参数38','测试值88':'测试参数88','测试值40':'测试参数40','测试值0':'测试参数0','测试值17':'测试参数17','测试值67':'测试参数67','测试值90':'测试参数90','测试值46':'测试参\346\225数46','测试值96':'测试参数96','测试值25':'测试参数25','测试值75':'测试参数75','测试值54':'测试参数54','测试值1':'测试参数1','测试值33':'测试参数33','测试值83':'测试参数83','测试值12':'测试参数12','测测试参数61','测试值38':'测试参数38','测试值88':'测试参数88','测试值40':'测试参数40','测试值0':'测试参数0','测试值17':'测试参数17','测试值67':'测试参数67','测试值90':'测试参数90','测试值46':'测试参\346\225数46','测试值96':'测试参数96','测试值25':'测试参数25','测试值75':'测试参数75','测试值54':'测试参数54','测试值1':'测试参数1','测试值33':'测试参数33','测试值83':'测试参数83','测试值12':'测试参数12','测\350试值39':'测试参数39','测试值62':'测试参数62','测试值89':'测试参数89','测试值18':'测试参数18','测试值41':'测试参数41','测试值2':'测试参数2','测试值68':'测试参数68','测试值20':'测试参数20','测试值91':'测试参数91','测试值47':'测试参数47','测试值70':'测试参数70','测试值97':'测试参数97','测试值26':'测试参数26','测试值76':'测试参数76','测试值55':'测试参数55','测试值3':'测试参数3','测试值34':'测试参数34','测试值84':'测试参数84','测试值13':'测试参数13','测试值63':'测试参数63','测试值19':'测试参数19','测试值42':'测试参数42','测试值69':'测试参数69','测试值21':'测试参数21','测试值4':'测试参数4','测试值92':'测试参数92','测试值71':'测试参数71','测试值48':'测试参数48','timestamp':'1476177311000','测试值98':'测试参数98','测试值50':'测试参数50','测试值27':'测试参数27','测试值77':'测试参数77','测试值56':'测试参数56','测试值5':'测试参数5','测试值35':'测试参数35','测试值85':'测试参数85','测试值14':'测试参数14','测试值64':'测试参数64','测试值43':'测试参数43','测试值93':'测试参数93','测试值6':'测试参数6','测试值22':'测试参数22','测试值72':'测试参数72','测试值49':'测试参数49','测试值99':'测试参数99','测试值51':'测试参数51','测试值28':'测试参数28','测试值78':'测试参数78','测试值30':'测试参数30','测试值57':'测试参数57','测试值80':'测试参数80','测试值7':'测试参数7','测试值36':'测试参数36','测试值86':'测试参数86','测试值15':'测试参数15','测试值65':'测试参数65','测试值44':'测试参数44','测试值94':'测试参数94','测试值23':'测试参数23','测试值8':'测试参数8','测试值73':'测试参数73','测试值29':'测试参数29','测试值52':'测试参数52','测试值79':'测试参数79','测试值31':'测试参数31','测试值58':'测试参数58','测试值10':'测试参数10','测试值81':'测试参数81','测试值60':'测试参数60','测试值37':'测试参数37','测试值9':'测试参数9','测试值87':'测试参数87','测试值16':'测试参数16','测试值66':'测试参数66','测试值45':'测试参数45','测试值95':'测试参数95','测试值24':'测试参数24','测试值74':'测试参数74'},'domains':{}},'v':'1','r':'000006'}";  
       
        System.out.println("私钥长度："+rsaEncrypt.getPrivateKey().toString().length());
        System.out.println("公钥长度："+rsaEncrypt.getPublicKey().toString().length());
        try {  
        	
        	byte[] cipher =rsaEncrypt.encryptByPublicKey(encryptStr.getBytes(), rsaEncrypt.getPublicKey());
        	
        	String param="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";
        	
        	
        	
            byte[] plainText = rsaEncrypt.decryptByPrivateKey(Base64.decode(param), rsaEncrypt.getPrivateKey());
        	
            //加密  
         //   byte[] cipher = rsaEncrypt.encrypt(rsaEncrypt.getPublicKey(), encryptStr.getBytes());  
          ///  System.out.println("密文长度:"+ cipher.length);  
        //    System.out.println(RSAEncrypt.byteArrayToString(cipher));  
            
           // String base64Str="WlY5eDJuUmVDbHF5YUJUZUUwK1lmajBoREF1UEZoakJySXY2Q0VUbkRVQjVLTklZL1dnNmhrbWlDNTk1ZDVXdzVNSzEzZ1RLUXA3ZW1nOGdHeGgwbUhRdlg2bDVIMEpDMHo1dEpVZUpodU42c21HYk1TT0dDRWViVGp1TEUzRjRWNjNabDVaREdVbXA5WVRMemZ3RUJkb1llV2YvTnRkRnhlL0F4aWlZK0M5UENDNWlqbFRTV2o3ZlZ5S0NsZkd2a2ZnbmtYay9LVm9za2l2RWhMZ0VwM2lZMUlEdWw3K3ZJc28rSjB4L0haTkpWZXdxN0szVFlySDZtOWdtYW1SRjlTVVVmOFU2NUY1UFBaYkpxcnl0cTZ0T3d6UkJWdXhuY1dTVXVZVnVFbi8xV2w4VVoxOEo2ODBiWFBTTFdXNXM1Q2V3MTZONkZ5RU43a3lIWXZsbm80WVlCZnU5SGNHYTV2bjFIRXdxTGxuNDd4ajN2dG0wNDNSTjloRXhWRmV4RUkrdjNHeStVUlhNYy9oUm5zRHpuS0YwY2RFbmttcktQaVk4ZHZEb2h6SGVxamRVRThZeXhzV2YrS2hnNE43WkhCWjFKS2dMejR4RGl0UEh4TnZsYU5RcUl1VGRjUzVnMTNFeENMU0pJS1dyakJUb1RJOURNTUJ3VC9BNktMQlNFMWNiV252TE9tV3NhbnVyTm5mamEwYURleElkM3QzellJdjUwSWF2UGJoUnhVU1oreEpoWTV0dUNrQzczT05XY0dxUjlhN0hWQ2RiMllJdDEvWWg5WVVScW5hNWU5Rnh0V3FlUVd5SSs4K0s5OEVzOHpOS0xRZTRoUGFjdjJ0N3Z0L05INmpIcHY5VVlmZm45VXFOK1JJbFptUitSQVFzWkN2elE2ZHY1RUk9";
        	
        	System.out.println(Base64.decode(param));
        	
        	// byte[] plainText = rsaEncrypt.decryptByPrivateKey(Base64.decode(param), rsaEncrypt.getPrivateKey());
            //解密  
         //   byte[] plainText = rsaEncrypt.decryptByPrivateKey(Base64.decode(param), rsaEncrypt.getPrivateKey());

            
           
          
     
            System.out.println("明文长度:"+ plainText.length);  
            System.out.println("====");
            System.out.println(new String(plainText));  
            long time2=System.currentTimeMillis();
            System.out.println(time2-time1);
        } catch (Exception e) {  
        	e.printStackTrace();
            System.err.println(e.getMessage());  
        }  
    }
}

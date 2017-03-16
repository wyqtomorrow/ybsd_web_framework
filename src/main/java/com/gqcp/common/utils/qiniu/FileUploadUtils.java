package com.gqcp.common.utils.qiniu;

import java.io.File;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.gqcp.common.Constant;
import com.gqcp.common.utils.http.PropertiesUtils;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import com.qiniu.util.UrlSafeBase64;

public class FileUploadUtils {
    static Logger logger = LoggerFactory.getLogger(FileUploadUtils.class);
    private static FileUploadUtils instance = new FileUploadUtils();
    // 设置好账号的ACCESS_KEY和SECRET_KEY
    // 要上传的空间
    public String fileKey = "fileUrl";
    public String ACCESS_KEY = PropertiesUtils.getProperty(Constant.ACCESS_KEY); // 你的access_key
    public String SECRET_KEY = PropertiesUtils.getProperty(Constant.SECRET_KEY); // 你的secret_key
    public String bucketname = PropertiesUtils.getProperty(Constant.BUCKET_NAME); // 你的bucket_name
    public String backPath = PropertiesUtils.getProperty(Constant.QINIU_BACK_PATH);
    public String pipeline = PropertiesUtils.getProperty(Constant.PIPELINE_KEY);
    // 上传到七牛后保存的文件名
    public String nxdsImageKey = "nxds_image_";
    public String nxdsVideoKey = "nxds_video_";
    public String cmsAudioKey = "nxds_audio_";
    //设置转码操作参数
    public String videoFops = "avthumb/mp4/s/640x360/vb/1.25m";
    public String wmTextBase64 = "wmText/" + UrlSafeBase64.encodeToString("农信互联");

    // 密钥配置
    Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
    // 创建上传对象
    UploadManager uploadManager = new UploadManager();

    public static FileUploadUtils getInstance() {
        return instance;
    }

    // 简单上传，使用默认策略，只需要设置上传的空间名就可以了
    public String getUpToken() {
        return auth.uploadToken(bucketname);
    }

    public String getVideoUpToken(String keyName) {
        String savePathBase64 = UrlSafeBase64.encodeToString(bucketname + ":" + keyName);
        String pfops = videoFops + "/" + wmTextBase64 + "|saveas/" + savePathBase64;
        return auth.uploadToken(bucketname, keyName, 3600,
            new StringMap().putNotEmpty("persistentOps", pfops).putNotEmpty("persistentPipeline", pipeline), true);
    }

    public JSONObject uploadImgFile(File file, String fileName) {
        JSONObject jsonObject = new JSONObject();
        try {
            int index = fileName.lastIndexOf(".");
            String fileSuffix = fileName.substring(index, fileName.length());
            logger.info("fileSuffix=="+fileSuffix);
            // 调用put方法上传
            Response res = uploadManager.put(file, nxdsImageKey + UUID.randomUUID().toString() + fileSuffix, getUpToken());
            String responseStr = res.bodyString();
            // 打印返回的信息
            jsonObject = JSONObject.parseObject(responseStr);
            jsonObject.put(fileKey, backPath + jsonObject.getString("key"));
        } catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时打印的异常的信息
            logger.error("error=" + r.toString());
            try {
                jsonObject = JSONObject.parseObject(r.bodyString());
            } catch (QiniuException ex) {
                logger.error("error=" + ex);
            }
        }
        return jsonObject;
    }

    public JSONObject uploadVideoFile(File file) {
        JSONObject jsonObject = new JSONObject();
        try {
            String keyName = UUID.randomUUID().toString();
            // 调用put方法上传
            Response res = uploadManager.put(file, nxdsVideoKey + keyName, getVideoUpToken(nxdsVideoKey + keyName));
            String responseStr = res.bodyString();
            // 打印返回的信息
            jsonObject = JSONObject.parseObject(responseStr);
            jsonObject.put(fileKey, backPath + jsonObject.getString("key"));
            jsonObject.put("imgUrl", backPath + jsonObject.getString("key") + Constant.MOVIES_TO_IMG_1);
            jsonObject.put("videoName", jsonObject.getString("key"));
        } catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时打印的异常的信息
            logger.error("error=" + r.toString());
            try {
                jsonObject = JSONObject.parseObject(r.bodyString());
            } catch (QiniuException ex) {
                logger.error("error=" + ex);
            }
        }
        return jsonObject;
    }

}

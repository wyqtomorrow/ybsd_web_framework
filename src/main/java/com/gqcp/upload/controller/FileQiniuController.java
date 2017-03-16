package com.gqcp.upload.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.alibaba.fastjson.JSONObject;
import com.gqcp.common.page.ResponseEntity;
import com.gqcp.common.page.ResponseEntityUtil;
import com.gqcp.common.utils.qiniu.FileUploadUtils;

@RestController
@RequestMapping(value = "/file", produces = MediaType.APPLICATION_JSON_VALUE)
public class FileQiniuController {

  private final Log log = LogFactory.getLog(this.getClass());

  @RequestMapping(value = "/uploadVideo", method = RequestMethod.POST)
  public ResponseEntity uploadVideo(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    JSONObject object = new JSONObject();
    String logoRealPathDir = request.getSession().getServletContext().getRealPath("/");
    String fileName = "";
    // 创建一个通用的多部分解析器
    CommonsMultipartResolver multipartResolver =
        new CommonsMultipartResolver(request.getSession().getServletContext());
    // 判断 request 是否有文件上传,即多部分请求
    if (multipartResolver.isMultipart(request)) {
      // 转换成多部分request
      MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
      // 取得request中的所有文件名
      Iterator<String> iter = multiRequest.getFileNames();
      while (iter.hasNext()) {
        // 记录上传过程起始时的时间，用来计算上传时间
        int pre = (int) System.currentTimeMillis();
        // 取得上传文件
        MultipartFile file = multiRequest.getFile(iter.next());
        long size = file.getSize();
        log.info("文件大小 : " + size);
        if (file != null) {
          // 取得当前上传文件的文件名称
          String myFileName = file.getOriginalFilename();
          // 如果名称不为“”,说明该文件存在，否则说明该文件不存在
          if (myFileName.trim() != "") {
            // 重命名上传后的文件名
            fileName = file.getOriginalFilename();
            fileName = new Date().getTime() + fileName;
            // 定义上传路径
            String path = logoRealPathDir + fileName;
            File localFile = new File(path);
            file.transferTo(localFile);
            JSONObject jsonObject = FileUploadUtils.getInstance().uploadVideoFile(localFile);
            localFile.delete();
            return ResponseEntityUtil.success(jsonObject);
          }
        }
        // 记录上传该文件后的时间
        int finaltime = (int) System.currentTimeMillis();
        log.info("上传所用时间" + (finaltime - pre));
      }
    }
    return null;
  }


  @RequestMapping(value = "/uploadImg", method = RequestMethod.POST)
  public ResponseEntity uploadImg(HttpServletRequest request, HttpServletResponse response) {
    Map<String, Object> map = new HashMap<String, Object>();
    String logoRealPathDir = request.getSession().getServletContext().getRealPath("/");
    try {
      // 创建一个通用的多部分解析器
      CommonsMultipartResolver multipartResolver =
          new CommonsMultipartResolver(request.getSession().getServletContext());
      // 判断 request 是否有文件上传,即多部分请求
      if (multipartResolver.isMultipart(request)) {
        // 转换成多部分request
        MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
        // 取得request中的所有文件名
        Iterator<String> iter = multiRequest.getFileNames();
        while (iter.hasNext()) {
          // 记录上传过程起始时的时间，用来计算上传时间
          int pre = (int) System.currentTimeMillis();
          // 取得上传文件
          MultipartFile file = multiRequest.getFile(iter.next());
          long size = file.getSize();
          log.info("文件大小 : " + size);
          if (file != null) {
            // 取得当前上传文件的文件名称
            String myFileName = file.getOriginalFilename();
            // 如果名称不为“”,说明该文件存在，否则说明该文件不存在
            if (myFileName.trim() != "") {
              // 重命名上传后的文件名
              String fileName = file.getOriginalFilename();
              fileName = new Date().getTime() + fileName;
              // 定义上传路径
              String path = logoRealPathDir + fileName;
              File localFile = new File(path);
              file.transferTo(localFile);
              FileUploadUtils fileUploadUtils = FileUploadUtils.getInstance();
              JSONObject jsonObject = fileUploadUtils.uploadImgFile(localFile, fileName);
              localFile.delete();
              return ResponseEntityUtil.success(jsonObject);
            }
          }
          // 记录上传该文件后的时间
          int finaltime = (int) System.currentTimeMillis();
          log.info("上传所用时间" + (finaltime - pre));
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

}

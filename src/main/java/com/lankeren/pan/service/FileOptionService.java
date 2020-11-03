package com.lankeren.pan.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * @author lankeren
 * @ClassName FileOption
 * @Deacription:
 * @create: 2020-11-03 17:16
 */
public interface FileOptionService {

    Object uploadFile(MultipartFile[] file);

    JSONObject getFileList();

    Object download(String fileName, HttpServletResponse response);


}

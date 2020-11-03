package com.lankeren.pan.controller;

import com.alibaba.fastjson.JSONObject;
import com.lankeren.pan.enums.Status;
import com.lankeren.pan.response.MyResponse;
import com.lankeren.pan.service.FileOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;


/**
 * @author lankeren
 * @ClassName FileOption
 * @Deacription:
 * @create: 2020-11-03 16:04
 */
@RestController
public class FileOptionController {
    @Autowired
    private FileOptionService  fileOptionService;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public MyResponse uploadFile(MultipartFile[] file){
        if(file == null || file.length == 0) return new MyResponse(Status.fail);
        MyResponse<Object> response = new MyResponse<>();
        try {
            response.setData(fileOptionService.uploadFile(file));
        } catch (Exception e) {
            return new MyResponse<>(Status.fail, e.getMessage());
        }
        return response;
    }


    @RequestMapping(value = "/getFileList", method = RequestMethod.GET)
    public JSONObject getFileList(){
        JSONObject response ;
        try {
            response = fileOptionService.getFileList();
        } catch (Exception e) {
            response = new JSONObject();
            response.put("code", -1);
            response.put("msg", "出现异常了");
            response.put("data", null);
            return response;
        }
        return response;
    }

    @RequestMapping(value = "/download", method = RequestMethod.POST)
    public MyResponse download(String fileName, HttpServletResponse res){
        MyResponse<Object> response = new MyResponse<>();
        if (fileName == null || "".equals(fileName)) return new MyResponse(Status.fail);
        try {
            response.setData(fileOptionService.download(fileName, res));
        } catch (Exception e) {
            return new MyResponse<>(Status.fail, e.getMessage());
        }
        return response;
    }

}

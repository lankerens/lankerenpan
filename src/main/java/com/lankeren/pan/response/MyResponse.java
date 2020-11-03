package com.lankeren.pan.response;

import com.alibaba.fastjson.JSONObject;
import com.lankeren.pan.enums.Status;

/**
 * @author lankeren
 * @ClassName MyResponse
 * @Deacription:
 * @create: 2020-11-03 16:06
 */
public class MyResponse<T> {
    private String msg;
    private int code;
    private T data;

    public MyResponse(){
        msg = "成功"; code = 0;
    }
    public MyResponse(Status status){
        this.msg = status.getMsg();
        this.code = status.getStatus();
    }

    public MyResponse(Status status, T data){
        this.msg = status.getMsg();
        this.code = status.getStatus();
        this.data = data;
    }

    public MyResponse(T data){
        this();
        this.data = data;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

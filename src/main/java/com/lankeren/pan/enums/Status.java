package com.lankeren.pan.enums;

public enum Status {
    /**
     *  失败
     */
    fail(-1, "失败"),
    /**
     *  成功
     */
    success(201, "成功");

    private String msg;
    private int status;

    Status(int status, String msg){
        this.status = status;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

package com.laoxu.modernsky.entity;

public class BackReturn {
    //返回状态码
    private String code;
    //返回的提示信息
    private String message;
    //操作返回值
    private Object obj=null;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}

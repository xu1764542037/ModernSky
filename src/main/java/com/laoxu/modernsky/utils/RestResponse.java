package com.laoxu.modernsky.utils;

/**
 * @ClassName: RestResponse
 * @Description: Response响应工具类
 * @Author:
 * @CreateDate: 2019-02-14 09:14
 * @Version: 1.0
 */
public class RestResponse<T> {
    public static final String SUCCESS_MSG = "操作成功";
    public static final String FAILURE_MSG = "操作失败";
    public static final Integer SUCCESS_CODE = 0;
    public static final Integer FAILURE_CODE = 300;

    private Integer code;

    private String msg;
    private T data;

    public RestResponse() {
    }

    public RestResponse(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public RestResponse(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        data = null;
    }

    public static RestResponse buildFailureResp(Exception e) {
        return new RestResponse(RestResponse.FAILURE_CODE, e.getMessage());
    }

    public static RestResponse buildFailureResp(String msg) {
        return new RestResponse(RestResponse.FAILURE_CODE, msg);
    }

    public static RestResponse buildSuccessResp(Object data) {
        return new RestResponse(RestResponse.SUCCESS_CODE, RestResponse.SUCCESS_MSG, data);
    }

    public static RestResponse buildSuccessResp() {
        return new RestResponse(RestResponse.SUCCESS_CODE, RestResponse.SUCCESS_MSG);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}



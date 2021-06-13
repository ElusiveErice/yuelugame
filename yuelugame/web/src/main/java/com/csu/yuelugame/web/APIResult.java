package com.csu.yuelugame.web;

public class APIResult {
    public static final int OK = 0;
    public static final int PARAMETE_ERROR = 1;
    public static final int IO_ERROR = 2;

    private int code;
    private String message;
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static APIResult okResult(){
        return createResult(0);
    }

    public static APIResult createResult(Object data){
        return createResult(OK, "ok", data);
    }

    public static APIResult createResult(int code){
        String message = "ok";
        switch (code){
            case OK:
                message = "ok";
                break;
            case PARAMETE_ERROR:
                message = "参数错误";
                break;
            case IO_ERROR:
                message =  "IO错误";
                break;
            default:
                message = "不知名的错误";
        }
        return createResult(code, message);
    }

    public static APIResult createResult(int code, String message){
        APIResult apiResult = new APIResult();
        apiResult.setCode(code);
        apiResult.setMessage(message);
        return apiResult;
    }
    public static APIResult createResult(int code, String message, Object data){
        APIResult apiResult = new APIResult();
        apiResult.setCode(code);
        apiResult.setMessage(message);
        apiResult.setData(data);
        return apiResult;
    }
}

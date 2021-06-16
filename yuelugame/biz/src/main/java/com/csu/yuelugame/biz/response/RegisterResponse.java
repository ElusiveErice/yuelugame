package com.csu.yuelugame.biz.response;

public class RegisterResponse {
    private boolean register;
    private String message;
    private long id;

    public RegisterResponse() {
    }

    public RegisterResponse(boolean register, String message, long id) {
        this.register = register;
        this.message = message;
        this.id = id;
    }

    public boolean isRegister() {
        return register;
    }

    public void setRegister(boolean register) {
        this.register = register;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

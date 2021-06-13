package com.csu.yuelugame.biz.response;

public class RegisterResponse {
    private boolean register;
    private String message;
    private String account;

    public RegisterResponse() {
    }

    public RegisterResponse(boolean register, String message, String account) {
        this.register = register;
        this.message = message;
        this.account = account;
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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}

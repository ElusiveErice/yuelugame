package com.csu.yuelugame.biz.response;

public class LoginResponse {
    private boolean login;
    private String message;
    private long id;

    public LoginResponse(){
        this.login=false;
        this.message="登录失败";
        this.id=0;
    }

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
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

package com.csu.yuelugame.biz.response;

public class LoginResponse {
    private boolean login;
    private String message;
    private long id;
    private String name;

    public LoginResponse(){
    }

    public LoginResponse(boolean login, String message, long id, String name) {
        this.login = login;
        this.message = message;
        this.id = id;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

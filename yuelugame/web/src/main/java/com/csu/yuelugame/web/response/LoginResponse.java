package com.csu.yuelugame.web.response;

public class LoginResponse {
    private boolean login;
    private String message;
    private String account;
    private String username;

    public LoginResponse(){
    }
    public LoginResponse(boolean login, String message, String account, String username) {
        this.login = login;
        this.message = message;
        this.account = account;
        this.username = username;
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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

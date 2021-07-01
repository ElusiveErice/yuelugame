package com.csu.yuelugame.dao.entities;

public class UserDo {
    private long id;
    private String password;
    private String name;

    public UserDo() {
        this.id = 0;
        this.password = null;
        this.name = null;
    }

    public UserDo(long id, String account, String password, String name) {
        this.id = id;
        this.password = password;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

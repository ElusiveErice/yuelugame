package com.csu.yuelugame.dao.beans;

public class Game {
    private int id;
    private String name;
    private String coverPicture;
    private String serverUrl;

    public Game(int id, String name, String coverPicture, String serverUrl) {
        this.id = id;
        this.name = name;
        this.coverPicture = coverPicture;
        this.serverUrl = serverUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoverPicture() {
        return coverPicture;
    }

    public void setCoverPicture(String coverPicture) {
        this.coverPicture = coverPicture;
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }
}

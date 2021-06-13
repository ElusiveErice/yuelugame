package com.csu.yuelugame.web.response;

public class GamesResponse {
    GameData[] gameList;

    public GamesResponse(GameData[] gameList) {
        this.gameList = gameList;
    }
}

class GameData{
    String name;
    String cover;
}
package com.csu.yuelugame.biz.response;


import com.csu.yuelugame.dao.beans.Game;

import java.util.ArrayList;
import java.util.List;

public class GamesResponse {
    private List<Game> gameList;

    public GamesResponse(){};
    public GamesResponse(List<Game> gameList) {
        this.gameList = gameList;
    }

    public List<Game> getGameList() {
        return gameList;
    }

    public void setGameList(List<Game> gameList) {
        this.gameList = gameList;
    }
}

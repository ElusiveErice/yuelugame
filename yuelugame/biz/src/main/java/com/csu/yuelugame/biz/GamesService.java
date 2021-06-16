package com.csu.yuelugame.biz;

import com.csu.yuelugame.biz.response.GamesResponse;
import com.csu.yuelugame.dao.beans.Game;

import java.util.List;

public interface GamesService {
    GamesResponse getGames();
}

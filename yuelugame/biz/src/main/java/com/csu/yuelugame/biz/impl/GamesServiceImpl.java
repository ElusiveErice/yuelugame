package com.csu.yuelugame.biz.impl;

import com.csu.yuelugame.biz.GamesService;

import com.csu.yuelugame.biz.response.GamesResponse;
import com.csu.yuelugame.dao.beans.Game;
import com.csu.yuelugame.dao.mapper.GameMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class GamesServiceImpl implements GamesService {

    @Resource
    GameMapper gameMapper;

    @Override
    public GamesResponse getGames(){
        GamesResponse gamesResponse = new GamesResponse();
        List<Game> gameList = gameMapper.getList();

        gamesResponse.setGameList(gameList);

        return gamesResponse;
    }
}

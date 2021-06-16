package com.csu.yuelugame.web.controller;

import com.csu.yuelugame.biz.GamesService;
import com.csu.yuelugame.web.APIResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/games")
public class GamesListController {

    @Autowired
    private GamesService gamesService;

    @GetMapping("/list")
    public APIResult getGames(){
        return APIResult.createResult(gamesService.getGames());
    }

}

package com.csu.yuelugame.web.controller;

import com.csu.yuelugame.biz.beans.chinesechess.ChineseChessRoom;
import com.csu.yuelugame.biz.beans.chinesechess.ChineseChessRoomSingleton;
import com.csu.yuelugame.dao.beans.User;
import com.csu.yuelugame.web.APIResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/playroom")
public class ChineseChessController {
    @RequestMapping("/list")
    public APIResult PlayroomList(){
        //返回所有的房间信息
        return APIResult.createResult(ChineseChessRoomSingleton.getSingleton().getRoomList());
    }
    @PostMapping("/find")
    public APIResult PlayroomFind(String id){
        //查询id对应的房间，返回该房间的信息
        ChineseChessRoom cr=new ChineseChessRoom();
        cr.setPlayerCount(1);
        cr.setState(true);
        cr.setRed(new User(1,"123","123","airuike"));
        cr.setBlack(new User(2,"1234","1234","airuike2"));
        return APIResult.createResult(cr);
    }
    @PostMapping("/create")
    public APIResult PlayroomCreate(String account){
        //创建一个新的房间，为用户分配红/黑方，返回房间信息和用户身份
        ChineseChessRoom cr=new ChineseChessRoom();
        cr.setPlayerCount(1);
        cr.setState(true);
        cr.setRed(new User(1,account,"123","airuike"));
        return APIResult.createResult(cr);
    }
    @RequestMapping("/enter")
    public void PlayroomEnter(String id){
        //进入房间

    }

}

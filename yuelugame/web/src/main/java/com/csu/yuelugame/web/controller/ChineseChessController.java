package com.csu.yuelugame.web.controller;

import com.csu.yuelugame.biz.ChineseChessHomeService;
import com.csu.yuelugame.biz.beans.chinesechess.ChineseChessRoom;
import com.csu.yuelugame.biz.beans.chinesechess.ChineseChessRoomManager;
import com.csu.yuelugame.dao.beans.User;
import com.csu.yuelugame.web.APIResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/playroom")
public class ChineseChessController {

    @Autowired
    private ChineseChessHomeService chineseChessHomeService;

    @RequestMapping("/list")
    public APIResult PlayroomList(){
        //返回所有的房间信息
        return APIResult.createResult(ChineseChessRoomManager.getManager().getRoomList());
    }

    @PostMapping("/find")
    public APIResult PlayroomFind(String id){
        //查询id对应的房间，返回该房间的信息
        ChineseChessRoom cr=chineseChessHomeService.FindChineseChessRoom(id);
        if(cr==null){
            return null;
        }
        else{
            return APIResult.createResult(cr);
        }
    }
    @PostMapping("/create")
    public APIResult PlayroomCreate(){
        //创建一个新的房间，为用户分配红/黑方，返回房间信息和用户身份
        ChineseChessRoom cr=chineseChessHomeService.CreateChineseChessRoom();

        return APIResult.createResult(cr);
    }
    @RequestMapping("/enter")
    public APIResult PlayroomEnter(String id){
        //进入房间
        return null;

    }

}

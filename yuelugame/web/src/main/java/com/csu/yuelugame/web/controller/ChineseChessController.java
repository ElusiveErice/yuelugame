package com.csu.yuelugame.web.controller;

import com.csu.yuelugame.biz.ChineseChessHomeService;
import com.csu.yuelugame.biz.beans.chinesechess.ChineseChessRoom;
import com.csu.yuelugame.biz.beans.chinesechess.ChineseChessRoomManager;
import com.csu.yuelugame.biz.response.ChineseChessRoomCantCreateResponse;
import com.csu.yuelugame.biz.response.ChineseChessRoomCantFindResponse;
import com.csu.yuelugame.biz.response.ChineseChessRoomCreateResponse;
import com.csu.yuelugame.biz.response.ChineseChessRoomFindResponse;
import com.csu.yuelugame.web.APIResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/chinesechessroom")
public class ChineseChessController {

    @Autowired
    private ChineseChessHomeService chineseChessHomeService;

    @RequestMapping("/roomlist")
    public APIResult PlayroomList(){
        //返回所有的房间信息
        return APIResult.createResult(ChineseChessRoomManager.getManager().getRoomList());
    }

    @RequestMapping("/findroom")
    public APIResult PlayroomFind( String name){
        ChineseChessRoom cr=chineseChessHomeService.FindChineseChessRoom(name);
        if(cr==null){
            return APIResult.createResult(new ChineseChessRoomCantFindResponse());
        }
        else{
            return APIResult.createResult(new ChineseChessRoomFindResponse(cr));
        }
    }
    @PostMapping("/createroom")
    public APIResult PlayroomCreate(@RequestParam  String name){
        //创建一个新的房间，为用户分配红/黑方，返回房间信息和用户身份
        ChineseChessRoom cr=chineseChessHomeService.CreateChineseChessRoom(name);
        if(cr==null){
            return APIResult.createResult(new ChineseChessRoomCantCreateResponse());
        }
        else{
            return APIResult.createResult(new ChineseChessRoomCreateResponse(cr));
        }

    }
    @RequestMapping("/enter")
    public APIResult PlayroomEnter(String id){
        return null;

    }
}

package com.csu.yuelugame.biz.impl;

import com.csu.yuelugame.biz.ChineseChessHomeService;
import com.csu.yuelugame.biz.beans.chinesechess.ChineseChessRoom;
import com.csu.yuelugame.biz.beans.chinesechess.ChineseChessRoomManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChineseChessHomeServiceImpl implements ChineseChessHomeService{
    @Override
    public ChineseChessRoom CreateChineseChessRoom(String name){
        List<ChineseChessRoom> ccrs=ChineseChessRoomManager.getManager().getRoomList();
        for(int i=0;i<ccrs.size();i++){
            if(ccrs.get(i).getName().equals(name)){
                return null;
            }
        }
        ChineseChessRoom ccr=new ChineseChessRoom();
        ccr.setName(name);
        ChineseChessRoomManager.getManager().getRoomList().add(ccr);
        return ccr;
    }
    @Override
    public ChineseChessRoom FindChineseChessRoom(String name){
        List<ChineseChessRoom> ccrs=ChineseChessRoomManager.getManager().getRoomList();
        for(int i=0;i<ccrs.size();i++){
            if(ccrs.get(i).getName().equals(name)){
                return ccrs.get(i);
            }

        }
        //找不到的情况
        return null;
    }
}

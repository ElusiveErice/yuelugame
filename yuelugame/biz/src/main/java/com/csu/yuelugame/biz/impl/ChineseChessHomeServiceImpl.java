package com.csu.yuelugame.biz.impl;

import com.csu.yuelugame.biz.ChineseChessHomeService;
import com.csu.yuelugame.biz.beans.chinesechess.ChineseChessRoom;
import com.csu.yuelugame.biz.beans.chinesechess.ChineseChessRoomManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChineseChessHomeServiceImpl implements ChineseChessHomeService{
    @Override
    public ChineseChessRoom CreateChineseChessRoom(){
        ChineseChessRoom ccr=new ChineseChessRoom();
        ChineseChessRoomManager.getManager().getRoomList().add(ccr);
        return ccr;
    }
    @Override
    public ChineseChessRoom FindChineseChessRoom(String id){
        List<ChineseChessRoom> ccrs=ChineseChessRoomManager.getManager().getRoomList();
        for(int i=0;i<ccrs.size();i++){
            if(ccrs.get(i).getId().equals(id))
                return ccrs.get(i);
        }
        //找不到的情况
        return null;
    }
}

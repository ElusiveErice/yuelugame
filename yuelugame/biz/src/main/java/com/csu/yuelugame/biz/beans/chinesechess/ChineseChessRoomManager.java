package com.csu.yuelugame.biz.beans.chinesechess;

import com.csu.yuelugame.biz.chinesechess.ChineseChessRoom;

import java.util.ArrayList;
import java.util.List;

public class ChineseChessRoomManager {
    private volatile static ChineseChessRoomManager chineseChessRoomSingleton;
    private ChineseChessRoomManager(){}
    public static ChineseChessRoomManager getManager(){
        if(chineseChessRoomSingleton ==null){
            synchronized (ChineseChessRoomManager.class){
                if(chineseChessRoomSingleton ==null){
                    chineseChessRoomSingleton=new ChineseChessRoomManager();
                }
            }
        }
        return chineseChessRoomSingleton;
    }

    private List<ChineseChessRoom> roomList=new ArrayList<ChineseChessRoom>();

    public List<ChineseChessRoom> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<ChineseChessRoom> roomList) {
        this.roomList = roomList;
    }
}

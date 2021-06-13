package com.csu.yuelugame.biz;

import com.csu.yuelugame.biz.beans.chinesechess.ChineseChessRoom;

import java.util.Map;

public interface ChineseChessHomeService {
    ChineseChessRoom CreateChineseChessRoom();
    ChineseChessRoom FindChineseChessRoom(String id);
}

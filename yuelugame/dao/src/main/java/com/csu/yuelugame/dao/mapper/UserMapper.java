package com.csu.yuelugame.dao.mapper;

import com.csu.yuelugame.dao.entities.UserDo;

public interface UserMapper {
     String login(long id);
     void register(UserDo user);
}

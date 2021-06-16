package com.csu.yuelugame.dao.mapper;

import com.csu.yuelugame.dao.beans.User;

public interface UserMapper {
     User login(long id);
     long register(User user);
}

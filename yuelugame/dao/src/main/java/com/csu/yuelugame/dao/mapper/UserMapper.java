package com.csu.yuelugame.dao.mapper;

import com.csu.yuelugame.dao.beans.User;

public interface UserMapper {
    public User login(long id);
    public String register(User user);
}

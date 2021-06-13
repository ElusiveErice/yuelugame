package com.csu.yuelugame.dao.mapper;

import com.csu.yuelugame.dao.beans.User;

public interface UserMapper {
    public User login(String account);
    public String register(User user);
}

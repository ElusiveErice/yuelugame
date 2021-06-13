package com.csu.yuelugame.biz.impl;

import com.csu.yuelugame.biz.UserService;
import com.csu.yuelugame.dao.beans.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public boolean login(User user){

        return false;
    }
}

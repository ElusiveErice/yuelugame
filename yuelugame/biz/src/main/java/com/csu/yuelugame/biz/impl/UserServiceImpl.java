package com.csu.yuelugame.biz.impl;

import com.csu.yuelugame.biz.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public boolean login(){
        return true;
    }
}

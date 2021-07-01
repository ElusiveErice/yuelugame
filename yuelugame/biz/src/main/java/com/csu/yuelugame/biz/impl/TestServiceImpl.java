package com.csu.yuelugame.biz.impl;

import com.csu.yuelugame.biz.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    @Override
    public String hello() {
        return "hello world";
    }
}

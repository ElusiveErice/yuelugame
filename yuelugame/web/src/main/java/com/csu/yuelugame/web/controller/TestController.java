package com.csu.yuelugame.web.controller;

import com.csu.yuelugame.biz.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TestService testService;

    @RequestMapping("/hello")
    public String hello(){
        return testService.hello();
    }
}

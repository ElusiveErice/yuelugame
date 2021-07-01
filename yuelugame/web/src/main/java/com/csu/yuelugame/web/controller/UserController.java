package com.csu.yuelugame.web.controller;


import com.csu.yuelugame.biz.UserService;
import com.csu.yuelugame.web.APIResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public APIResult login(@RequestBody Map<String, Object> params) {
        long id = Long.valueOf((Integer) params.get("id"));
        String password = (String) params.get("password");
        return APIResult.createResult(userService.login(id, password));
    }

    @PostMapping("/register")
    public APIResult register(@RequestBody Map<String, Object> params) {
        String name = (String) params.get("name");
        String password = (String) params.get("password");
        return APIResult.createResult(userService.register(name, password));
    }

    @RequestMapping(value = "/login_out", method = RequestMethod.POST)
    public APIResult loginOut(@RequestBody Map<String, Object> params) {
        return APIResult.okResult();
    }
}

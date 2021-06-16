package com.csu.yuelugame.web.controller;


import com.csu.yuelugame.biz.UserService;
import com.csu.yuelugame.dao.beans.User;
import com.csu.yuelugame.web.APIResult;
import com.csu.yuelugame.biz.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public APIResult login(@RequestBody User user){
        return APIResult.createResult(userService.login(user.getId(), user.getPassword()));
    }

    @PostMapping("/register")
    public APIResult register(@RequestBody User user){
        return APIResult.createResult(userService.register(user.getName(), user.getPassword()));
    }
}

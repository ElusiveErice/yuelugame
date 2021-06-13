package com.csu.yuelugame.web.controller;


import com.csu.yuelugame.biz.UserService;
import com.csu.yuelugame.dao.beans.User;
import com.csu.yuelugame.web.APIResult;
import com.csu.yuelugame.web.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public APIResult login(@RequestBody User user){
        boolean result = userService.login(user);
        LoginResponse data;
        APIResult response;
        if(result){
            data = new LoginResponse(true, "登录成功", user.getAccount(),user.getName());
        }else{
            data = new LoginResponse(false, "账户不存在或密码错误", user.getAccount(), null);
        }
        response = APIResult.createResult(0, "请求成功", (Object)data);
        return response;
    }
}

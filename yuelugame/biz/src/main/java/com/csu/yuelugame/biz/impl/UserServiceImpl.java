package com.csu.yuelugame.biz.impl;

import com.csu.yuelugame.biz.UserService;
import com.csu.yuelugame.biz.response.LoginResponse;
import com.csu.yuelugame.biz.response.RegisterResponse;
import com.csu.yuelugame.dao.entities.UserDo;
import com.csu.yuelugame.dao.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public LoginResponse login(long id, String password){
        LoginResponse loginResponse = new LoginResponse();

        String realPassword = userMapper.login(id);

        if(realPassword == null){
            loginResponse.setLogin(false);
            loginResponse.setMessage("账号不存在");
        }else if(realPassword.equals(password)){
            loginResponse.setLogin(true);
            loginResponse.setMessage("登录成功");
            loginResponse.setId(id);
        }else{
            loginResponse.setLogin(false);
            loginResponse.setMessage("密码不正确");
        }
        return loginResponse;
    }

    @Override
    public RegisterResponse register(String name, String password){
        RegisterResponse registerResponse = new RegisterResponse();
        registerResponse.setRegister(false);

        UserDo userDo = new UserDo();
        userDo.setName(name);
        userDo.setPassword(password);
        userMapper.register(userDo);

        registerResponse.setId(userDo.getId());
        registerResponse.setRegister(true);
        registerResponse.setMessage("注册成功");
        return registerResponse;
    }
}

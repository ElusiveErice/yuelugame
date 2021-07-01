package com.csu.yuelugame.biz;

import com.csu.yuelugame.biz.response.LoginResponse;
import com.csu.yuelugame.biz.response.RegisterResponse;

public interface UserService {

   LoginResponse login(long id, String password);

   RegisterResponse register(String name, String password);
}

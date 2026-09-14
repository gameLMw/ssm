package io.github.gamelmw.spring.aop.service.impl;

import io.github.gamelmw.spring.aop.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public void saveUser() {
        System.out.println("业务：保存用户");
    }
}

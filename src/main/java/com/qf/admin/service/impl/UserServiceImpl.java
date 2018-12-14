package com.qf.admin.service.impl;

import com.qf.admin.service.UserService;

public class UserServiceImpl implements UserService{
    @Override
    public void saveUser() {
        System.out.println("保存用户");
    }

    @Override
    public void deleteUser() {
        System.out.println("删除用户");
    }

    @Override
    public void updataUser() {
        System.out.println("修改用户");
    }

    @Override
    public void getUser() {
        System.out.println("获得用户");
    }
}

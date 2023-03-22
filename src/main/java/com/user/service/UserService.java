package com.user.service;

import com.user.entity.User;

import java.util.List;

public interface UserService {
    //查询所有用户
    List<User> findAll();
    //保存用户
    void save(User user);
}

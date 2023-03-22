package com.user.dao;

import com.user.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDAO {
    //查询所有用户
    List<User> findAll();

    //保存用户
    void save(User user);

}

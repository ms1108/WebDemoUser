package com.user.dao;

import com.user.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDAO {
    //查询所有用户
    List<User> findAll();

    List<User> findByPage(@Param("start") Integer start, @Param("rows") Integer rows);

    Integer findTotal();

    //保存用户
    void save(User user);

    void delete(String id);

    void update(User user);
}

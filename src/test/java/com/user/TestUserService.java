package com.user;

import com.user.entity.User;
import com.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class TestUserService {
    @Autowired
    private UserService userService;

    @Test
    public void testFindAll(){
        userService.findAll().forEach(user -> System.out.println("user = "+user));
    }

    @Test
    public void save(){
        User user = new User();
        user.setName("王小符");
        user.setBir(new Date());
        user.setSex("男");
        user.setAddress("上海浦东");
        userService.save(user);
    }

    @Test
    public void update(){
        User user = new User();
        user.setId("7");
        user.setName("王小符");
        user.setBir(new Date());
        user.setSex("男");
        user.setAddress("上海浦东");
        userService.update(user);
    }

    @Test
    public void delete(){
        userService.delete("2");
    }


}

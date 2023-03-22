package com.user.controller;

import com.user.entity.User;
import com.user.service.UserService;
import com.user.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("findAll")
    private List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping("save")
    public Result save(@RequestBody User user) {
        Result result = new Result();

        try {
            userService.save(user);
            result.setMsg("保存成功");
        } catch (Exception e) {
            result.setStatus(false);
            result.setMsg("保存失败");
            e.printStackTrace();
        }
        return result;
    }
}

package com.user.controller;

import com.alibaba.druid.util.StringUtils;
import com.user.entity.User;
import com.user.service.UserService;
import com.user.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("findData")
    private List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("findByPage")
    private Map<String, Object> findByPage(Integer pageNow, Integer pageSize) {
        Map<String, Object> map = new HashMap<>();
        pageNow = pageNow == null ? 1 : pageNow;
        pageSize = pageSize == null ? 4 : pageSize;
        List<User> userList = userService.findByPage(pageNow, pageSize);
        Integer total = userService.findTotal();
        map.put("users", userList);
        map.put("total", total);
        return map;
    }

    @PostMapping("saveOrUpdate")
    public Result saveOrUpdate(@RequestBody User user) {
        Result result = new Result();
        try {
            if (StringUtils.isEmpty(user.getId())) {
                userService.save(user);
                result.setMsg("保存成功");
            } else {
                userService.update(user);
                result.setMsg("编辑成功");
            }

        } catch (Exception e) {
            result.setStatus(false);
            result.setMsg("保存失败");
            e.printStackTrace();
        }
        return result;
    }

    @GetMapping("delete")
    public Result delete(String id) {
        Result result = new Result();
        try {
            userService.delete(id);
            result.setMsg("删除成功");
        } catch (Exception e) {
            result.setStatus(false);
            result.setMsg("删除失败");
            e.printStackTrace();
        }
        return result;


    }
}

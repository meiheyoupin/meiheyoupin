package com.meiheyoupin.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.meiheyoupin.common.R1;
import com.meiheyoupin.entity.User;
import com.meiheyoupin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    /*
    拿到所有用户 （分页）
     */
    @GetMapping("users")
    public R1 users(@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
                    @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize){
        try {
            PageHelper.startPage(pageNum,pageSize);
            List<User> list = userService.getUser();
            PageInfo<User> pageInfo = new PageInfo<User>(list);
            return R1.add("users",pageInfo);
        }catch (Exception e){
            return R1.error(500,"服务器内部错误");
        }
    }
}

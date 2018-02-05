package com.meiheyoupin.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.meiheyoupin.common.utils.R1;
import com.meiheyoupin.entity.User;
import com.meiheyoupin.service.UserService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    /*
    拿到所有用户 （分页）
     */
    @RequiresRoles("admin")
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

    /*
    拿到需要审核的公司账号
     */
    @RequiresRoles("admin")
    @GetMapping("hr")
    public R1 hr(){
        try {
            return R1.add("hr",userService.getUserToAudit());
        }catch (Exception e){
            return R1.error(500,"服务器内部错误");
        }
    }

    /*
    公司账号审核通过
     */
    @RequiresRoles("admin")
    @PostMapping("hr")
    public R1 auditHr(@RequestParam Integer id){
        try {
            userService.modifyUserToHRSuccess(id);
            return R1.success(200,"审核通过");
        }catch (Exception e){
            return R1.error(500,"服务器内部错误");
        }
    }

    /*
    公司账号审核未通过
     */
    @RequiresRoles("admin")
    @DeleteMapping("hr")
    public R1 unAuditHr(@RequestParam Integer id,
                        @RequestParam String reason){
        try {
            userService.modifyUserToHRFail(id,reason);
            return R1.success(200,"审核未通过");
        }catch (Exception e){
            return R1.error(500,"服务器内部错误");
        }
    }
}

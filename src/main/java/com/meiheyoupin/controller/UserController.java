package com.meiheyoupin.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.meiheyoupin.common.utils.R;
import com.meiheyoupin.common.utils.R1;
import com.meiheyoupin.entity.User;
import com.meiheyoupin.service.Impl.BirthdayBlessingsServiceImpl;
import com.meiheyoupin.service.UserService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author vincent
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 拿到所有用户 （分页）
     * @param pageNum
     * @param pageSize
     * @return
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
            return R1.error();
        }
    }

    /**
     * 拿到需要审核的公司账号
     * @return
     */
    @RequiresRoles("admin")
    @GetMapping("hr")
    public R1 hr(){
        try {
            return R1.add("hr",userService.getUserToAudit());
        }catch (Exception e){
            return R1.error();
        }
    }

    /**
     * 公司账号审核通过
     * @param id    账号id
     * @return  code 200成功/500失败    msg 信息
     */
    //@RequiresRoles("admin")
    @PostMapping("hrSuccess")
    public R auditHr(@RequestParam Integer id){
        return R.ok(userService.modifyUserToHRSuccess(id));
    }

    /**
     * 公司账号审核未通过
     * @param id
     * @param reason
     * @return
     */
    //@RequiresRoles("admin")
    @PostMapping("hrFail")
    public R unAuditHr(@RequestParam Integer id, @RequestParam String reason){
        return R.ok(userService.modifyUserToHRFail(id,reason));
    }

}

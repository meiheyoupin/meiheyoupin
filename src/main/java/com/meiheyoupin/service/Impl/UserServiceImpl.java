package com.meiheyoupin.service.Impl;


import com.meiheyoupin.common.exception.RRException;
import com.meiheyoupin.common.utils.R;
import com.meiheyoupin.common.utils.TTUtils;
import com.meiheyoupin.dao.BirthdayBlessingsMapper;
import com.meiheyoupin.dao.UserMapper;
import com.meiheyoupin.entity.BirthdayBlessings;
import com.meiheyoupin.entity.User;
import com.meiheyoupin.service.UserService;
import com.meiheyoupin.utils.SMSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service("userServiceImpl")
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BirthdayBlessingsMapper birthdayBlessingsMapper;

    @Override
    public List<User> getUser() {
        return userMapper.selectUser();
    }

    /**
     * 拿到需要审核成为公司账号的用户
     * @return
     */
    @Override
    public List<User> getUserToAudit() {
        return userMapper.selectUserToAudit();
    }

    /**
     * 普通用户成为公司用户成功
     * @param id
     * @return
     */
    @Override
    public R modifyUserToHRSuccess(Integer id) {
        if (id == null){
            return R.error("参数不正确");
        }
        //生成公司账号注册码
        String companyCreditCode = TTUtils.getUUIDByAmount(6);
        Optional<User> userOptional = Optional.ofNullable(userMapper.selectByPrimaryKey(id));
        log.error("成功企业用户的ID为："+userOptional.orElse(null).getId());
        //短信发送
        userOptional.ifPresent( user -> new Thread(() -> {
            try {
                SMSUtils.sendUserToHRSuccess(user.getTel(),user.getContactsName());
            }catch (Exception e){
                e.printStackTrace();
            }
        }).start());
        userOptional.ifPresent( user -> user.setCompanyCreditCode(companyCreditCode));
        try {
            BirthdayBlessings birthdayBlessings = new BirthdayBlessings();
            birthdayBlessings.setMsg(BirthdayBlessings.BIRTHDAY_DEFAULT_MSG);
            birthdayBlessings.setCompanyCreditCode(companyCreditCode);
            birthdayBlessingsMapper.insertBirthdayBlessings(birthdayBlessings);
            userMapper.updateByPrimaryKeySelective(userOptional.orElse(null));
            return R.ok("操作成功");
        }catch (Exception e){
            throw new RRException("sql操作失败");
        }
    }

    /**
     * 普通用户成为公司用户失败
     * @param id
     * @param reason
     */
    @Override
    public R modifyUserToHRFail(Integer id, String reason) {
        if (id == null || StringUtils.isEmpty(reason)){
            return R.error("参数不正确");
        }
        Optional<User> userOptional = Optional.ofNullable(userMapper.selectByPrimaryKey(id));
        log.error("失败企业用户的ID为："+userOptional.orElse(null).getId());
        userOptional.ifPresent( user -> new Thread(() -> {
            try {
                SMSUtils.sendUserToHRFail(user.getTel(),user.getContactsName(),reason);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start());
        userOptional.ifPresent( user -> {
            user.setCompanyName(null);
            user.setCompanyDepart(null);
            user.setCompanyAddr(null);
            user.setCompanyIntro(null);
        });
        if (userMapper.updateByPrimaryKey(userOptional.orElse(null)) == 0){
            return R.error("sql操作失败");
        }
        return R.ok("操作成功");
    }
}

package com.meiheyoupin.service.Impl;


import com.meiheyoupin.common.utils.TTUtils;
import com.meiheyoupin.dao.BirthdayBlessingsMapper;
import com.meiheyoupin.dao.UserMapper;
import com.meiheyoupin.entity.User;
import com.meiheyoupin.service.UserService;
import com.meiheyoupin.utils.SMSUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userServiceImpl")
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BirthdayBlessingsMapper birthdayBlessingsMapper;

    @Override
    public List<User> getUser() {
        return userMapper.selectUser();
    }

    /*
    拿到需要审核成为公司账号的用户
     */
    @Override
    public List<User> getUserToAudit() {
        return userMapper.selectUserToAudit();
    }

    /*
    普通用户成为公司用户成功
     */
    @Override
    public void modifyUserToHRSuccess(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        String companyCreditCode = TTUtils.getUUIDByAmount(6);
        user.setCompanyCreditCode(companyCreditCode);
        try {
            SMSUtils.sendUserToHRSuccess(user.getTel(),user.getContactsName());
        }catch (Exception e){
            throw new RuntimeException("短信发送失败");
        }
        birthdayBlessingsMapper.insertBirthdayBlessings(companyCreditCode);
        userMapper.updateByPrimaryKeySelective(user);
    }

    /*
    普通用户成为公司用户失败
     */
    @Override
    public void modifyUserToHRFail(Integer id, String reason) {
        User user = userMapper.selectByPrimaryKey(id);
        try {
            SMSUtils.sendUserToHRFail(user.getTel(),user.getContactsName(),reason);
        } catch (Exception e) {
            throw new RuntimeException("短信发送失败");
        }
        user.setCompanyName(null);
        user.setCompanyDepart(null);
        user.setCompanyAddr(null);
        user.setCompanyIntro(null);
        userMapper.updateByPrimaryKey(user);
    }
}

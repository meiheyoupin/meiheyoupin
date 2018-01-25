package com.meiheyoupin.service.Impl;


import com.meiheyoupin.dao.UserMapper;
import com.meiheyoupin.entity.User;
import com.meiheyoupin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> getUser() {
        return userMapper.selectUser();
    }
}

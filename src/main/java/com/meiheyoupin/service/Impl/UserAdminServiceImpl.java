package com.meiheyoupin.service.Impl;

import com.meiheyoupin.dao.UserAdminMapper;
import com.meiheyoupin.entity.UserAdmin;
import com.meiheyoupin.entity.UserAdminExample;
import com.meiheyoupin.service.UserAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("UserAdminService")
@Transactional
public class UserAdminServiceImpl implements UserAdminService {

    @Autowired
    UserAdminMapper userAdminMapper;

    @Override
    public UserAdmin getUserByPassword(UserAdmin userAdmin) {
        return userAdminMapper.selectByNameAndPassword(userAdmin);
    }

    @Override
    public List<UserAdmin> getUser() {
        return userAdminMapper.selectByExample(new UserAdminExample());
    }

    @Override
    public UserAdmin getUserByName(String username) {
        return userAdminMapper.selectByName(username);
    }

    @Override
    public String getRoleByName(String username) {
        return userAdminMapper.selectRoleByName(username);
    }


}

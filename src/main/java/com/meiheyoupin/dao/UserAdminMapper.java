package com.meiheyoupin.dao;

import com.meiheyoupin.entity.UserAdmin;
import com.meiheyoupin.entity.UserAdminExample;

import java.util.List;

public interface UserAdminMapper {
    UserAdmin selectByNameAndPassword(UserAdmin userAdmin);

    List<UserAdmin> selectByExample(UserAdminExample example);



}
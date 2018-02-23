package com.meiheyoupin.dao;

import com.meiheyoupin.entity.UserAdmin;
import com.meiheyoupin.entity.UserAdminExample;

import java.util.List;

/**
 * @author vincent
 */
public interface UserAdminMapper {
    UserAdmin selectByNameAndPassword(UserAdmin userAdmin);

    List<UserAdmin> selectByExample(UserAdminExample example);

    UserAdmin selectByName(String username);

    String selectRoleByName(String username);
}
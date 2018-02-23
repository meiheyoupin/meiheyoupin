package com.meiheyoupin.dao;

import com.meiheyoupin.entity.UserAdmin;
import com.meiheyoupin.entity.UserAdminExample;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author vincent
 */
@Repository
public interface UserAdminMapper {
    UserAdmin selectByNameAndPassword(UserAdmin userAdmin);

    List<UserAdmin> selectByExample(UserAdminExample example);

    UserAdmin selectByName(String username);

    String selectRoleByName(String username);
}
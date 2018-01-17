package com.meiheyoupin.service;


import com.meiheyoupin.entity.UserAdmin;

import java.util.List;

public interface UserAdminService {

    UserAdmin getUserByPassword(UserAdmin userAdmin);

    List<UserAdmin> getUser();

    UserAdmin getUserByName(String username);

    String getRoleByName(String username);
}

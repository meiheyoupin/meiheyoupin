package com.meiheyoupin.service;

import com.meiheyoupin.entity.User;

import java.util.List;

/**
 * Created by w2tto on 2018/1/25.
 */
public interface UserService {
    List<User> getUser();

    List<User> getUserToAudit();

    void modifyUserToHRSuccess(Integer id);

    void modifyUserToHRFail(Integer id,String reason);
}

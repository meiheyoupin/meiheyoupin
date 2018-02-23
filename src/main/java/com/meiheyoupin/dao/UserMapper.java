package com.meiheyoupin.dao;

import com.meiheyoupin.entity.User;

import java.util.List;

/**
 * @author vincent
 */
public interface UserMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectUser();

    List<User> selectUserToAudit();

    User selectUserFromRefundId(Integer refundId);
}
package com.meiheyoupin.dao;

import com.meiheyoupin.entity.Token;
import com.meiheyoupin.entity.TokenExample;

import java.util.List;

public interface TokenMapper {

    List<Token> selectByExample(TokenExample example);

    String selectByUserAdminId(Integer userAdminId);

    int insertToken(Token token);

    int deleteByExpireTime(Token token);

    int updateByToken(Token token);

    String selectByStringToken(String token);
}
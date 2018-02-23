package com.meiheyoupin.dao;

import com.meiheyoupin.entity.Token;
import com.meiheyoupin.entity.TokenExample;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author vincent
 */
@Repository
public interface TokenMapper {

    List<Token> selectByExample(TokenExample example);

    String selectByUserAdminId(Integer userAdminId);

    int insertToken(Token token);

    int deleteByExpireTime(Token token);

    int updateByToken(Token token);

    String selectByStringToken(String token);
}
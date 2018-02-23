package com.meiheyoupin.service.Impl;

import com.meiheyoupin.dao.TokenMapper;
import com.meiheyoupin.dao.UserAdminMapper;
import com.meiheyoupin.entity.Token;
import com.meiheyoupin.entity.TokenExample;
import com.meiheyoupin.entity.UserAdmin;
import com.meiheyoupin.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service("tokenService")
@Transactional
public class TokenServiceImpl implements TokenService {

    private static final int Expire = 3600*25;

    @Autowired
    UserAdminMapper userAdminMapper;

    @Autowired
    TokenMapper tokenMapper;

    @Override
    public Map<String, Object> createToken(UserAdmin userAdmin) {
        Map<String,Object> map = new HashMap<String,Object>();
        String newToken = UUID.randomUUID().toString();
        Date updateTime = new Date();
        Date expireTime = new Date(updateTime.getTime()+Expire*1000);
        UserAdmin userAdmin1 = userAdminMapper.selectByNameAndPassword(userAdmin);
        Token token = new Token(newToken,userAdmin1.getId(),updateTime,expireTime);
        if (tokenMapper.selectByUserAdminId(userAdmin1.getId())==null){
            tokenMapper.insertToken(token);
        }else {
            tokenMapper.updateByToken(token);
        }
        map.put("token",token.getToken());
        return map;
    }

    @Override
    public String queryByToken(String token) {
        return tokenMapper.selectByStringToken(token);
    }

    @Override
    public void checkExpire() {
        Date now = new Date();
        List<Token> list = tokenMapper.selectByExample(new TokenExample());
        for (Token token:list){
            if (token.getExpiretime().getTime()<now.getTime()){
                tokenMapper.deleteByExpireTime(token);
                System.out.println(token.getTokenid()+"已删除");
            }
        }
    }
}

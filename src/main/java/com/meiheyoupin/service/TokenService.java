package com.meiheyoupin.service;


import com.meiheyoupin.entity.UserAdmin;

import java.util.Map;

public interface TokenService {

    public Map<String,Object> createToken(UserAdmin userAdmin);

    public String queryByToken(String token);

    public void checkExpire();
}

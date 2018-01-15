
package com.meiheyoupin.utils;


import com.meiheyoupin.dao.GoodsMapper;
import com.meiheyoupin.dao.StoreMapper;
import com.meiheyoupin.dao.UserAdminMapper;
import com.meiheyoupin.entity.Store;
import com.meiheyoupin.entity.UserAdmin;
import com.meiheyoupin.service.GoodsService;
import com.meiheyoupin.service.StoreService;
import com.meiheyoupin.service.TokenService;
import com.meiheyoupin.service.UserAdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Autowired
    UserAdminMapper userAdminMapper;

    @Autowired
    UserAdminService userAdminService;

    @Autowired
    TokenService tokenService;

    @Autowired
    StoreService storeService;

    @Autowired
    GoodsService goodsService;

    @Test
    public void test1(){
        UserAdmin userAdmin = userAdminMapper.selectByNameAndPassword(new UserAdmin("admin", "admin"));
        System.out.println(userAdmin.getId());
    }

    @Test
    public void test2(){
        tokenService.checkExpire();
        UserAdmin userAdmin = userAdminService.getUserByPassword(new UserAdmin("admin","admin"));
        if(userAdmin!=null){
            System.out.println(tokenService.createToken(userAdmin).get("token"));
        }
    }

    @Test
    public void test3(){
        System.out.println(userAdminService.getUser().get(0).getUsername());
    }

    @Test
    public void test4(){
        Integer[] integers = new Integer[]{4};
        storeService.autidStores(integers);
    }

    @Autowired
    StoreMapper storeMapper;

    @Autowired
    GoodsMapper goodsMapper;

    @Test
    public void test5(){
        System.out.println(goodsMapper.selectGoodByGoodId(2).getContent());
    }
}


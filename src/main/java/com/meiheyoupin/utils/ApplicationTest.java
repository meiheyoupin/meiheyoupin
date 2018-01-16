
package com.meiheyoupin.utils;


import com.meiheyoupin.common.ImdadaUtils;
import com.meiheyoupin.dao.GoodsMapper;
import com.meiheyoupin.dao.OrdersMapper;
import com.meiheyoupin.dao.StoreMapper;
import com.meiheyoupin.dao.UserAdminMapper;
import com.meiheyoupin.entity.Goods;
import com.meiheyoupin.entity.Store;
import com.meiheyoupin.entity.UserAdmin;
import com.meiheyoupin.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;


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

    @Autowired
    StoreMapper storeMapper;

    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    OrdersService ordersService;

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

    @Test
    public void test5(){
        Goods good = goodsMapper.selectGoodByGoodId(1);
        Store store = storeMapper.selectStoresByStoreId(good.getStoreId());
        System.out.println(store.getStoreName());
        System.out.println(good.getName());
    }

    private static final String ADD_ORDER_URL = "http://newopen.qa.imdada.cn/api/order/addOrder";

    @Test
    public void test6(){
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("origin_id", "2016091301");
        paramMap.put("city_name", "上海");
        paramMap.put("city_code", "021");
        paramMap.put("pay_for_supplier_fee", 0.0);
        paramMap.put("fetch_from_receiver_fee", 0.0);
        paramMap.put("deliver_fee", 0.0);
        paramMap.put("tips", 0);
        paramMap.put("info", "测试订单");
        paramMap.put("cargo_price", 10);
        paramMap.put("is_prepay", 0);
        paramMap.put("expected_fetch_time", "1468996502768");
        paramMap.put("expected_finish_time", "1468996502768");
        paramMap.put("invoice_title", "测试");
        paramMap.put("receiver_name", "测试");
        paramMap.put("receiver_address", "上海市崇明岛");
        paramMap.put("receiver_phone", "18588888888");
        paramMap.put("receiver_tel", "18599999999");
        paramMap.put("receiver_lat", 31.2);
        paramMap.put("receiver_lng", 121.5);
        paramMap.put("callback", "http,//localhost:8081/receive/");
        paramMap.put("shop_no", 11047059);
        Map<String, Object> param1Map = ImdadaUtils.getRequestParam(paramMap);
        paramMap.put("signature", ImdadaUtils.getSign(param1Map));
        String response =ImdadaUtils.sendPost(ADD_ORDER_URL,ImdadaUtils.toJson(param1Map));
        System.out.println(response);
    }

}


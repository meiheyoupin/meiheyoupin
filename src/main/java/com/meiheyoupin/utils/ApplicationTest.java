
package com.meiheyoupin.utils;


import com.meiheyoupin.common.ImdadaStoreUtils;
import com.meiheyoupin.common.ImdadaOrderUtils;
import com.meiheyoupin.dao.GoodsMapper;
import com.meiheyoupin.dao.StoreMapper;
import com.meiheyoupin.dao.UserAdminMapper;
import com.meiheyoupin.entity.*;
import com.meiheyoupin.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
        System.out.println(userAdminService.getRoleByName("user"));
    }

    @Test
    public void test5(){
        Goods good = goodsMapper.selectGoodByGoodId(1);
        Store store = storeMapper.selectStoresByStoreId(good.getStoreId());
        System.out.println(store.getStoreName());
        System.out.println(good.getName());
    }

    private static final String ADD_ORDER_URL = "http://newopen.qa.imdada.cn/api/order/addOrder";

    private static final String ENTER_STORE_URL = "http://newopen.qa.imdada.cn/api/shop/add";

    @Test
    public void test7(){
        StoreInfo storeInfo = new StoreInfo();
        storeInfo.setStation_name("新门店1");
        storeInfo.setBusiness(1);
        storeInfo.setCity_name("上海");
        storeInfo.setArea_name("浦东新区");
        storeInfo.setStation_address("地址1");
        storeInfo.setLng(121.515014);
        storeInfo.setLat(31.229081);
        storeInfo.setContact_name("xxx");
        storeInfo.setPhone("13012345678");
        storeInfo.setOrigin_shop_id("shop001");

        Map map = ImdadaStoreUtils.toMap(storeInfo);
        Map<String, Object> paramMap = ImdadaStoreUtils.getRequestParam(map);
        paramMap.put("signature",ImdadaStoreUtils.getSign(paramMap));
        //String body = paramMap.get("body");
        String res = ImdadaStoreUtils.toJson(paramMap);
        System.out.println(res);
        String response = ImdadaStoreUtils.sendPost(ENTER_STORE_URL,ImdadaStoreUtils.toJson(paramMap));
        System.out.println(response);
    }

    @Test
    public void test8(){
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setShop_no("11047059");
        orderInfo.setOrigin_id("2038091513");
        orderInfo.setCity_code("021");
        orderInfo.setCargo_price(10.0);
        orderInfo.setIs_prepay(1);
        orderInfo.setExpected_fetch_time(1516103040L);
        orderInfo.setReceiver_name("测试");
        orderInfo.setReceiver_address("上海市崇明岛");
        orderInfo.setReceiver_tel("15988786205");
        orderInfo.setReceiver_lat(31.2);
        orderInfo.setReceiver_lng(121.5);
        orderInfo.setCallback("http,//localhost:8081/receive/");
        Map map = ImdadaOrderUtils.toMap(orderInfo);
        Map<String, Object> paramMap = ImdadaOrderUtils.getRequestParam(map);
        String sign = ImdadaOrderUtils.getSign(paramMap);
        paramMap.put("signature", sign);
        String response = ImdadaOrderUtils.sendPost(ADD_ORDER_URL, ImdadaOrderUtils.toJson(paramMap));
        System.out.println(response);
    }
}


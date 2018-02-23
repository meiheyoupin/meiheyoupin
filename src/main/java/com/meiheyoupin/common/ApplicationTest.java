
package com.meiheyoupin.common;


import com.meiheyoupin.dao.*;
import com.meiheyoupin.utils.ImdadaCityUtils;
import com.meiheyoupin.utils.ImdadaStoreUtils;
import com.meiheyoupin.utils.ImdadaOrderUtils;
import com.meiheyoupin.entity.*;
import com.meiheyoupin.service.*;

import com.meiheyoupin.utils.SMSUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ApplicationTest {

    public static ConcurrentHashMap<String, Thread> THREAD_CONCURRENTHASHMAP = new ConcurrentHashMap<>();

    @Autowired
    BirthdayBlessingsService birthdayBlessingsService;

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

    @Autowired
    StafferService stafferService;

    @Autowired
    SalerService salerService;

    @Autowired
    SalerMapper salerMapper;

    @Autowired
    UserService userService;

    @Autowired
    RefundService refundService;

    @Autowired
    RefundMapper refundMapper;

    @Autowired
    private OrderGoodsMapper orderGoodsMapper;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    CommentsMapper commentsMapper;

    @Autowired
    OrdersMapper ordersMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    DemandService demandService;

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @Autowired
    StafferMapper stafferMapper;

    @Autowired
    BirthdayBlessingsMapper birthdayBlessingsMapper;

    @Test
    public void test1(){
        Optional<User> userOptional = Optional.ofNullable(userMapper.selectByPrimaryKey(10));
        //短信发送
        userOptional.ifPresent( user -> new Thread(() -> {
            try {
                System.out.println("===================================================================");
            }catch (Exception e){
                e.printStackTrace();
            }
        }).start());
    }

    @Test
    public void test2(){
        System.out.println(birthdayBlessingsMapper.selectMsgByCompany("231231"));


    }

    @Test
    public void test3(){
        String str = userAdminService.getUser().get(0).getUsername();
        System.out.println(str);
    }

    @Test
    public void test4(){
        goodsService.removeGoods(688671);
    }

    @Test
    public void test5(){
        Goods good = goodsMapper.selectGoodByGoodId(1);
        Store store = storeMapper.selectStoresByStoreId(good.getStoreId());
        System.out.println(store.getName());
        System.out.println(good.getName());
    }

    private static final String ADD_ORDER_URL = "http://newopen.qa.imdada.cn/api/order/addOrder";

    private static final String ENTER_STORE_URL = "http://newopen.qa.imdada.cn/api/shop/add";

    private static final String ENTER_CITY_URL = "http://newopen.qa.imdada.cn/api/cityCode/list";

    @Test
    public void test7(){
        StoreInfo storeInfo = new StoreInfo();
        storeInfo.setStation_name("新31门1店");
        storeInfo.setBusiness(1);
        storeInfo.setCity_name("上海");
        storeInfo.setArea_name("浦东新区");
        storeInfo.setStation_address("地址1");
        storeInfo.setLng(121.515014);
        storeInfo.setLat(31.229081);
        storeInfo.setContact_name("xxx");
        storeInfo.setPhone("13012345678");
        //storeInfo.setOrigin_shop_id("shop001");

        List list = ImdadaStoreUtils.toList(storeInfo);
        Map<String, Object> paramMap = ImdadaStoreUtils.getRequestParam(list);
        String sign = ImdadaStoreUtils.getSign(paramMap);
        paramMap.put("signature",sign);
        String response = ImdadaStoreUtils.sendPost(ENTER_STORE_URL,ImdadaStoreUtils.toJson(paramMap));
        System.out.println(response);
    }


    public List<Staffer> getStaffer(){
        return stafferService.getStaffers();
    }
    public String dateToString(Date date){
        SimpleDateFormat df = new SimpleDateFormat("MM-dd");
        String res = df.format(date);
        return res;
    }

    @Test
    public void test10(){
        Map<String, Object> paramMap = ImdadaCityUtils.getRequestParam();
        String sign = ImdadaOrderUtils.getSign(paramMap);
        paramMap.put("signature", sign);
        String response = ImdadaOrderUtils.sendPost(ENTER_CITY_URL, ImdadaOrderUtils.toJson(paramMap));
        System.out.println(response);
    }

    @Autowired
    GoodsService getGoodsService;

}


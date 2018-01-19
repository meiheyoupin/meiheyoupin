
package com.meiheyoupin.common;


import com.meiheyoupin.utils.ImdadaCityUtils;
import com.meiheyoupin.utils.ImdadaStoreUtils;
import com.meiheyoupin.utils.ImdadaOrderUtils;
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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ApplicationTest {

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

    @Test
    public void test1(){
        SimpleDateFormat df = new SimpleDateFormat("MM-dd");
        Date date = stafferService.getStaffers().get(0).getBirthday();
        String current = df.format(date);
        System.out.println(current);
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
        String str = userAdminService.getUser().get(0).getUsername();
        System.out.println(str);
    }

    @Test
    public void test4(){
        String str = goodsService.getUnauditGoods().get(0).getPictureUrl();
        System.out.println(str);

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
    public void test9(){
        for (Staffer staffer:getStaffer()){
            SimpleDateFormat df = new SimpleDateFormat("MM-dd");
            String current = df.format(new Date());
            String birthday = dateToString(staffer.getBirthday());
            String msg = birthdayBlessingsService.getMsgByCompany(staffer.getCompany());
            System.out.println(msg);
            if (birthday.equals(current)){

                //SMSUtils.sendBirthdayBlessings()
                System.out.println("==================================================================================");
            }
        }
    }

    @Test
    public void test10(){
        Map<String, Object> paramMap = ImdadaCityUtils.getRequestParam();
        String sign = ImdadaOrderUtils.getSign(paramMap);
        paramMap.put("signature", sign);
        String response = ImdadaOrderUtils.sendPost(ENTER_CITY_URL, ImdadaOrderUtils.toJson(paramMap));
        System.out.println(response);
    }

    @Test
    public void test11(){
        Integer[] integers = new Integer[]{1};
        goodsMapper.updateGoodsByStatus(integers,2);
    }
}


package com.meiheyoupin.controller;

import com.meiheyoupin.common.ImdadaOrderUtils;
import com.meiheyoupin.common.ImdadaStoreUtils;
import com.meiheyoupin.entity.OrderInfo;
import com.meiheyoupin.entity.StoreInfo;
import com.meiheyoupin.utils.R1;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ImdadaController {

    //订单派送url       测试
    private static final String ADD_ORDER_URL = "http://newopen.qa.imdada.cn/api/order/addOrder";

    //商家入驻url       测试
    private static final String ENTER_STORE_URL = "http://newopen.qa.imdada.cn/api/shop/add";

    /*
    订单派送接口
     */
    @PostMapping("imdada_send")
    public R1 toImdadaSend(@RequestBody OrderInfo orderInfo){
        try {
            Map map = ImdadaOrderUtils.toMap(orderInfo);
            Map<String, Object> paramMap = ImdadaOrderUtils.getRequestParam(map);
            String sign = ImdadaOrderUtils.getSign(paramMap);
            paramMap.put("signature", sign);
            String response = ImdadaOrderUtils.sendPost(ADD_ORDER_URL, ImdadaOrderUtils.toJson(paramMap));
            return R1.add("result",response);
        }catch (Exception e){
            return R1.error(500,"服务器内部错误");
        }
    }

    /*
    商家入驻接口
     */
    @PostMapping("imdada_enter")
    public R1 toImdadaEnter(@RequestBody StoreInfo storeInfo){
        try {
            List list = ImdadaStoreUtils.toList(storeInfo);
            Map<String, Object> paramMap = ImdadaStoreUtils.getRequestParam(list);
            String sign = ImdadaStoreUtils.getSign(paramMap);
            paramMap.put("signature",sign);
            String response = ImdadaStoreUtils.sendPost(ENTER_STORE_URL,ImdadaStoreUtils.toJson(paramMap));
            System.out.println(response);
            return R1.success(200,"商家入驻成功");
        }catch (Exception e){
            return R1.success(500,"服务器内部错误");
        }
    }
}

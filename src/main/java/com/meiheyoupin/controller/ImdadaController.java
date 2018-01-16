package com.meiheyoupin.controller;

import com.meiheyoupin.common.ImdadaUtils;
import com.meiheyoupin.entity.OrderInfo;
import com.meiheyoupin.utils.R1;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    public R1 toImdadaSend(@RequestBody OrderInfo orderinfo){
        try {
            Map<String, Object> paramMap = ImdadaUtils.getRequestParam(ImdadaUtils.toMap(orderinfo));
            paramMap.put("signature", ImdadaUtils.getSign(paramMap));
            String response =ImdadaUtils.sendPost(ADD_ORDER_URL,ImdadaUtils.toJson(paramMap));
            System.out.println(response);
            return R1.success(200,"订单发送成功");
        }catch (Exception e){
            return R1.success(500,"服务器内部错误");
        }
    }

    /*
    商家入驻接口
     */
    @PostMapping("imdada_enter")
    public R1 toImdadaEnter(){
        try {

            return R1.success(200,"商家入驻成功");
        }catch (Exception e){
            return R1.success(500,"服务器内部错误");
        }
    }
}

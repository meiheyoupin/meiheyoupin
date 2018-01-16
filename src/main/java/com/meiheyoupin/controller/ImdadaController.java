package com.meiheyoupin.controller;

import com.meiheyoupin.common.ImdadaUtils;
import com.meiheyoupin.entity.orderInfo;
import com.meiheyoupin.utils.R1;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ImdadaController {

    private static final String ADD_ORDER_URL = "http://newopen.qa.imdada.cn/api/order/addOrder";

    @PostMapping("imdada")
    public R1 toImdada(@RequestBody orderInfo orderinfo){
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
}

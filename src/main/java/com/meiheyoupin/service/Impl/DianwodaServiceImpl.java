package com.meiheyoupin.service.Impl;

import com.meiheyoupin.common.entity.DianwodaResponseData;
import com.meiheyoupin.service.DianwodaService;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

import static com.meiheyoupin.utils.DianwodaUtils.doRequest;

@Service
public class DianwodaServiceImpl implements DianwodaService {

    //创建发货点测试url
    private static final String ADD_STORE_URL = "http://60.191.68.46:43580/api/v3/batchsave-store.json";

    //商家入驻到点我达
    @Override
    public DianwodaResponseData addStore(String shops) {
        Map<String, Object> params = new HashMap<>();
        params.put("shops", shops);
        return doRequest(ADD_STORE_URL, params);
    }
}

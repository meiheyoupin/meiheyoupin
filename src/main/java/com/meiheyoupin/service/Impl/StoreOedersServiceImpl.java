package com.meiheyoupin.service.Impl;

import com.meiheyoupin.dao.OrdersMapper;
import com.meiheyoupin.dao.StoreMapper;
import com.meiheyoupin.entity.Store;
import com.meiheyoupin.entity.WithdrawCash;
import com.meiheyoupin.service.StoreOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class StoreOedersServiceImpl implements StoreOrdersService {

    @Autowired
    OrdersMapper ordersMapper;

    @Autowired
    StoreMapper storeMapper;

    @Override
    public Map<String, Object> getWithdrawCash() {
        Map<String, Object> map = new HashMap<>();
        Optional<List<WithdrawCash>> optional = Optional.ofNullable(ordersMapper.selectAvaiableWithdrawCash());
        if (!optional.isPresent()){
            map.put("ok","暂时没有可提现的金额");
            return map;
        }
        for (WithdrawCash withdrawCash:optional.get()){
            Store store = storeMapper.selectStoresByStoreId(withdrawCash.getStoreId());
            withdrawCash.setStoreTel(store.getTel());
            withdrawCash.setStoreName(store.getName());
        }
        map.put("withdrawCashes",optional.get());
        return map;
    }
}

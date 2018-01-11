
package com.meiheyoupin.service.Impl;


import com.meiheyoupin.dao.StoreMapper;
import com.meiheyoupin.entity.Store;
import com.meiheyoupin.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreMapper storeMapper;

    @Override
    public void autidStores(Integer[] storeIds) {
        storeMapper.updateStoreStateByStoreId(storeIds);
    }

    @Override
    public List<Store> getUnauditStores() {
        return storeMapper.selectUnauditStores();
    }
}

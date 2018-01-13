
package com.meiheyoupin.service.Impl;


import com.meiheyoupin.common.SMSUtils;
import com.meiheyoupin.dao.StoreMapper;
import com.meiheyoupin.entity.Store;
import com.meiheyoupin.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;


@Service
@Transactional
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreMapper storeMapper;

    @Override
    public void autidStores(Integer[] storeIds) {
        storeMapper.updateStoreStateByStoreId(storeIds);
        for (int i = 0;i<storeIds.length;i++){
            sendSMS(storeIds[i]);
        }
    }

    @Override
    public List<Store> getUnauditStores() {
        return storeMapper.selectUnauditStores();
    }

    /*
    发送短信并且设置密码
     */
    public void sendSMS(Integer storeId){
        Store store = null;
        store = storeMapper.selectStoresByStoreId(storeId);
        String password = UUID.randomUUID().toString().substring(0,8);
        Boolean Sms = false;
        try {
            Sms = SMSUtils.auditStoresMessage(store.getTel(),
                    store.getTel(),
                    password);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            storeMapper.updatePasswordByStoreId(new Store(storeId,password));
        }
    }

}

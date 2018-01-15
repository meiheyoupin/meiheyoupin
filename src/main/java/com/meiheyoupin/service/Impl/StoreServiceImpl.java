
package com.meiheyoupin.service.Impl;


import com.aliyuncs.exceptions.ClientException;
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
    public List<Store> getUnauditStores() {
        return storeMapper.selectUnauditStores();
    }

    @Override
    public void autidStores(Integer[] storeIds) {
        storeMapper.updateStoreStateByStoreId(storeIds);
        for (int i = 0;i<storeIds.length;i++){
            sendSMSSuccess(storeIds[i]);
        }
    }

    @Override
    public void unsanctionedStores(Integer[] storeIds) {
        storeMapper.updateStoreStateByStoreIdRefuse(storeIds);
        for (int i=0;i<storeIds.length;i++){
            sendSMSRefuse(storeIds[i]);
        }
    }

    /*
    通过审核（发送短信并且设置密码）
     */
    public void sendSMSSuccess(Integer storeId){
        Store store = storeMapper.selectStoresByStoreId(storeId);
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
    /*
    未通过审核（发送短信）
     */
    public void sendSMSRefuse(Integer storeId){
        Store store = storeMapper.selectStoresByStoreId(storeId);
        try {
            SMSUtils.unsanctionedStoreMessage(store.getTel(),store.getTel());
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}

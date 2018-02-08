
package com.meiheyoupin.service.Impl;


import com.aliyuncs.exceptions.ClientException;
import com.meiheyoupin.utils.SMSUtils;
import com.meiheyoupin.dao.StoreMapper;
import com.meiheyoupin.entity.Store;
import com.meiheyoupin.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
@Transactional
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreMapper storeMapper;

    @Override
    public List<Store> getStoresByState(Integer state) {
        return storeMapper.selectStoreByState(state);
    }

    @Override
    public void autidStores(Integer[] storeIds) {
        storeMapper.updateStoreStateByStoreId(storeIds);
        for (int i = 0;i<storeIds.length;i++){
            sendSMSSuccess(storeIds[i]);
        }
    }

    @Override
    public void unsanctionedStores(Integer[] storeIds,String reason) {
        storeMapper.updateStoreStateByStoreIdRefuse(storeIds);
        for (int i=0;i<storeIds.length;i++){
            sendSMSRefuse(storeIds[i],reason);
        }
    }

    @Override
    public void modifyStore(Store store) {
        store.setUpdateTime(new Date());
        storeMapper.updateStore(store);
    }

    /*
    根据商家实体类查询所对应的商家
     */
    @Override
    public Map<String, Object> getStoresByInvitationCode(String inviteCode) {
        Map<String,Object> map = new HashMap<String,Object>();
        Store store = new Store();
        store.setInvitationCode(inviteCode);
        map.put("stores",storeMapper.selectStoreByObj(store));
        return map;
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
            store.setPassword(password);
            storeMapper.updatePasswordByStoreId(store);
        }
    }
    /*
    未通过审核（发送短信）
     */
    public void sendSMSRefuse(Integer storeId,String reason){
        Store store = storeMapper.selectStoresByStoreId(storeId);
        try {
            SMSUtils.unsanctionedStoreMessage(store.getTel(),reason);
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}

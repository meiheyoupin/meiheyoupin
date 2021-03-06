
package com.meiheyoupin.service;

import com.meiheyoupin.entity.Store;

import java.util.List;
import java.util.Map;

public interface StoreService {

    void autidStores(Integer[] storeIds);

    List<Store> getStoresByState(Integer state);

    void unsanctionedStores(Integer[] storeIds,String reason);

    void modifyStore(Store store);

    Map<String, Object> getStoresByInvitationCode(String inviteCode);
}

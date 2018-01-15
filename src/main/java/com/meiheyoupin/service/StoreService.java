
package com.meiheyoupin.service;

import com.meiheyoupin.entity.Store;

import java.util.List;

public interface StoreService {

    void autidStores(Integer[] storeIds);

    List<Store> getUnauditStores();

    void unsanctionedStores(Integer[] storeIds);
}

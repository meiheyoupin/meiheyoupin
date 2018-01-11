package com.meiheyoupin.dao;

import com.meiheyoupin.entity.Store;
import com.meiheyoupin.entity.StoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoreMapper {
    /*
    根据商家ID进行审核
     */
    int updateStoreStateByStoreId(Integer[] storeIds);

    /*
    拿到所有未审核的商家
     */
    List<Store> selectUnauditStores();
}
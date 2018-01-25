package com.meiheyoupin.dao;

import com.meiheyoupin.entity.Store;
import com.meiheyoupin.entity.StoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoreMapper {
    /*
    根据商家ID进行审核(通过审核）
     */
    int updateStoreStateByStoreId(Integer[] storeIds);

    /*
    根据商家状态拿到商家
     */
    List<Store> selectStoreByState(Integer state);

    /*
    根据商家ID拿到商家实体
     */
    Store selectStoresByStoreId(Integer storeId);

    /*
    根据商家ID修改商家密码
     */
    int updatePasswordByStoreId(Store store);

    /*
    根据商家ID进行审核(未通过审核）
     */
    int updateStoreStateByStoreIdRefuse(Integer[] storeIds);

    /*
    根据商家实体类修改商家
     */
    int updateStore(Store store);
}
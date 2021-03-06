package com.meiheyoupin.dao;

import com.meiheyoupin.entity.Store;
import com.meiheyoupin.entity.StoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author vincent
 */
@Repository
public interface StoreMapper {

    /*
    根据商家实体类查询所对应的商家
     */
    List<Store> selectStoreByObj(Store store);

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

    /*
    根据商家实体类修改商家（实体类部分信息）
     */
    int updateStoreById(Store store);

    /*
    拿到已上线的商铺实体
     */
    List<Store> selectAvailableStore();
}
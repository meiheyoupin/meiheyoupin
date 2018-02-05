package com.meiheyoupin.dao;

import com.meiheyoupin.entity.Goods;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsMapper {

    List<Goods> selectGoodsBySate(Integer state);

    void updateGoodByGoodId(Goods goods);

    void updateGoodStateByGoodId(@Param("id")Integer id,@Param("state")Integer state);

    int updateGoodsStateByGoodsIds(Integer[] goodsIds);

    Goods selectGoodByGoodId(Integer goodId);

    int updateGoodsStateByGoodsIdsRefuse(Integer[] goodsIds);

    int updateGoodsByStatus(@Param("goodIds") Integer[] goodIds,@Param("state") Integer state);

    int updateGoodsStockByLimit();

    int updateGoods(Goods goods);

    Integer selectStoreIdByGoodsId(String id);

    Double selectAvgGradeByStoreId(Integer storeId);

    String selectMostPopularGoodsMonthlyByStoreId(Integer storeId);

    String selectMostDismalGoodsMonthlyByStoreId(Integer storeId);
}
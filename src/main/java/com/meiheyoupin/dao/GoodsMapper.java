package com.meiheyoupin.dao;

import com.meiheyoupin.entity.Goods;
import com.meiheyoupin.entity.GoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsMapper {
    List<Goods> selectUnauditGoods();

    int updateGoodsStateByGoodsIds(Integer[] goodsIds);

    Goods selectGoodByGoodId(Integer goodId);
}
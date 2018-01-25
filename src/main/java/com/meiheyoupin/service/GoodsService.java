
package com.meiheyoupin.service;

import com.meiheyoupin.entity.Goods;

import java.util.List;

public interface GoodsService {

    List<Goods> getGoodsByState(Integer state);

    void modifyGoods(Goods goods);

    void removeGoods(Integer goodId);

    void auditGoods(Integer[] goodsIds);

    void unsanctionedGoods(Integer[] goodsIds,String reason);

    void downGoods(Integer[] goodIds);

    void upGoods(Integer[] goodIds);
}

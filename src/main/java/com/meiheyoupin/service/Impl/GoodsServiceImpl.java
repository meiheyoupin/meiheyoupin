
package com.meiheyoupin.service.Impl;



import com.meiheyoupin.common.SMSUtils;
import com.meiheyoupin.dao.GoodsMapper;
import com.meiheyoupin.dao.StoreMapper;
import com.meiheyoupin.entity.Goods;
import com.meiheyoupin.entity.Store;
import com.meiheyoupin.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private StoreMapper storeMapper;

    @Override
    public List<Goods> getUnauditGoods() {
        return goodsMapper.selectUnauditGoods();
    }

    @Override
    public void auditGoods(Integer[] goodsIds) {
        goodsMapper.updateGoodsStateByGoodsIds(goodsIds);
        for (int i=0;i<goodsIds.length;i++){
            sendAuditGoodsMessage(goodsIds[i]);
        }
    }

    @Override
    public void unsanctionedGoods(Integer[] goodsIds) {
        goodsMapper.updateGoodsStateByGoodsIdsRefuse(goodsIds);
        for (int i=0;i<goodsIds.length;i++){

        }
    }

    public void sendAuditGoodsMessage(Integer goodId){
        Goods good = goodsMapper.selectGoodByGoodId(goodId);
        Store store = storeMapper.selectStoresByStoreId(good.getStoreId());
        try {
            SMSUtils.auditGoodsMessage(store.getTel(),store.getStoreName(),good.getName());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}


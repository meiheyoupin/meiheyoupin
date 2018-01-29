
package com.meiheyoupin.service.Impl;



import com.meiheyoupin.utils.SMSUtils;
import com.meiheyoupin.dao.GoodsMapper;
import com.meiheyoupin.dao.StoreMapper;
import com.meiheyoupin.entity.Goods;
import com.meiheyoupin.entity.Store;
import com.meiheyoupin.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Date;
import java.util.List;

@Transactional
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private StoreMapper storeMapper;

    @Override
    public List<Goods> getGoodsByState(Integer state) {
        List<Goods> list = goodsMapper.selectGoodsBySate(state);
        return list;
    }

    @Override
    public void modifyGoods(Goods goods) {
        goods.setUpdateTime(new Date());
        goodsMapper.updateGoodByGoodId(goods);
    }

    @Override
    public void removeGoods(Integer goodId) {
        goodsMapper.updateGoodStateByGoodId(goodId,4);
    }

    /*
    套餐审核通过
     */
    @Override
    public void auditGoods(Integer[] goodsIds) {
        goodsMapper.updateGoodsStateByGoodsIds(goodsIds);
        for (int i=0;i<goodsIds.length;i++){
            sendAuditGoodsMessage(goodsIds[i]);
        }
    }

    /*
    套餐审核未通过
     */
    @Override
    public void unsanctionedGoods(Integer[] goodsIds,String reason) {
        goodsMapper.updateGoodsStateByGoodsIdsRefuse(goodsIds);
        for (int i=0;i<goodsIds.length;i++){
            sendUnsanctionedGoods(goodsIds[i],reason);
        }
    }

    /*
    套餐下架
     */
    @Override
    public void downGoods(Integer[] goodIds) {
        goodsMapper.updateGoodsByStatus(goodIds,3);
    }

    /*
    套餐上架
     */
    @Override
    public void upGoods(Integer[] goodIds) {
        goodsMapper.updateGoodsByStatus(goodIds,1);
    }

    /*
    恢复每日限量
     */
    @Override
    public void resetStock() {
        goodsMapper.updateGoodsStockByLimit();
    }

    /*
    套餐审核通过短信发送
     */
    public void sendAuditGoodsMessage(Integer goodId){
        Goods good = goodsMapper.selectGoodByGoodId(goodId);
        Store store = storeMapper.selectStoresByStoreId(good.getStoreId());
        try {
            SMSUtils.auditGoodsMessage(store.getTel(),store.getStoreName(),good.getName());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /*
    套餐审核未通过短信发送
     */
    public void sendUnsanctionedGoods(Integer goodId,String reason){
        Goods good = goodsMapper.selectGoodByGoodId(goodId);
        Store store = storeMapper.selectStoresByStoreId(good.getStoreId());
        try {
            SMSUtils.unsanctionedGoodMessage(store.getTel(),store.getStoreName(),good.getName(),reason);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}


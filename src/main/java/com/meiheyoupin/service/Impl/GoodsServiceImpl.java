
package com.meiheyoupin.service.Impl;



import com.alibaba.fastjson.JSON;
import com.meiheyoupin.dao.OrderGoodsMapper;
import com.meiheyoupin.entity.OrderGoods;
import com.meiheyoupin.entity.Orders;
import com.meiheyoupin.utils.SMSUtils;
import com.meiheyoupin.dao.GoodsMapper;
import com.meiheyoupin.dao.StoreMapper;
import com.meiheyoupin.entity.Goods;
import com.meiheyoupin.entity.Store;
import com.meiheyoupin.service.GoodsService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.*;

@Transactional
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private StoreMapper storeMapper;

    /*
      根据套餐状态查找套餐
     */
    @Override
    public List<Goods> getGoodsByState(Integer state) {
        return goodsMapper.selectGoodsBySate(state);
    }

    /*
      根据套餐状态查找套餐和对应的商家
     */
    @Override
    public List<Map> getGoodsAndStoreByState(Integer state) {
        List<Map> result = new ArrayList<>();
        List<Goods> list = goodsMapper.selectGoodsBySate(state);
        for (Goods goods:list){
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("good",goods);
            map.put("store",storeMapper.selectStoresByStoreId(goods.getStoreId()));
            result.add(map);
        }
        return result;
    }

    /*
    修改套餐
     */
    @Override
    public void modifyGoods(Goods goods) {
        goods.setUpdateTime(new Date());
        goodsMapper.updateGoodByGoodId(goods);
    }

    /*
    删除套餐
     */
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


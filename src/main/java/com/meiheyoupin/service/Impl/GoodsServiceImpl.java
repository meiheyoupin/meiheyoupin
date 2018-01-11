
package com.meiheyoupin.service.Impl;



import com.meiheyoupin.dao.GoodsMapper;
import com.meiheyoupin.entity.Goods;
import com.meiheyoupin.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> getUnauditGoods() {
        return goodsMapper.selectUnauditGoods();
    }

    @Override
    public void auditGoods(Integer[] goodsIds) {
        goodsMapper.updateGoodsStateByGoodsIds(goodsIds);
    }


}


package com.meiheyoupin.dao;

import com.meiheyoupin.entity.OrderGoods;

/**
 * @author vincent
 */
public interface OrderGoodsMapper {

    int insert(OrderGoods record);

    int insertSelective(OrderGoods record);

    int updateByPrimaryKeySelective(OrderGoods record);

    int updateByPrimaryKey(OrderGoods record);

    OrderGoods selectObjByOrderId(String orderId);
}
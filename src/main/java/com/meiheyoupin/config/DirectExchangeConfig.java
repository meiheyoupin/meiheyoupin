package com.meiheyoupin.config;


import com.alibaba.fastjson.JSON;
import com.meiheyoupin.dao.GoodsMapper;
import com.meiheyoupin.dao.OrderGoodsMapper;
import com.meiheyoupin.dao.StoreMapper;
import com.meiheyoupin.entity.Goods;
import com.meiheyoupin.entity.OrderGoods;
import com.meiheyoupin.entity.Orders;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

@Configuration
public class DirectExchangeConfig {

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("direct");
    }

    @Bean
    public Queue queue1(){
        return new Queue("queue1");
    }
    @Bean
    public Queue queue2(){
        return new Queue("queue2");
    }
    @Bean
    public Queue queue3(){
        return new Queue("queue3");
    }

    @Bean
    public Binding binding1(){
        return BindingBuilder.bind(queue1()).to(directExchange()).with("key1");
    }
    @Bean
    public Binding binding2(){
        return BindingBuilder.bind(queue2()).to(directExchange()).with("key2");
    }
    @Bean
    public Binding binding3(){
        return BindingBuilder.bind(queue3()).to(directExchange()).with("key3");
    }

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private OrderGoodsMapper orderGoodsMapper;

    /*
    套餐减库存
     */
    @RabbitHandler
    @RabbitListener(queues = "queue2")
    @Transactional
    public void reduceStock(String msg){
        try {
            Orders orders = JSON.parseObject(msg,Orders.class);
            OrderGoods orderGoods = orderGoodsMapper.selectObjByOrderId(orders.getId());
            Goods goods = goodsMapper.selectGoodByGoodId(Integer.valueOf(orderGoods.getGoodsId()));
            goods.setStockAmount(goods.getStockAmount()-orderGoods.getCount());
            goodsMapper.updateGoods(goods);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /*
    套餐库存恢复
     */
    @RabbitHandler
    @RabbitListener(queues = "queue3")
    @Transactional
    public void recoveryStock(String msg){
        try {
            Orders orders = JSON.parseObject(msg,Orders.class);
            System.out.println(orders.toString());
            OrderGoods orderGoods = orderGoodsMapper.selectObjByOrderId(orders.getId());
            Goods goods = goodsMapper.selectGoodByGoodId(Integer.valueOf(orderGoods.getGoodsId()));
            goods.setStockAmount(goods.getStockAmount()+orderGoods.getCount());
            goodsMapper.updateGoods(goods);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

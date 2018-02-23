package com.meiheyoupin.utils;


import com.aliyuncs.exceptions.ClientException;
import com.meiheyoupin.dao.CommentsMapper;
import com.meiheyoupin.dao.GoodsMapper;
import com.meiheyoupin.dao.OrdersMapper;
import com.meiheyoupin.dao.StoreMapper;
import com.meiheyoupin.entity.MonthlyCount;
import com.meiheyoupin.entity.Staffer;
import com.meiheyoupin.entity.Store;
import com.meiheyoupin.service.BirthdayBlessingsService;
import com.meiheyoupin.service.GoodsService;
import com.meiheyoupin.service.StafferService;
import com.meiheyoupin.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author vincent
 */
@Component
public class ScheduledUtils {

    @Autowired
    StafferService stafferService;

    @Autowired
    BirthdayBlessingsService birthdayBlessingsService;

    @Autowired
    GoodsService goodsService;

    @Autowired
    StoreService storeService;

    @Autowired
    CommentsMapper commentsMapper;

    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    OrdersMapper ordersMapper;

    @Autowired
    StoreMapper storeMapper;




    /*
    每天恢复库存限量
     */
    @Scheduled(cron = "0 0 6 * * ?")        //每日六点
    public void recoveryStock(){
        goodsService.resetStock();
    }





    /*
    生日祝福
     */
    @Scheduled(cron = "0 0 8 * * ?")        //每天早上八点
    public void sendBirthday() throws ClientException {
        for (Staffer staffer:getStaffer()){
            SimpleDateFormat df = new SimpleDateFormat("MM-dd");
            String current = df.format(new Date());
            String birthday = dateToString(staffer.getBirthday());
            if (birthday.equals(current)){
                String msg = birthdayBlessingsService.getMsgByCompany(staffer.getCompanyCreditCode());
                SMSUtils.sendBirthdayBlessings(staffer.getPhone(),staffer.getName(),msg);
            }
        }
    }
    //日期格式转换
    public String dateToString(Date date){
        SimpleDateFormat df = new SimpleDateFormat("MM-dd");
        String res = df.format(date);
        return res;
    }
    //拿到所有员工
    public List<Staffer> getStaffer(){
        return stafferService.getStaffers();
    }






    /*
    商家月底账单
     */
    @Scheduled(cron = "0 0 8 1 * ?")        //每月1号早上八点
    public void sendBill(){
        ExecutorService es = Executors.newFixedThreadPool(10);
        List<Store> list = storeMapper.selectAvailableStore();
        for (Store store:list){
            es.submit(new BillThread(store.getEmail(),store));
        }
        es.shutdown();
    }
    //月底账单邮件发送线程
    private class BillThread implements Runnable{
        private String email;
        private Store store;
        public BillThread(String email,Store store){
            this.email = email;
            this.store = store;
        }
        @Override
        public void run() {
            MonthlyCount monthlyCount = getMonthlySalesAndOrders(store.getId());
            String content = "尊敬的"+store.getName()+"美盒掌柜您好，" +
                    "您上月销售额度为："+monthlyCount.getMonthlySales()+"元，上月总运费为："+getMonthlyCarriageByStoreId(store.getId())+
                    "元，成交订单数为："+monthlyCount.getMonthlyOrders()+"。用户"+
                    "对本店商品评价了"+CommentsOfCount(store.getId())+"个。本店商品总体评价"+getAvgGradeByStoreId(store.getId())+"分"+
                    "。本店最受欢迎的商品是："+getMostPopularGoodsByStoreId(store.getId())+"。" +
                    "本店被冷漠的商品是："+getMostDismalGoodsByStoreId(store.getId());
            LocalDate date = LocalDate.now();
            date = date.minusMonths(1);
            String theme = store.getName() + "店铺" + date.getYear()+ "-" +date.getMonthValue() + "月份数据分析";
            System.out.println(DirectMailUtils.sendMail(email,theme,content));
        }
    }
    //上个月某商铺的成交销售额(MonthlySales),成交订单数(MonthlyOrders)
    private MonthlyCount getMonthlySalesAndOrders(Integer storeId){
        return ordersMapper.selectMonthlySalesByStoreId(storeId);
    }
    //上个月某商铺，被评论的商品数
    private int CommentsOfCount(Integer storeId){
        int count = 0;
        List<String> goodsIdList = commentsMapper.selectListGoodsIdForLastMonths();
        for (String goodsId:goodsIdList){
            if (goodsMapper.selectStoreIdByGoodsId(goodsId)==storeId){
                count++;
            }
        }
        return count;
    }
    //上个月某商铺，所有商品的平均评分
    private String getAvgGradeByStoreId(Integer storeId){
        return new DecimalFormat("#.00").format(goodsMapper.selectAvgGradeByStoreId(storeId));
    }
    //上个月某商铺销量最好的套餐名
    private String getMostPopularGoodsByStoreId(Integer storeId){
        return goodsMapper.selectMostPopularGoodsMonthlyByStoreId(storeId);
    }
    //上个月某商铺销量最差的套餐名
    private String getMostDismalGoodsByStoreId(Integer storeId){
        return goodsMapper.selectMostDismalGoodsMonthlyByStoreId(storeId);
    }
    //上个月某商铺的月运费总结
    private String getMonthlyCarriageByStoreId(Integer storeId){
        return new DecimalFormat("#.00").format(ordersMapper.selectMonthlyCarriageByStoreId(storeId));
    }
}

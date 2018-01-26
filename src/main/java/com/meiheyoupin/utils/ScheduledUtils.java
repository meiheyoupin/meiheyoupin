package com.meiheyoupin.utils;


import com.aliyuncs.exceptions.ClientException;
import com.meiheyoupin.entity.Staffer;
import com.meiheyoupin.service.BirthdayBlessingsService;
import com.meiheyoupin.service.GoodsService;
import com.meiheyoupin.service.StafferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Component
public class ScheduledUtils {

    @Autowired
    StafferService stafferService;

    @Autowired
    BirthdayBlessingsService birthdayBlessingsService;

    @Autowired
    GoodsService goodsService;

    public List<String> getBirthdays(){
        return stafferService.getBirthdays();
    }

    public String dateToString(Date date){
        SimpleDateFormat df = new SimpleDateFormat("MM-dd");
        String res = df.format(date);
        return res;
    }

    public List<Staffer> getStaffer(){
        return stafferService.getStaffers();
    }


    //生日祝福定时器
    @Scheduled(cron = "0 0 8 * * ?")        //每天早上八点
    public void sendBirthday() throws ClientException {
        for (Staffer staffer:getStaffer()){
            SimpleDateFormat df = new SimpleDateFormat("MM-dd");
            String current = df.format(new Date());
            String birthday = dateToString(staffer.getBirthday());
            if (birthday.equals(current)){
                String msg = birthdayBlessingsService.getMsgByCompany(staffer.getCompany());
                SMSUtils.sendBirthdayBlessings(staffer.getPhone(),staffer.getName(),msg);
            }
        }
    }

    //月底账单定时器
    @Scheduled(cron = "0 0 8 1 * ?")        //每月1号早上八点
    public void sendBill(){
        DirectMailUtils.sendMail("1341870251@qq.com","主题","正文");
    }

    //每天恢复每日限量库存
    @Scheduled(cron = "0 0 6 * * ?")        //每日六点
    public void recoveryStock(){
        goodsService.resetStock();
    }
}

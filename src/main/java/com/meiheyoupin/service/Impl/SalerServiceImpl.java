package com.meiheyoupin.service.Impl;

import com.meiheyoupin.dao.SalerMapper;
import com.meiheyoupin.entity.Saler;
import com.meiheyoupin.entity.SalerExample;
import com.meiheyoupin.service.SalerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class SalerServiceImpl implements SalerService {

    @Autowired
    SalerMapper salerMapper;

    @Override
    public List<Saler> getSalers() {
        return salerMapper.selectSalers();
    }

    @Override
    public void addSaler(Saler saler) {
        for (int i=0;i<10;i++){
            String invitationCode = getCard();
            if (salerMapper.selectSalerByCode(invitationCode)==null){
                saler.setInvitationCode(invitationCode);
                break;
            }
        }

        saler.setCreateTime(new Date());
        saler.setUpdateTime(new Date());
        salerMapper.insertSaler(saler);
    }

    @Override
    public void putSaler(Saler saler) {
        saler.setUpdateTime(new Date());
        salerMapper.updateSaler(saler);
    }

    @Override
    public void removeSaler(Integer id) {
        salerMapper.deleteSaler(id);
    }

    //生成6位随机数
    public static String getCard(){
        Random rand=new Random();//生成随机数
        String cardNnumer="";
        for(int a=0;a<6;a++){
            cardNnumer+=rand.nextInt(10);//生成6位数字
        }
        return cardNnumer;
    }
}

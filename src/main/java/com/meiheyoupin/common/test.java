package com.meiheyoupin.common;

import com.aliyuncs.exceptions.ClientException;
import com.meiheyoupin.utils.VoiceCallUtils;

import java.util.Random;


public class test {

    public static void main(String[] args) throws ClientException, InterruptedException {
        while (true){
            System.out.println(getCard());
        }
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

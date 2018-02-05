package com.meiheyoupin.common;

import com.aliyuncs.exceptions.ClientException;
import com.meiheyoupin.utils.XMailUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.concurrent.locks.ReentrantLock;


public class test {

    private static int j = 3;

    public static ReentrantLock lock = new ReentrantLock();

    private static String o = "str";

    public static void main(String[] args) throws ClientException, InterruptedException, UnsupportedEncodingException {
        double i = 2.325321321;
        String format = new DecimalFormat("#.00").format(i);
        System.out.println(format);
        String res = URLEncoder.encode("美盒优品","UTF-8");
        System.out.println(res);
        String res1 = URLDecoder.decode("%E7%BE%8E%E7%9B%92%E4%BC%98%E5%93%81","UTF-8");
        System.out.println(res1);
    }

    private void myRun(){
        new Thread(){
            @Override
            public void run(){
                try {
                    int frequency = 0;
                    for (int i = 0;i<3;i++){
                        Thread.sleep(2000);
                        if (1==j){
                            break;
                        }
                        frequency += 1;
                        System.out.println(frequency);
                        if (frequency<3){
                            System.out.println("============Hello World====================");
                        }else {
                            System.out.println("===============BOOM========================");
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }.start();


    }
}

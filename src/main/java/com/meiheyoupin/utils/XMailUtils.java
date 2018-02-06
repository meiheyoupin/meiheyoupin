package com.meiheyoupin.utils;


import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;

public class XMailUtils {

    public static boolean sendMail(String receiver,String content){
        try {
            JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
            //发送方

            //陆晓涛 网易 个人
            mailSender.setHost("smtp.163.com");
            mailSender.setUsername("t1341870251@163.com");
            mailSender.setPassword("xltys1995");

            //美盒优品 阿里 企业
            /*mailSender.setHost("smtp.mxhichina.com");
            mailSender.setPort(465);
            mailSender.setUsername("postmaster@meiheyoupin.com");
            mailSender.setPassword("MHYP_2018");*/

            MimeMessage mailMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mailMessage,true,"GBK");
            helper.setFrom(mailSender.getUsername());
            helper.setTo(receiver);
            helper.setSubject("【美盒优品】");
            helper.setText("邮件发送成功");
            helper.setText(content,true);
            mailSender.send(mailMessage);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }



}

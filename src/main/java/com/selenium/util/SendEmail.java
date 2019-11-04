package com.selenium.util;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 * @program: mooc_selenium
 * @description:发送邮件工具类
 * @author: wanglx
 * @create: 2019-10-30 23:11
 **/

public class SendEmail {
    public static void sendToEmail(String content){
        SimpleEmail email = new SimpleEmail ();
        email.setHostName ( "smtp.163.com" );
        email.setAuthentication ( "tangtang8160@163.com","tangtang816" );
        try {
            email.setFrom ( "tangtang8160@163.com" );
            email.addTo ( "862383060@qq.com" );
            email.setSubject ( "selenium自动化测试邮件" );
            email.setContent ( content,"text/html;charset=utf-8" );
            email.send ();
        } catch (EmailException e) {
            e.printStackTrace ();
        }
    }

    public static void main(String[] args) {
        sendToEmail ("我们测试");
    }
}

    
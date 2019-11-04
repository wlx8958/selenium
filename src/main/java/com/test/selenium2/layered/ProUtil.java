package com.test.selenium2.layered;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @program: selenium
 * @description:
 * @author: wanglx
 * @create: 2019-10-22 17:16
 **/

public class ProUtil {
    private Properties properties;
    private String filePath;

    /**
     * 构造方法获取路径 "src/main/resources/login.properties"
     * @param filePath
     */
    public ProUtil(String filePath) {
        this.filePath = filePath;
        this.properties = readProperties ();
    }
    /**
     *  读取配置文件
     * @return
     */
    private Properties readProperties(){
        //创建对象
        Properties properties =new Properties ();
        try {
            //读取配置文件信息
            InputStream fileInputStream = new FileInputStream ( filePath );
            BufferedInputStream bufferedInputStream = new BufferedInputStream ( fileInputStream );
            properties.load ( bufferedInputStream );
        } catch (IOException e) {
            e.printStackTrace ();
        }
        return properties;
    }


    public String getPro(String key) {
        if (properties.containsKey ( key )){
            String uname = properties.getProperty ( key );
            return uname;
        }else {
            System.out.println ("您获取的key值不正确");
            return "";
        }

    }


}

    
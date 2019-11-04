package com.test.selenium1;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * @program: selenium
 * @description:
 * @author: wanglx
 * @create: 2019-10-11 21:29
 **/

public class selenium1 {


    public static void main(String[] args) {


        //设置geckodriver路径
        System.setProperty("webdriver.gecko.driver","/usr/local/bin/geckodriver");

        //初始化FireFox浏览器实例
        WebDriver driver = new FirefoxDriver();
        //最大化窗口
        driver.manage().window().maximize();
        //设置隐性等待时间
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        //打开一个站点
        driver.get("http://www.baidu.com/");
    }

}


package com.test.selenium1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * @program: selenium
 * @description: 元素定位
 * @author: wanglx
 * @create: 2019-10-18 09:41
 **/

public class localTest1 {


    public static void main(String[] args) {
        WebDriver driver;
        System.setProperty ( "webdriver.firefox.driver","/usr/local/bin/geckodriver" );
        driver = new FirefoxDriver (  );
        driver.get ( "http://baidu.com" );
        //设置等待时间
        driver.manage ().timeouts ().implicitlyWait ( 5,TimeUnit.SECONDS );
        //根据id获取元素，并输入信息
       // driver.findElement ( By.id ("kw") ).sendKeys ( "selenium" );
        //根据name获取元素，并输入信息
        //driver.findElement ( By.name ( "wd" ) ).sendKeys ( "webdriver" );
        //根据classname获取元素，并输入信息
        //driver.findElement ( By.className ( "s_ipt" ) ).sendKeys ( "chrome" );
        //未实现
        //driver.findElement ( By.tagName ( "input" ) ).sendKeys ( "test" );

        //driver.findElement ( By.linkText ( "学术" ) ).click ();
        //driver.findElement ( By.partialLinkText ( "学" )).click ();
        //driver.findElement ( By.xpath ( "//*[@id=\"kw\"]" ) ).sendKeys ("test");
        driver.findElement ( By.cssSelector ( "#kw" ) ).sendKeys ( "test" );
    }
}

    
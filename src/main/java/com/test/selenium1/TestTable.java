package com.test.selenium1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

/**
 * @program: selenium
 * @description:
 * @author: wanglx
 * @create: 2019-10-18 10:33
 **/

public class TestTable {
    public static void main(String[] args) {
        WebDriver driver;
        String str="第二行第五列";
        String str1="第四行第四列";
       // System.setProperty ( "webdriver.firefox.bin" ,"/Applications/Firefox.app/Contents/MacOS/firefox");
        System.setProperty ( "webdriver.firefox.driver","/usr/local/bin/geckodriver" );
        driver = new FirefoxDriver ();

        driver.get ( "http://127.0.0.1:8020/HTML第三天/table.html" );
        //System.out.print ( driver.findElement ( By.tagName ("table") ).getClass () );

        WebElement table = driver.findElement ( By.tagName ( "table" ) );
        /**
            table.findElement ( By.tagName ( "tr" ) );
            findElement：定位单一元素的方法
            findElements 定位一组元素的方法
         */
        //返回一个WebElement数组
        List<WebElement> trs = table.findElements ( By.tagName ( "tr" ) );
        for (WebElement tr: trs) {
            List<WebElement> ths = tr.findElements ( By.tagName ( "th" ) );
            for (WebElement th:ths) {
                //System.out.println (th.getText ());
                String value = th.getText ();
                if (value.equals ( str )||value.equals ( str1 )){
                    System.out.println (value);
                }else {
                    System.out.println ("不存在");
                }
            }

        }
        /**
         * 关键字驱动
         * 数字驱动
         * 混合驱动
         */

    }
}

    
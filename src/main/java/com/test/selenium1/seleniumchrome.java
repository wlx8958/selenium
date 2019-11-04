package com.test.selenium1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @program: selenium
 * @description:
 * @author: wanglx
 * @create: 2019-10-14 12:09
 **/
public class seleniumchrome {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
       // ChromeOptions options=new ChromeOptions();

        driver =new ChromeDriver();

        driver.get("https://www.baidu.com");
        Thread.sleep(5000);
        driver.close();


    }
}

package com.selenium.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @program: selenium
 * @description: 浏览器封装
 * @author: wanglx
 * @create: 2019-10-23 01:01
 **/

public class SelectDriver {
    public WebDriver driverName(String brower){
        if (brower.equalsIgnoreCase ( "fireFox" )){
            System.setProperty ( "webdriver.firefox.driver","/usr/local/bin/geckodriver" );
            return new FirefoxDriver ();
        }else {
            System.setProperty( "webdriver.chrome.driver", "/usr/local/bin/chromedriver");
            return new ChromeDriver (  );
        }
    }
}

    
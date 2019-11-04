package com.test.selenium2.testng;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

/**
 * @program: selenium
 * @description:
 * @author: wanglx
 * @create: 2019-10-23 00:32
 **/

public class BaseDriver {
    WebDriver driver;

    public BaseDriver() {
        //配置环境变量
        System.setProperty( "webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver =new ChromeDriver (  );
    }
    /**
     * 截图并且进行封装
     * 登录失败
     */
    public void takeScreenShot(){
        long date = System.currentTimeMillis ();
        String path = String.valueOf ( date );
        //获取当前系统路径
        String curPath = System.getProperty ( "user.dir" );
        path =path+".png";
        String screenPath = curPath+"/"+path;
        System.out.println (screenPath);
        File screen = ((TakesScreenshot) driver).getScreenshotAs ( OutputType.FILE );
        try {
            FileUtils.copyFile ( screen, new File ( screenPath ));
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }
}

    
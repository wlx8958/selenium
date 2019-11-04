package com.test.selenium1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * @program: selenium
 * @description:
 * @author: wanglx
 * @create: 2019-10-14 17:47
 **/

public class test {
    public WebDriver driver;

    @Test
    public void main(){
        driver.navigate().to("http://www.baidu.com");
        String title = driver.getTitle();
        System.out.println("Page title:"+ title);
        driver.findElement(By.id("kw")).sendKeys(new String[] {"selenium"});//找到kw元素的id，然后输入hello
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.findElement(By.id("su")).click(); //点击按扭
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeClass
    public void openChrome(){
        // cherome driver
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
      //  ChromeOptions chromeOptions = new ChromeOptions();
        // 设置为 headless 模式 （无头浏览器）
       // chromeOptions.addArguments("--headless");
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
        //设置隐性等待时间
        //driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    }

    @BeforeClass
    public void openFirefox(){
        // firefox driver
        System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Mozilla Firefox\\geckodriver.exe");
        //如果你使用firefox版本低于48，例如我之前用firefox esr 45版本，就这个代码就好报错，有机会你可以试试。如果真要低于48版本的火狐上运行geckodirver.exe，那么你的代码就要使用以下这一行代码。
        // System.setProperty("webdriver.firefox.marionette","C:\\Program Files\\Mozilla Firefox\\geckodriver.exe");

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        //设置隐性等待时间
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    }

    @AfterClass
    public void afterMethod(){
        driver.quit();
    }
}

    
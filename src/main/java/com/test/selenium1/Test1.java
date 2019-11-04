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
 * @create: 2019-10-18 13:48
 **/

public class Test1 {

    public static void main(String[] args) {
        WebDriver driver;
        System.setProperty ( "webdriver.firefox.driver","/usr/local/bin/geckodriver" );
        driver = new FirefoxDriver (  );
        driver.get ( "https://www.imooc.com/user/newlogin" );
        driver.findElement ( By.tagName ("input") ).sendKeys ( "862383060@qq.com" );
        driver.findElement ( By.name ( "password" )).sendKeys ( "mkqwe123" );
        driver.findElement ( By.id ( "auto-signin" ) ).click ();
       // driver.findElement ( By.linkText ( "注册" ) ).click ();
       // driver.findElement ( By.partialLinkText ( "登录" ) ).click ();
       // driver.findElement ( By.name ( "password" )).sendKeys ( "mkqwe123" );
        driver.findElement ( By.className ( "xa-login" ) ).click ();
        driver.manage ().window ().maximize ();
        driver.get ( "https://www.imooc.com/" );
        driver.findElement ( By.className ( "search-input" ) ).click ();
        driver.findElement ( By.className ( "search-input" ) ).sendKeys ( "java" );
        WebElement element = driver.findElement ( By.className ( "nav-item" ) );
        List<WebElement> elements = element.findElements ( By.tagName ( "li" ) );
        elements.get ( 3 ).click ();
    }

}

    
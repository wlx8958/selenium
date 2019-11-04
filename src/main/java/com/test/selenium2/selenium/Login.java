package com.test.selenium2.selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


/**
 * @program: selenium
 * @description:
 * @author: wanglx
 * @create: 2019-10-22 15:46
 **/

public class Login {
    public WebDriver driver;
    @Test
    public void InitDriver(){
        //配置环境变量
        System.setProperty( "webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver =new ChromeDriver (  );
        //获取地址
        driver.get ( "https://www.imooc.com" );
        //最大化窗口
        driver.manage ().window ().maximize ();
    }
    @Test(dependsOnMethods = {"InitDriver"})
    public void loginScript() throws Exception {
        driver.findElement ( By.id ("js-signin-btn") ).click ();
        Thread.sleep ( 3000 );
        WebElement emil = driver.findElement ( By.name ( "email" ) );
        emil.isDisplayed ();
        WebElement password = driver.findElement ( By.name ( "password" ) );
        password.isDisplayed ();
        WebElement loginButton = driver.findElement ( By.className ( "moco-btn" ) );
        loginButton.isDisplayed ();
        emil.sendKeys ( "862383060@qq.com" );
        password.sendKeys ( "mkqwe123" );
        loginButton.click ();

        Thread.sleep ( 3000 );

        WebElement header = driver.findElement ( By.id ( "header-avator" ) );

        header.isDisplayed ();

        Actions actions = new Actions (driver);
        //移动
        actions.moveToElement ( header ).perform ();
        String userInfo = driver.findElement ( By.className ("name" ) ).getText ();
        if (userInfo.equals ( "84消毒液" )){
            System.out.println ("登录成功");
        }else {
            System.out.println ("登录失败");
        }

    }

   /* public static void main(String[] args) throws Exception {
        Login login = new Login ();
        login.InitDriver ();
        login.loginScript ();
    }*/
}
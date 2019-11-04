package com.test.selenium2.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * @program: selenium
 * @description:
 * @author: wanglx
 * @create: 2019-10-22 15:46
 **/

public class NewLogin {
    public WebDriver driver;
    public void InitDriver() throws InterruptedException {
        //配置环境变量
        System.setProperty( "webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver =new ChromeDriver (  );
        //获取地址
        driver.get ( "https://www.imooc.com" );
        //最大化窗口
        driver.manage ().window ().maximize ();
        driver.findElement ( By.id ("js-signin-btn") ).click ();
        Thread.sleep ( 3000 );
    }
    public void loginScript() throws Exception {
        this.InitDriver ();
        //定义获取属性类型
        String Bname ="name";
        String Bid ="id";
        String Bclass="className";
        //定义属性
        String Eemail= "email";
        String Epassword="password";
        String EButton ="moco-btn";
        String Eheader = "header-avator";
        String Ename="name";
        //定义输入值
        String uname = "862383060@qq.com";
        String pwd = "mkqwe123";

        WebElement emil = driver.findElement ( this.bystr ( Bname,Eemail ) );
        emil.isDisplayed ();
        WebElement password = driver.findElement (this.bystr ( Bname,Epassword ));
        password.isDisplayed ();

        WebElement loginButton = driver.findElement ( this.bystr ( Bclass,EButton ) );
        loginButton.isDisplayed ();
        emil.sendKeys ( uname );
        password.sendKeys ( pwd );
        loginButton.click ();

        Thread.sleep ( 3000 );

        WebElement header = driver.findElement ( this.bystr (Bid, Eheader ) );

        header.isDisplayed ();

        Actions actions = new Actions (driver);
        //移动
        actions.moveToElement ( header ).perform ();
        String userInfo = driver.findElement ( this.bystr (Bclass, Ename ) ).getText ();
        System.out.println (userInfo);
        if (userInfo.equals ( "84消毒液" )){
            System.out.println ("登录成功");
        }else {
            System.out.println ("登录失败");
        }

    }

    /**
     * 封装By by
     * @return
     */
    public By bystr(String by, String local){
        if (by.equals ( "id" )){
            return By.id ( local );
        }else if (by.equals ( "name" )){
            return By.name ( local );
        }else if (by.equals ( "className" )){
            return By.className ( local );
        }else {
            return By.xpath ( local );
        }
    }

    public static void main(String[] args) throws Exception {
        NewLogin login = new NewLogin ();

        login.loginScript ();
    }
}
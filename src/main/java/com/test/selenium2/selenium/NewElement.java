package com.test.selenium2.selenium;

import com.test.selenium2.layered.ProUtil;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @program: selenium
 * @description:
 * @author: wanglx
 * @create: 2019-10-22 15:46
 **/

public class NewElement {
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
    public void loginScript(String uname, String pwd ) throws InterruptedException {
        this.InitDriver ();
        WebElement emil = this.element ( this.bystr ( "uname") );
        // WebElement emil = this.element ( this.bystr ( Bname,Eemail ) );
        emil.isDisplayed ();
        WebElement password = this.element (this.bystr ( "pwd" ));
        password.isDisplayed ();

        WebElement loginButton = this.element( this.bystr ( "loginbutton" ) );
        loginButton.isDisplayed ();
        emil.sendKeys ( uname );
        password.sendKeys ( pwd );
        loginButton.click ();
        Thread.sleep ( 3000 );
        WebElement header = this.element( this.bystr ( "header" ) );
        header.isDisplayed ();
        Actions actions = new Actions (driver);
        //移动
        actions.moveToElement ( header ).perform ();
        String userInfo = this.element ( this.bystr ( "uInfo" ) ).getText ();
        if (userInfo.equals ( "84消毒液" )){
            this.takeScreenShot ();
            System.out.println ("登录成功");
        }else {
            System.out.println ("登录失败");
        }
        driver.close ();
    }

    /**
     * 封装By by
     * @return
     */
    public By bystr(String uname){
        ProUtil proUtil = new ProUtil ( "src/main/resources/login.properties" );
        String locator = proUtil.getPro ( uname );
        String locatorType = locator.split ( ">" )[0];
        String locatorValue = locator.split ( ">" )[1];
        if (locatorType.equals ( "id" )){
            return By.id ( locatorValue );
        }else if (locatorType.equals ( "name" )){
            return By.name ( locatorValue );
        }else if (locatorType.equals ( "className" )){
            return By.className ( locatorValue );
        }else {
            return By.xpath ( locatorValue );
        }
    }

    /**
     * 封装Element
     */
    public WebElement element(By by){
        WebElement ele = driver.findElement ( by );
        return ele;
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
    @Test
    public void loginpage() throws InterruptedException {
        HashMap<String, String> user = new HashMap<> ();
        user.put ( "862383060@qq.com", "mkqwe123" );
        user.put ("18600161825","mkqwe123");
        Iterator<Map.Entry<String, String>> us = user.entrySet ().iterator ();
        while (us.hasNext ()){
            Map.Entry<String, String> entry = us.next ();
            String uname = entry.getKey ();
            String pwd = entry.getValue ();
            this.loginScript ( uname, pwd);

        }
    }

    /*public static void main(String[] args) throws Exception {
        NewElement login = new NewElement ();

        //login.loginScript ("862383060@qq.com","mkqwe123");
        HashMap<String, String> user = new HashMap<> ();
        user.put ( "862383060@qq.com", "mkqwe123" );
        user.put ("18600161825","mkqwe123");
        Iterator<Map.Entry<String, String>> us = user.entrySet ().iterator ();
        while (us.hasNext ()){
            Map.Entry<String, String> entry = us.next ();
            String uname = entry.getKey ();
            String pwd = entry.getValue ();
            login.loginScript ( uname, pwd);

        }
    }*/
}
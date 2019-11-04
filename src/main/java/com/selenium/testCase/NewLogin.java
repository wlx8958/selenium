package com.selenium.testCase;

import com.selenium.base.DriverBase;
import com.selenium.business.HomePagePro;
import com.selenium.business.LoginPro;
import com.selenium.util.CookieUtil;
import com.test.selenium2.layered.ProUtil;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * @program: mooc_selenium
 * @description:
 * @author: wanglx
 * @create: 2019-10-31 16:37
 **/

public class NewLogin extends CaseBase {
    public DriverBase driver;
    public LoginPro loginPro;
    public HomePagePro homePagePro;
    ProUtil pro;
    CookieUtil cookieUtil;
    @BeforeClass
    public void beforeClass() {
        this.driver = InitDriver ( "chrome" );
        pro =new ProUtil ( "src/main/resources/LoginTest.properties" );
        driver.driver.manage ().timeouts ().implicitlyWait ( 10,TimeUnit.SECONDS );
        loginPro = new LoginPro ( driver );
        homePagePro = new HomePagePro ( driver );
        cookieUtil = new CookieUtil ( driver );
        driver.get ( pro.getPro ( "url" ) );

    }
    @Test
    public void TestLogin(){
        String uname = pro.getPro ( "uname" );
        String pwd = pro.getPro ( "pwd" );
        loginPro.login (uname ,pwd );
        if (homePagePro.AssertLogin(pro.getPro ( "yq" )) ){
            System.out.println ("登录成功"+uname);

            driver.max ();

            try {
                Thread.sleep ( 5000 );
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }

            driver.findElement ( By.className ( "redrain-redPacketsIMG" ) ).findElement ( By.className ( "redrain-closeBtn" ) ).click ();
            cookieUtil.writeCookie ();
        }
    }
    @AfterClass
    public void afterClass(){
        driver.close ();
    }
}

    
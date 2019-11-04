package com.selenium.testCase;

import com.selenium.base.DriverBase;
import com.selenium.business.CoursePagePro;
import com.selenium.util.CookieUtil;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @program: mooc_selenium
 * @description:
 * @author: wanglx
 * @create: 2019-11-04 12:05
 **/

public class SuiteTestBuy extends CaseBase {
    DriverBase driver;
    CoursePagePro coursePagePro;
    CookieUtil cookieUtil;
    @BeforeClass
    public void beforeClass(){
        this.driver = InitDriver ( "chrome" );
        coursePagePro = new CoursePagePro ( driver );
        //获取cookie
        cookieUtil = new CookieUtil ( driver );
        driver.get ( "https://coding.imooc.com/class/362.html" );
        cookieUtil.setCookie ();
        driver.get ( "https://coding.imooc.com/class/362.html" );
        driver.max ();

        try {
            Thread.sleep ( 5000 );
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }

        driver.findElement ( By.className ( "redrain-redPacketsIMG" ) ).findElement ( By.className ( "redrain-closeBtn" ) ).click ();



        try {
            Thread.sleep ( 3000 );
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
    }

    @AfterClass
    public void afterClass(){
        driver.close ();

    }

    @Test
    public void testBuy(){
        coursePagePro.buyNow ();
        try {
            Thread.sleep ( 3000 );
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }

    }
}

    
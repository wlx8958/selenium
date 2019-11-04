package com.selenium.handle;

import com.selenium.base.DriverBase;
import com.selenium.page.HomePage;

/**
 * @program: mooc_selenium
 * @description:
 * @author: wanglx
 * @create: 2019-10-31 16:49
 **/

public class HomePageHandle {
    public DriverBase driver;
    public HomePage homePage;

    public HomePageHandle(DriverBase driver) {
        this.driver = driver;
        homePage = new HomePage ( driver );
    }
    /**
     * 点击登陆按钮
     * */
    public void clickLogin(){
        homePage.click(homePage.getLoginElement());
    }

    /**
     * 点击实战按钮
     * */
    public void clickCoding(){
        homePage.click(homePage.getCodingElement());
    }
    /**
     * 获取用户名
     * */
    public String getUserName(){
        String username = homePage.getText(homePage.getUserNameElement());
        return username;
    }



}

    
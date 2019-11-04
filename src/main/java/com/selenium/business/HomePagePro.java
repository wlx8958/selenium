package com.selenium.business;

import com.selenium.base.DriverBase;
import com.selenium.handle.HomePageHandle;
import com.selenium.page.HomePage;

/**
 * @program: mooc_selenium
 * @description:
 * @author: wanglx
 * @create: 2019-10-31 16:43
 **/

public class HomePagePro {
    public DriverBase driver;
    public HomePageHandle homePageHandle;

    public HomePagePro(DriverBase driver) {
        this.driver = driver;
        homePageHandle = new HomePageHandle (driver);
    }
    /**
     * 点击登陆按钮
     * */
    public void clickLoginButton(){
        homePageHandle.clickLogin();
    }
    /**
     * 点击实战按钮
     * */
    public void clickCodingLink(){
        homePageHandle.clickCoding();
    }
    /**
     * 根据用户名判断登陆信息是否正确
     * */
    public Boolean AssertLogin(String username){
        if(homePageHandle.getUserName().equals(username)){
            return true;
        }
        return false;
    }

}

    
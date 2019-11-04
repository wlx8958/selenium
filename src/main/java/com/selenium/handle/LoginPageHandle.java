package com.selenium.handle;

import com.selenium.base.DriverBase;
import com.selenium.page.LoginPage;

/**
 * @program: mooc_selenium
 * @description: 操作页面,输入信息的封装
 * @author: wanglx
 * @create: 2019-10-24 01:27
 **/

public class LoginPageHandle {
    public DriverBase driver;
    //实例化LoginPage获取element
    public LoginPage loginPage;

    public LoginPageHandle(DriverBase driver) {
        this.driver = driver;
        loginPage=new LoginPage (driver);
    }

    /**
     * 输入用户名
     * @param uname
     */
    public void sendKeyUname(String uname){
        loginPage.sendKeys ( loginPage.getUserElement (),uname );
    }

    /**
     * 输入密码
     * @param pwd
     */
    public void sendKeyPwd(String pwd){
        loginPage.sendKeys ( loginPage.getPwdelement (),pwd );
    }

    /**
     * 点击7点自动登录
     */
    public void clickAutoSignin(){
        loginPage.click ( loginPage.getAutoSigninElement () );
    }

    /**
     * 点击登录
     */
    public void clickLoginButton(){
        loginPage.click ( loginPage.getButtonElement () );
    }

    /**
     * 判断是否为登录页面
     */
    public Boolean assertLoginPage(){
        return loginPage.assertElementIs ( loginPage.getUserElement () );
    }
}

    
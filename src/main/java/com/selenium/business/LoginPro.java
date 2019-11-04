package com.selenium.business;

import com.selenium.base.DriverBase;
import com.selenium.handle.LoginPageHandle;

/**
 * @program: mooc_selenium
 * @description:业务操作层
 * @author: wanglx
 * @create: 2019-10-24 01:36
 **/

public class LoginPro {
    LoginPageHandle loginPageHandle;

    /**
     *
     * 不理解
     */
    public LoginPro(DriverBase driver) {
       loginPageHandle = new LoginPageHandle (driver);
    }

    //登录操作的封装
    public void login(String uname,String pwd){
        if (loginPageHandle.assertLoginPage ()){
            loginPageHandle.sendKeyUname ( uname );
            loginPageHandle.sendKeyPwd ( pwd );
            loginPageHandle.clickAutoSignin ();
            loginPageHandle.clickLoginButton ();
        }else {
            System.out.println ("页面不存在或页面元素错误");
        }
    }
}

    
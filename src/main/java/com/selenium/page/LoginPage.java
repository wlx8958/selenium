package com.selenium.page;

import com.selenium.base.DriverBase;
import com.selenium.util.GetByLocator;
import org.openqa.selenium.WebElement;

/**
 * @program: mooc_selenium
 * @description: 获取element
 * @author: wanglx
 * @create: 2019-10-24 01:09
 **/

public class LoginPage extends BasePage{

    public LoginPage(DriverBase driver) {
        super ( driver );
    }

    /**
     * 从配置文件中获取用户名elemen
     * @return
     */
    public WebElement getUserElement(){
       return element ( GetByLocator.getByLocator ( "uname" ) );
    }

    /**
     * 从配置文件中获取密码elemen
     * @return
     */
    public WebElement getPwdelement(){
        return element ( GetByLocator.getByLocator ( "pwd" ) );
    }

    /**
     * 从配置文件中获取登录按钮elemen
     * @return
     */
    public WebElement getButtonElement(){
        return element ( GetByLocator.getByLocator ( "loginbutton" ) );
    }

    /**
     * 从配置文件中获取自动7天登录按钮elemen
     * @return
     */
    public WebElement getAutoSigninElement(){
        return element ( GetByLocator.getByLocator ( "autoSignin" ) );
    }
}

    
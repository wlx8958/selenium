package com.selenium.page;


import com.selenium.base.DriverBase;
import com.selenium.util.GetByLocator;
import org.openqa.selenium.WebElement;

/**
 * @program: mooc_selenium
 * @description:
 * @author: wanglx
 * @create: 2019-10-31 16:50
 **/

public class HomePage extends BasePage{
    public HomePage(DriverBase driver){
        super(driver);
    }
    /**
     * 获取点击登陆element
     * */
    public WebElement getLoginElement(){
        return element(GetByLocator.getByLocator ("login"));
    }
    /**
     * 获取实战element
     * */
    public WebElement getCodingElement(){
        return nodeElement(GetByLocator.getByLocator("tophead"),GetByLocator.getByLocator("coding"));
    }

    /**
     * 获取用户名信息element
     * */
    public WebElement getUserNameElement(){
        action(element(GetByLocator.getByLocator("header")));
        return element(GetByLocator.getByLocator("uInfo"));
    }



}

    
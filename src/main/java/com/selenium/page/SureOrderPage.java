package com.selenium.page;

import com.selenium.base.DriverBase;
import com.selenium.util.GetByLocator;
import org.openqa.selenium.WebElement;

/**
 * @program: mooc_selenium
 * @description:
 * @author: wanglx
 * @create: 2019-10-30 15:20
 **/

public class SureOrderPage extends BasePage {
    public SureOrderPage(DriverBase driver) {
        super ( driver );
    }
    /**
     * 获取提交订单按钮
     */
    public WebElement getSubOrderElement(){
        return element ( GetByLocator.getByLocator ( "suresOrder" ) );
    }
    /**
     * 获取移步订单中心按钮
     */
    public WebElement getGoOrderlistElement(){
        return element ( GetByLocator.getByLocator ( "GoOrderlist" ) );
    }
}

    
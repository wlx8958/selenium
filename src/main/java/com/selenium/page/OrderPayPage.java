package com.selenium.page;

import com.selenium.base.DriverBase;
import com.selenium.util.GetByLocator;
import org.openqa.selenium.WebElement;

/**
 * @program: mooc_selenium
 * @description:
 * @author: wanglx
 * @create: 2019-10-30 22:29
 **/

public class OrderPayPage extends BasePage {
    public OrderPayPage(DriverBase driver) {
        super(driver);
    }
    /**
     * 获取订单号element
     */
    public WebElement getOrderNumElement(){
        return element (GetByLocator.getByLocator ( "orderNum" ) );
    }
    /**
     * 获取课程名称element
     */
    public WebElement getOrderCourseNameElement(){
        return nodeElement ( GetByLocator.getByLocator ( "orderCourse" ),GetByLocator.getByLocator ( "orderCourseNode" ) );
    }
    /**
     * 获取支付方式"支付宝"element
     */
    public WebElement getAliPayElement(){
        return element ( GetByLocator.getByLocator ( "alipay" ) );
    }
    /**
     * 获取立即支付element
     */

    public WebElement getOrderPayElement(){
        return element ( GetByLocator.getByLocator ( "orderpay" ) );
    }

}

    
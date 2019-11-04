package com.selenium.handle;

import com.selenium.base.DriverBase;
import com.selenium.page.OrderPayPage;

/**
 * @program: mooc_selenium
 * @description:
 * @author: wanglx
 * @create: 2019-10-30 22:42
 **/

public class OrderPayPageHandle {
    DriverBase driver;
    OrderPayPage orderPayPage;

    public OrderPayPageHandle(DriverBase driver) {
        this.driver = driver;
        orderPayPage = new OrderPayPage ( driver );
    }

    /**
     * 获取订单号
     * @return
     */
    public String getOrderNum(){
        return orderPayPage.getText (orderPayPage.getOrderNumElement ());
    }
    /**
     * 获取课程名称
     */
    public String getOrderCourseName(){
        return orderPayPage.getText ( orderPayPage.getOrderCourseNameElement () );
    }
    /**
     * 点击支付宝支付
     */
    public void clickAlipay(){
        orderPayPage.click ( orderPayPage.getAliPayElement () );
    }
    /**
     * 点击立即支付
     */
    public void clickPayelement(){
        orderPayPage.click ( orderPayPage.getOrderPayElement () );
    }
}

    
package com.selenium.business;

import com.selenium.base.DriverBase;
import com.selenium.handle.OrderPayPageHandle;

/**
 * @program: mooc_selenium
 * @description:
 * @author: wanglx
 * @create: 2019-10-30 22:48
 **/

public class OrderPayPro {
    DriverBase driver;
    OrderPayPageHandle orderPayPageHandle;
    public OrderPayPro(DriverBase driver) {
        this.driver = driver;
        orderPayPageHandle = new OrderPayPageHandle ( driver );
    }
    /**
     * 根据课程、订单判断跳转到支付页面
     */
    public void orderPayPro(){
        try {
            Thread.sleep ( 3000 );
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
        String orderNum = orderPayPageHandle.getOrderNum ();
        String orderCourseName = orderPayPageHandle.getOrderCourseName ();
        if (orderNum!=null&&orderCourseName!=null){
            orderPayPageHandle.clickAlipay ();
            orderPayPageHandle.clickPayelement ();
        }
    }
}

    
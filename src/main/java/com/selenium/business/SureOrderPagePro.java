package com.selenium.business;

import com.selenium.base.DriverBase;
import com.selenium.handle.SureOrderHandle;

/**
 * @program: mooc_selenium
 * @description:
 * @author: wanglx
 * @create: 2019-10-30 16:17
 **/

public class SureOrderPagePro {
    SureOrderHandle sureOrderHandle;
    DriverBase driver;

    public SureOrderPagePro(DriverBase driver) {
        this.driver =driver;
        sureOrderHandle = new SureOrderHandle ( driver );
    }
    /**
     * 确认订单按钮
     */
    public void sureOrder(){
        sureOrderHandle.clickSubOrderElement ();
    }
}

    
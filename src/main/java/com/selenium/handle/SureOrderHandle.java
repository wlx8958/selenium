package com.selenium.handle;

import com.selenium.base.DriverBase;
import com.selenium.page.SureOrderPage;

/**
 * @program: mooc_selenium
 * @description:
 * @author: wanglx
 * @create: 2019-10-30 15:52
 **/

public class SureOrderHandle {
    public DriverBase driver;
    public SureOrderPage sureOrderPage;
    public SureOrderHandle(DriverBase driver) {
        this.driver = driver;
        sureOrderPage = new SureOrderPage ( driver );
    }
    /**
     * 点击提交订单按钮
     */
    public void clickSubOrderElement(){
        sureOrderPage.click ( sureOrderPage.getSubOrderElement () );
    }
    /**
     * 点击移步订单中心
     */
    public void clickGoOrderlistElement(){
        sureOrderPage.click ( sureOrderPage.getGoOrderlistElement () );
    }
}

    
package com.selenium.handle;

import com.selenium.base.DriverBase;
import com.selenium.page.CoursePage;

/**
 * @program: mooc_selenium
 * @description:
 * @author: wanglx
 * @create: 2019-10-25 10:18
 **/

public class CoursePageHandle {
    public DriverBase driver;
    public CoursePage coursePage;

    public CoursePageHandle(DriverBase driver) {
        this.driver = driver;
        coursePage = new CoursePage ( driver );
    }
    /**
     * 点击立即购买按钮
     */
    public void clickBuyNow(){
        coursePage.click ( coursePage.getBuytriggerElement () );
    }
    /**
     * 点击添加购物车按钮
     */
    public void clickAddCart(){
        coursePage.click ( coursePage.getBuyCartElement () );
    }
    /**
     * 点击右上角购物车
     */
    public void clickShopCart(){
        coursePage.click ( coursePage.getShopCartElement () );
    }
    /**
     * 获取购物车数量
     */
    public String getShopCartNum(){
       return coursePage.getText (coursePage.getShopCartNumElement ());
    }
    /**
     * 获取课程名称
     */
    public String getCourseName(){
        return coursePage.getText ( coursePage.getCourseNameElement () );
    }

    /**
     * 去结算
     */
    public void clickGoPay(){
        coursePage.click ( coursePage.getGoPayElement () );
    }
    /**
     * 点击已经购买弹窗的继续逛按钮
     */
    public void clickeReadybuyClose(){
        coursePage.click ( coursePage.getreadybuyCloseElement () );
    }
    /**
     * 点击已经购买弹窗的去购物车按钮
     */

    public void clickGotoCart(){
        coursePage.click ( coursePage.getGotoCartElement () );
    }

}

    
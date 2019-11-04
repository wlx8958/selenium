package com.selenium.business;

import com.selenium.base.DriverBase;
import com.selenium.handle.CoursePageHandle;

/**
 * @program: mooc_selenium
 * @description:
 * @author: wanglx
 * @create: 2019-10-25 10:30
 **/

public class CoursePagePro {
    public DriverBase driver;
    public CoursePageHandle coursePageHandle;

    public CoursePagePro(DriverBase driver) {
        this.driver = driver;
        coursePageHandle = new CoursePageHandle(driver);
    }
    /**
     * 添加购物车
     */
    public void addCart(){
        int beforeNum = 0;
        String aftercourseNum;

        int afterNum;
        String shopCartNum = coursePageHandle.getShopCartNum ();
        try {
            beforeNum = Integer.valueOf ( shopCartNum );
            System.out.println (beforeNum);
        }catch (Exception e){
            beforeNum=0;
        }

        coursePageHandle.clickAddCart ();
        //购物车已存在该商品执行此操作
        try {
            driver.switchToMode ();
            try {
                Thread.sleep ( 3000 );
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
            coursePageHandle.clickGotoCart ();
        }catch (Exception e){

        }
        aftercourseNum = coursePageHandle.getShopCartNum ();
        try {
            afterNum = Integer.valueOf ( aftercourseNum );
            System.out.println (afterNum);
        }catch (Exception e){
            afterNum=0;
        }

        try {
            Thread.sleep ( 3000 );
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
        if (afterNum ==beforeNum+1){
            System.out.println ("添加购物车成功");
            coursePageHandle.clickShopCart ();
        }else if (afterNum>0){
            coursePageHandle.clickShopCart ();
        }
    }
    /**
     * 点击立即购买
     */
    public void buyNow(){
        coursePageHandle.clickBuyNow ();
    }


}

    
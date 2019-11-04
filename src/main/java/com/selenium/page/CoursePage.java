package com.selenium.page;

import com.selenium.base.DriverBase;
import com.selenium.util.GetByLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @program: mooc_selenium
 * @description:
 * @author: wanglx
 * @create: 2019-10-25 09:37
 **/

public class CoursePage extends BasePage {
    public CoursePage(DriverBase driver) {
        super ( driver );
    }

    /**
     * 获取立即购买按钮element
     */
    public WebElement getBuytriggerElement() {
        return element ( GetByLocator.getByLocator ( "buyNow" ) );
    }

    /**
     * 获去添加购物车element
     */
    public WebElement getBuyCartElement() {
        return element ( GetByLocator.getByLocator ("addCart") );
    }

    /**
     * 获取右上角购物车element
     */
    public WebElement getShopCartElement(){
        return element ( GetByLocator.getByLocator ( "shopCart" ) );
    }
    /**
     * 获取购物车商品数量element
     */
    public WebElement getShopCartNumElement(){
        return element ( GetByLocator.getByLocator ( "cartNum" ) );
    }
    /**
     * 获取课程详情页左上角课程名称element
     * 需要用到层级定位
     */
    public WebElement getCourseNameElement(){
        return nodeElement ( GetByLocator.getByLocator ( "courseInfo" ),GetByLocator.getByLocator ( "courseInfoText" ) );
    }

    /**
     * 获取"商品已经在购物车内"弹窗中的继续逛
     */

    public WebElement getreadybuyCloseElement(){
        return nodeElement ( GetByLocator.getByLocator ( "readybuySure" ),GetByLocator.getByLocator ( "readybuyClose" ) );
    }
    /**
     * 获取"商品已经在购物车内"弹窗中的进入购物车element
     */
    public WebElement getGotoCartElement(){
        System.out.println (nodeElement (  GetByLocator.getByLocator ( "readybuySure" ),GetByLocator.getByLocator ( "gotoCart" ) ));
        return nodeElement (  GetByLocator.getByLocator ( "readybuySure" ),GetByLocator.getByLocator ( "gotoCart" ) );

    }
    /**
     * 获取去结算element
     */
    public WebElement getGoPayElement() {
        return element ( GetByLocator.getByLocator ( "gotoconfrim" ) );
    }
}
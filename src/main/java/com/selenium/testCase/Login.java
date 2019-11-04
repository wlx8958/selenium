package com.selenium.testCase;

import com.selenium.base.DriverBase;
import com.selenium.business.CoursePagePro;
import com.selenium.business.LoginPro;
import com.selenium.business.OrderPayPro;
import com.selenium.business.SureOrderPagePro;
import com.selenium.util.GetByLocator;
import com.selenium.util.SendEmail;
import org.apache.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @program: mooc_selenium
 * @description:登录
 * @author: wanglx
 * @create: 2019-10-24 01:48
 **/

public class Login extends CaseBase {
    DriverBase driver;
    LoginPro loginPro;
    CoursePagePro coursePagePro;
    SureOrderPagePro sureOrderPagePro;
    OrderPayPro orderPayPro;
    //引入log4j
    static Logger logger = Logger.getLogger ( Login.class );
    @BeforeClass
    public void LoginTest(){
        this.driver=InitDriver ( "chrome" );
        loginPro = new LoginPro ( driver );
        coursePagePro = new CoursePagePro ( driver );
        sureOrderPagePro = new SureOrderPagePro ( driver );
        orderPayPro = new OrderPayPro ( driver );
    }
    //获取主页面
    @Test
    public void getLoginHome(){
        driver.get ( "https://www.imooc.com" );
        driver.max ();

        //Thread.sleep ( 5000 );

        //driver.findElement ( By.className ( "redrain-redPacketsIMG" ) ).findElement ( By.className ( "redrain-closeBtn" ) ).click ();
        driver.findElement ( By.id ("js-signin-btn") ).click ();
        try {
            Thread.sleep ( 5000 );
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
    }
    @Test(dependsOnMethods = {"getLoginHome"})
    @Parameters({"uname","pwd"})
    public void testLogin(String uname,String pwd){
        logger.debug ( "这是通过log4j打印的日志" );
        loginPro.login ( uname,pwd );
        try {
            Thread.sleep ( 3000 );
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
        driver.get ( "https://coding.imooc.com/class/310.html" );
    }

    /**
     *
     * 添加购物车
     */

    public void TestAddCart(){

        coursePagePro.addCart ();
    }


    /**
     *
     *立即购买
     */
    @Test(dependsOnMethods = {"testLogin"})
    public void TestBuyNow(){
        coursePagePro.buyNow();
    }
    /**
     * 提交订单
     */
    @Test(dependsOnMethods = {"TestBuyNow"})
    public void TestSureOrder(){
        sureOrderPagePro.sureOrder ();
    }

    /**
     * 跳转支付页面
     */
    @Test(dependsOnMethods = {"TestSureOrder"})
    public void TestGoPay(){
        orderPayPro.orderPayPro ();
        SendEmail.sendToEmail ( "测试完成，请查看邮件" );
    }

    @AfterClass
    public void close(){
        driver.close();
    }
    /**
     * 1）获取element
     */
    public WebElement getElement(By by){
        return driver.findElement ( by );
    }
    /**
     * 2)通过父节点，获取子element
     */
    public WebElement getElement(WebElement element,By by){
        return element.findElement ( by );
    }
    /**
     * 3）获取课程信息
     */

    public String getCourseText(WebElement element){
        return element.getText ();
    }

    /**
     * 4)立即购买，返回课程信息
     */
    public String buyCourseNow(){
        WebElement element = this.getElement ( GetByLocator.getByLocator ( "courseInfo" ) );
        WebElement elementNode = this.getElement ( element, GetByLocator.getByLocator ( "courseInfoText" ) );
        String courseText = this.getCourseText ( elementNode );

        driver.click(this.getElement ( GetByLocator.getByLocator ( "buyNow" )) );
        return courseText;
    }

    /**
     * 5)点击确定订单
     */

    public void sureOrder(){
        driver.click ( this.getElement ( GetByLocator.getByLocator ( "suresOrder" ) ) );
    }

    /**
     * 6）获取订单号text
     */
    public String getOrder(){
        String orderText = this.getCourseText ( this.getElement ( GetByLocator.getByLocator ( "order" ) ) );
        return orderText;
    }

    /**
     * 7）获取支付中心商品信息
     */

    public String getOrderCourse(){
        WebElement element = this.getElement ( GetByLocator.getByLocator ( "orderCourse" ) );
        WebElement elementNode = this.getElement ( element, GetByLocator.getByLocator ( "orderCourseNode" ) );
        return this.getCourseText ( elementNode );
    }



    /**
     * 8)下单流程
     */
    public void downOrder(){
        driver.get ( "https://coding.imooc.com/class/310.html" );
        String currentText = this.buyCourseNow ();
        System.out.println ("当前课程信息为："+currentText);
        this.sureOrder ();
        try {
            Thread.sleep ( 3000 );
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
        this.getOrder ();
        String orderCourse = this.getOrderCourse ();
        System.out.println ("当前订单页面课程信息"+orderCourse);
        if (currentText.equals(orderCourse )){
            System.out.println ("下单成功");
        }

    }


    /**
     * 获取课程信息

        public String getCourseText(WebElement element){
            return element.getText ();
        }
     */
    /**
     * 下单流程
     */
    public void byCourse(){

        driver.get ( "https://coding.imooc.com/class/136.html" );
        String courseDetil = driver.findElement ( By.className ( "path" ) ).findElement ( By.tagName ( "span" ) ).getText ();
        driver.findElement ( By.id ( "buy-trigger" ) ).click ();
        driver.findElement ( By.linkText ( "提交订单" ) ).click ();
        try {
            Thread.sleep ( 3000 );
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
        String orderText = driver.findElement ( By.className ( "order" ) ).getText ();
        if (orderText!=null){
            try {
                Thread.sleep ( 3000 );
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
            String orderString = driver.findElement ( By.className ( "item" ) ).findElement ( By.className ( "left" ) ).findElement ( By.tagName ( "dt" ) ).getText ();
            Assert.assertEquals ( courseDetil,orderString,"购买商品信息不一致" );
        }

    }
}

    
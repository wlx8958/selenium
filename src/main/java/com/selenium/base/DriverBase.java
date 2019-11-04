package com.selenium.base;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

/**
 * @program: selenium
 * @description: 基类、获取到driver
 * @author: wanglx
 * @create: 2019-10-23 01:09
 **/

public class DriverBase {
    public WebDriver driver;

    /**
     * 封装浏览器
     * @param browser
     */
    public DriverBase(String browser){
        SelectDriver selectDriver = new SelectDriver ();
        this.driver = selectDriver.driverName ( browser );
    }

    /**
     * 窗口最大化
     */
    public void max(){
        //最大化窗口
        driver.manage ().window ().maximize ();
    }

    /**
     * 关闭浏览器
     */
    public void stop(){
        System.out.println ("stop webdriver");
        driver.close ();
    }

    /**
     * 封装Element方法
     */
    public WebElement findElement(By by){
        WebElement element = driver.findElement ( by );
        return element;
    }

    /**
     * get封装
     * @param url
     */
    public void get(String url) {
        driver.get ( url );
    }
    

    /**
     * 实现返回
     */
    public void back(){
        driver.navigate ().back ();
    }

    /**
     * 点击
     * @param element
     */
    public void click(WebElement element){
        element.click();
    }
    /**
     * 切换windows窗口
     */
    public void switchWindows(String name){
        driver.switchTo ().window ( name );
    }
    /**
     * 切换alert窗口
     */
    public void switchAlert(){
        driver.switchTo ().alert ();
    }
    /**
     * 模态框切换
     */
    public void switchToMode(){
        driver.switchTo ().activeElement ();
    }

    /**
     * 关闭窗口
     */
    public void close() {
        driver.close ();
    }
    /**
     * actionMoveElement
     * */
    public void action(WebElement element){
        Actions action =new Actions(driver);
        action.moveToElement(element).perform();
    }

    /**
     * 删除所有cookie
     */
    public void deleteCookie(){
        driver.manage ().deleteAllCookies (  );
    }
    /**
     * 设置cookie
     */
    public void setCookie(Cookie cookie) {
        driver.manage ().addCookie ( cookie );
    }

    /**
     * 获取cookie
     * @return
     */
    public Set<Cookie> getCookie() {
        Set<Cookie> cookies = driver.manage ().getCookies ();
        return cookies;
    }
}

    
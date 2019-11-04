package com.selenium.page;

import com.selenium.base.DriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


/**
 * @program: mooc_selenium
 * @description: 基于页面的操作元素操作封装
 * @author: wanglx
 * @create: 2019-10-24 00:57
 **/

public class BasePage {
    //调用封装的浏览器

    public DriverBase driver;

    public BasePage(DriverBase driver) {
        this.driver = driver;
    }

    /**
     * 封装定位element
     * @param by
     * @return
     */
    public WebElement element(By by){
        WebElement element = driver.findElement ( by );
        return element;

    }

    /**
     * 层级定位，通过父节点定位到子节点
     * 需要传入父节点和子节点的by
     */
    public WebElement nodeElement(By by,By nodeBy){
        WebElement element = this.element ( by );
        return element.findElement ( nodeBy );
    }
    /**
     * 封装点击
     * @param element
     */
    public void click(WebElement element){
       if (element!=null){
           element.click ();

       }else {
           System.out.println ("元素未定位到，无法进行点击");
       }
    }

    /**
     * 封装输入
     * @param element 传入定位
     * @param value 传入输入的值
     */
    public void sendKeys(WebElement element,String value){
        if (element!=null){
            element.sendKeys ( value );
        }else {
            System.out.println (element+"没有定位到"+value+"无法输入");
        }
    }

    /**
     * 封装元素是否存在
     * @param element
     * @return
     */
    public Boolean assertElementIs(WebElement element){
        return element.isDisplayed ();
    }

    /**
     * 获取文本信息
     */
    public String getText(WebElement element){
        return element.getText ();
    }

    /**
     * action事件
     * */
    public void action(WebElement element){
        driver.action(element);
    }


}

    
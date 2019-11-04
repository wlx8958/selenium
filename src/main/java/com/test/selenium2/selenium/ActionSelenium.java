package com.test.selenium2.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @program: selenium
 * @description:
 * @author: wanglx
 * @create: 2019-10-18 15:42
 **/

public class ActionSelenium {
    public WebDriver driver;
    public String windowHandle;
    //创建初始化方法
    public void InitDriver(){
        //配置环境变量
        //System.setProperty ( "webdriver.firefox.driver","/usr/local/bin/geckodriver" );
        System.setProperty( "webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        //实例化driver
        //driver = new FirefoxDriver (  );
        driver =new ChromeDriver (  );
        driver.get ( "https://www.imooc.com" );
        driver.manage ().window ().maximize ();
    }

    /**
     * 文本框
     */
    public void inputBox(){
        driver.get ( "https://www.imooc.com/user/newlogin" );
        driver.findElement ( By.name ("email") ).sendKeys ( "862383060@qq.com" );
        try {
            Thread.sleep ( 4000 );
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
        driver.findElement ( By.name ( "email" ) ).clear ();
        String s = driver.findElement ( By.name ( "email" ) ).getAttribute ( "placeholder" );
        System.out.println (s);
        driver.findElement ( By.name ("email") ).sendKeys ( "862383060@qq.com" );
        driver.findElement ( By.name ("password") ).sendKeys ( "mkqwe123" );
        driver.findElement ( By.id ( "auto-signin" ) ).click ();

       /* driver.findElement ( By.className ( "moco-btn" ) ).click ();

        driver.manage ().window ().maximize ();
        try {
            Thread.sleep ( 3000 );
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }*/

    }


    /**
     * 单选框
     */
    public void radioBox(){
        driver.get ( "https://www.imooc.com/user/setprofile" );

        driver.findElement ( By.className ( "pull-right" ) ).click ();
        //根据xpath定位单选按钮
        //driver.findElement ( By.xpath ( "//*[@id=\"profile\"]/div[4]/div/label[2]/input" ) ).click ();
        //获取所有的单选按钮
        List<WebElement> elements = driver.findElements ( By.xpath ( "//*[@id=\"profile\"]/div[4]/div/label//input" ) );
        System.out.println (elements.size ());
        try {
            Thread.sleep ( 4000 );
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }

        for (WebElement radio:elements) {
            boolean flag = radio.isSelected ();
            try {
                Thread.sleep ( 3000 );
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
            if (flag == false){
                radio.click ();
                break;
            }else {
                System.out.println ("选中了");
            }
        }
    }

    /**
     * 复选框操作
     */
    public void checkBox(){
        WebElement element = driver.findElement ( By.id ( "auto-signin" ) );
        System.out.println ("复选框是否选中"+element.isSelected ());
        boolean flag = element.isEnabled ();
        if (flag == false){
            System.out.println ("没有选中");
        }else {
            //element.clear ();
            System.out.println ("选中");
        }
        try {
            Thread.sleep ( 3000 );
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
        element.click ();
    }
    /**
     * 按钮
     */
    public void botton(){
        WebElement element = driver.findElement ( By.className ( "moco-btn" ) );
        System.out.println (element.isEnabled ());
        System.out.println (element.getAttribute ( "value" ));
        element.click ();
        try {
            Thread.sleep ( 3000 );
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
    }

    /**
     * 表单
     */
    public void webFrom(){
        driver.get ( "url" );
        driver.findElement ( By.id ( "signup-form" ) ).submit ();
    }

    /**
     * 上传文件
     */

    public void upimages(){
        driver.get ( "https://www.imooc.com/user/setbindsns" );

        /**
         * 通过js修改元素属性信息，变成可操作状态
         */

        String jsString = "document.getElementsByClassName('update-avator')[0].style.bottom='0';";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript ( jsString );
        try {
            Thread.sleep ( 3000 );
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
        driver.findElement ( By.className ( "js-avator-link" ) ).click ();
        driver.findElement ( By.id ( "upload" ) ).sendKeys ( "/Users/wanglx/Desktop/汽车图片/1.png" );
    }

    /**
     * 下拉框
     *  1、下拉框定位
     *     Select list = new Select(locator);
     *  2、下拉框操作
     *      选择对应的元素：text、value、index
     *      不选择对应的元素：deselectAll、deselectByValue、deselectByVisibleText
     *      获取选择项的值：getAllSelectedOptions()、getFirstSelectedOption().getText
     */

    public void downSelectBox(){
        driver.get ( "https://www.imooc.com/user/setprofile" );
        driver.findElement ( By.className ( "pull-right" ) ).click ();
        try {
            Thread.sleep ( 2000 );
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
        //选择form表单
        WebElement formElement = driver.findElement ( By.id ( "profile" ) );

        WebElement job = formElement.findElement ( By.id ( "job" ) );

        Select downList = new Select ( job );
        /**
         * 1、使用id查找
         * downList.selectByIndex ( 3 );
         * 2、使用value查找
         * downList.selectByValue ( "1" );
         * 3、使用value值
         * downList.selectByVisibleText ( "学生" );
         */
        downList.selectByIndex ( 3 );

        System.out.println ("是否为多选下拉列表："+downList.isMultiple ());;
        //downList.deselectByIndex ( 3 );
        List<WebElement> allSelectedOptions = downList.getAllSelectedOptions ();
        for (WebElement option:allSelectedOptions) {
            System.out.println (option.getText ());
        }
        System.out.println (downList.getFirstSelectedOption ().getText ());
    }

    /**
     * 鼠标事件
     */
    public void moseAction(){
    /*
        WebElement login = driver.findElement ( By.id ( "js-signin-btn" ) );

        Actions actions = new Actions ( driver );
        actions.click (login).perform ();

        actions.doubleClick (login).perform ();

        try {
            Thread.sleep ( 3000 );
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
        actions.contextClick (login).perform ();
    */
        driver.get ( "https://www.imooc.com/" );

        //悬停
        WebElement login = driver.findElement ( By.className ( "menuContent" ) );
        List<WebElement> item = login.findElements ( By.className ( "item" ) );
        Actions actions = new Actions ( driver );
        actions.moveToElement ( item.get ( 0 ) ).perform ();
        driver.getWindowHandle ();
        driver.findElement ( By.linkText ( "微服务" ) ).click ();


    }

    /**
     *
     * iframe切换
     */
    public void iframe(){

        WebElement iframeElement = driver.findElement ( By.id ( "ueditor_0" ) );
        driver.switchTo ().frame ( iframeElement );
        driver.findElement ( By.tagName ( "body" ) ).sendKeys ( "this is test" );

    }

    /**
     * 窗口
     */
    public void windowsHandle(){
        Set<String> windowHandles = driver.getWindowHandles ();
        for (String s:windowHandles){
            if (s.equals ( windowHandle )){
                continue;
            }
            //System.out.println (s);
            driver.switchTo ().window ( s );

        }
        driver.findElement ( By.linkText ( "升级" ) ).click ();
    }

    /**
     * 等待
     */

    public void waitforElement(){
        //隐式等待
        driver.manage ().timeouts ().implicitlyWait ( 20,TimeUnit.SECONDS );
        //显示等待
        //WebDriverWait webDriverWait = new WebDriverWait ( driver, 10 );
        //webDriverWait.until ( ExpectedConditions.presenceOfElementLocated ( By.id ( "test" ) ) );
    }

    public static void main(String[] args) {
        //实例化类
        ActionSelenium actionSelenium = new ActionSelenium ();
        actionSelenium.InitDriver ();

        //actionSelenium.checkBox ();
        actionSelenium.waitforElement ();
        actionSelenium.inputBox ();
        //actionSelenium.webFrom ();

        actionSelenium.botton ();
       // actionSelenium.downSelectBox ();
        //actionSelenium.upimages ();
       // actionSelenium.radioBox ();
       // actionSelenium.iframe ();
        actionSelenium.moseAction ();
        actionSelenium.windowsHandle ();

    }
}

    
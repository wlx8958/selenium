package com.selenium.testCase;

import com.selenium.base.DriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: mooc_selenium
 * @description:
 * @author: wanglx
 * @create: 2019-10-24 18:44
 **/

public class TestCourseList extends CaseBase {
    DriverBase driver;
    public TestCourseList(){
        this.driver =InitDriver ( "chrome" );
    }
    @Test
    public void CourseList(){
        driver.get ( "https://coding.imooc.com/" );
        driver.max ();
        List<String> listString = this.listElement ();
        try {
            Thread.sleep ( 3000 );
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
        for (int i=0;i<listString.size();i++){

            driver.findElement(By.xpath ("//*[contains(text(),'"+listString.get(i)+"')]")).click();
            driver.back();
        }
    }
    /**
     * 获取所有课程list
     */
    public List<String> listElement(){
        List<String> listString = new ArrayList<> (  );
        WebElement element = driver.findElement ( By.className ( "shizhan-course-list" ) );
        List<WebElement> listElement = element.findElements ( By.className ( "shizhan-course-box" ) );
        for (WebElement webElement:listElement){
            listString.add ( webElement.findElement ( By.className ( "shizan-desc" ) ).getText () );

        }
        return listString;
    }
}

    
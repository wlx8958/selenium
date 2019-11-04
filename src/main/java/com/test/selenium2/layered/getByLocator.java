package com.test.selenium2.layered;

import org.openqa.selenium.By;

/**
 * @program: selenium
 * @description:
 * @author: wanglx
 * @create: 2019-10-23 12:52
 **/

public class getByLocator {
    /**
     * 封装By by
     * @return
     */
    public static By getByLocator(String key){
        ProUtil proUtil = new ProUtil ( "src/main/resources/login.properties" );
        String locator = proUtil.getPro ( key );
        String locatorType = locator.split ( ">" )[0];
        String locatorValue = locator.split ( ">" )[1];
        if (locatorType.equals ( "id" )){
            return By.id ( locatorValue );
        }else if (locatorType.equals ( "name" )){
            return By.name ( locatorValue );
        }else if (locatorType.equals ( "className" )){
            return By.className ( locatorValue );
        }else {
            return By.xpath ( locatorValue );
        }
    }

}

    
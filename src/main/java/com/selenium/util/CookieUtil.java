package com.selenium.util;

import com.selenium.base.DriverBase;
import org.openqa.selenium.Cookie;

import java.util.Set;

/**
 * @program: mooc_selenium
 * @description:
 * @author: wanglx
 * @create: 2019-11-04 12:13
 **/

public class CookieUtil {
    DriverBase driver;
    ProUtil proUtil;

    public CookieUtil(DriverBase driver) {
        this.driver = driver;
        proUtil = new ProUtil ( "src/main/resources/cookie.properties" );
    }

    /**
     * 添加cookie值
     */
    public void setCookie(){
        String cookieid = proUtil.getPro ( "apsid" );
        Cookie cookie = new Cookie ("apsid",cookieid,"imooc.com","/",null);
        driver.setCookie(cookie);
    }
    /**
     * 登录之后获取cookie
     */
    public void writeCookie(){
        Set<Cookie> cookies = driver.getCookie ();
        for (Cookie cookie:cookies){
            if (cookie.getName ().equals ( "apsid" )){
                proUtil.writePro(cookie.getName (),cookie.getValue ());
            }
        }
    }
}

    
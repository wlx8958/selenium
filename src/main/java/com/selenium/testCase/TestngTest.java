package com.selenium.testCase;

import org.testng.annotations.*;

/**
 * @program: mooc_selenium
 * @description:
 * @author: wanglx
 * @create: 2019-10-31 13:42
 **/

public class TestngTest {
    @BeforeClass
    public void test01(){
        System.out.println ("BeforeClass---------test01");
    }
    @AfterMethod
    public void test02(){
        System.out.println ("AfterMethod---------test02");
    }
    @BeforeMethod
    public void test06(){
        System.out.println ("BeforeMethod---------test06");
    }
    @Test
    public void test03(){
        System.out.println ("Test---------test03");
    }
    @Test
    public void test05(){
        System.out.println ("Test---------test05");
    }
    @AfterClass
    public void test04(){
        System.out.println ("AfterClass---------test04");
    }
}

    
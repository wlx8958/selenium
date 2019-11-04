package com.test.selenium2.testng;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

/**
 * @program: selenium
 * @description: 继承
 * @author: wanglx
 * @create: 2019-10-23 00:18
 **/

public class TestngListenerScreenShot extends TestListenerAdapter {
    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        super.onTestSuccess ( iTestResult );
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        super.onTestFailure ( iTestResult );
        takeScreenShot ( iTestResult );
    }
    private void takeScreenShot(ITestResult iTestResult){
        BaseDriver instance = (BaseDriver)iTestResult.getInstance ();
        instance.takeScreenShot (  );
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        super.onTestSkipped ( iTestResult );
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        super.onTestStart ( iTestResult );
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        super.onStart ( iTestContext );
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        super.onFinish ( iTestContext );
    }
}

    
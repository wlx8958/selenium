package com.selenium.testCase;

import com.selenium.base.DriverBase;

/**
 * @program: mooc_selenium
 * @description:生成driver
 * @author: wanglx
 * @create: 2019-10-24 01:49
 **/

public class CaseBase {
    public DriverBase InitDriver(String borwser){
        return new DriverBase ( borwser );
    }
}

    
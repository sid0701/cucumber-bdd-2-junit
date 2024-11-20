package com.sidgupta.util;

import com.sidgupta.tests.BaseTest;

import java.net.MalformedURLException;

public class TestContextSetup {

    public BaseTest baseTest;
    public PageObjectManager pageObjectManager;
    public String landingPageProductName;
    public SwitchWindowService switchWindowService;

    public TestContextSetup() throws MalformedURLException {
        baseTest = new BaseTest();
        pageObjectManager = new PageObjectManager(baseTest.getDriver());
        switchWindowService = new SwitchWindowService(baseTest.getDriver());
    }
}

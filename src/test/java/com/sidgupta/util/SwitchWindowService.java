package com.sidgupta.util;

import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class SwitchWindowService {

    private WebDriver driver;

    public SwitchWindowService(WebDriver driver){
        this.driver = driver;
    }

    public void switchToChildWindow(){
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();
        String parentWindow = iterator.next();
        String childWindow = iterator.next();
        driver.switchTo().window(childWindow);
    }


}

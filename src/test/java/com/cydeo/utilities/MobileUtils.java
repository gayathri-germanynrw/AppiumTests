package com.cydeo.utilities;

import io.appium.java_client.AppiumBy;

public class MobileUtils {


    public static void wait(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void scrollToEnd(String platformType){
        Driver.getDriver(platformType).findElement( new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollToEnd(10);"));
    }

    public static void scrollIntoView(String platformType, String text){
        Driver.getDriver(platformType).findElement( new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"));
    }


}
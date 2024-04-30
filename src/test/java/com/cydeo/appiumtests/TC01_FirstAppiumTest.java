package com.cydeo.appiumtests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TC01_FirstAppiumTest {
    @Test
    public void FirstTest() throws MalformedURLException {
        /**
         * It will create Mobile Test Driver , Then it will download calculator from Cydeo AWS account
         * It will bring mobile device date and time for us , then close the app.
         */

        AndroidDriver driver; // driver object that will open and interact with app.

        URL url;
        UiAutomator2Options options=new UiAutomator2Options();
        options.setApp("https://cybertek-appium.s3.amazonaws.com/calculator.apk");
        url=new URL("http://192.168.178.72:4723/");

        driver=new AndroidDriver(url,options);
        System.out.println(driver.getDeviceTime());
       // driver.quit();

    }
}

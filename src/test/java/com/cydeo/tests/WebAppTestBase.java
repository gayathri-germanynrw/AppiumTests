package com.cydeo.tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileBrowserType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class WebAppTestBase {
    protected AndroidDriver driver;
    @BeforeEach
    public void setUpWebTest(){
        UiAutomator2Options options=new UiAutomator2Options();
        options.withBrowserName(MobileBrowserType.CHROME);
        URL url;
        try {
            url=new URL("http://192.168.178.72:4723/");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver=new AndroidDriver(url,options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}

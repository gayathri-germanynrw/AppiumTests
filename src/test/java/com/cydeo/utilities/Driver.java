package com.cydeo.utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URL;


public class Driver {
    private static AppiumDriver driver;
    private static URL url;
    private static UiAutomator2Options caps = new UiAutomator2Options();

    private Driver() {

    }

    public static AppiumDriver getDriver() {
        if (driver == null) {
            /* We will read our browserType from configuration.properties file
             * This way , we can control which  browser is opened from outside our code.
             * */
            String platform = ConfigurationReader.getProperty("calculatorPlatform");
            switch (platform) {
                case "android-calculator":
                    caps.setApp("https://cybertek-appium.s3.amazonaws.com/calculator.apk");
                    try {
                        url = new URL("http://192.168.178.72:4723/");
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                    driver = new AndroidDriver(url, caps);
                    break;
          }

        }
        return driver;

    }

    public static void closeDriver(){
        if(driver!=null){
            /*
            This line terminate the currently existing driver completely.
            It will not exist going forward.
             */
            driver.quit();
            /*
               Instead of non-existence, we have to assign null.
               we assign the value back to "null" so that my "Singleton"
               can create a newer one if needed.
             */
            driver=null;
        }
    }
}


package com.cydeo.utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileBrowserType;
import org.openqa.selenium.MutableCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Objects;

public class Driver {

    private static AppiumDriver driver;

    private static URL url;

    private static UiAutomator2Options caps = new UiAutomator2Options();


    private Driver(){

    }

    public static AppiumDriver getDriver(String platformType){
        String platform = ConfigurationReader.getProperty(platformType);
        if(Objects.isNull(driver)) {
            String testDir = System.getProperty("user.dir");

            switch (platform) {
                case "android-calculator":
                    caps.setApp("https://cybertek-appium.s3.amazonaws.com/calculator.apk");
                    try {
                        url = new URL("http://localhost:4723/");
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                    driver = new AndroidDriver(url, caps);
                    break;
                case "local-android-swaglabs":

                    caps.setApp(testDir + "/swaglabsApp.apk");
                    caps.setAppPackage("com.swaglabsmobileapp");
                    caps.setAppActivity("com.swaglabsmobileapp.MainActivity");
                    caps.setUiautomator2ServerInstallTimeout(Duration.ofSeconds(60));
                    try {
                        url = new URL("http://localhost:4723/");
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                    driver = new AndroidDriver(url, caps);
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                    break;
                case "webapp-cydeoCloud":
                    caps.withBrowserName(MobileBrowserType.CHROME);
                    try {
                        url = new URL("http://localhost:4723/");
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                    driver = new AndroidDriver(url, caps);
                    break;
                case "remote-android-swaglabs":
                    MutableCapabilities capsRA = new MutableCapabilities();
                    capsRA.setCapability("platformName", "Android");
                    capsRA.setCapability("appium:app", "https://github.com/saucelabs/sample-app-mobile/releases/download/2.7.1/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");  // The filename of the mobile app
                    capsRA.setCapability("appium:deviceName", "Samsung.*");
                    capsRA.setCapability("appium:automationName", "UiAutomator2");
                    MutableCapabilities sauceOptions = new MutableCapabilities();
                    sauceOptions.setCapability("username", "oauth-gayathrikasi-61c94");
                    sauceOptions.setCapability("accessKey", "eebebd2e-8a09-4895-b046-9987a23d7346");
                    sauceOptions.setCapability("build", "Cydeo01");
                    sauceOptions.setCapability("name", "LoginTestforSwagLabs");
                    sauceOptions.setCapability("deviceOrientation", "PORTRAIT");
                    capsRA.setCapability("sauce:options", sauceOptions);

                    try {
                        url = new URL("https://oauth-gayathrikasi-61c94:eebebd2e-8a09-4895-b046-9987a23d7346@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                    driver = new AndroidDriver(url, capsRA);
                    break;






                case "local-android-etsy":
                    caps.setApp(testDir+"/etsy.apk");
                    caps.setAppPackage("com.etsy.android");
                    caps.setAppActivity("com.etsy.android.ui.user.auth.SignInActivity");
                    try {
                        url = new URL("http://localhost:4723/");
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                    driver = new AndroidDriver(url,caps);
                    break;

            }
        }
        return driver;
    }

    public static void closeDriver(){
        if(Objects.nonNull(driver)){
            driver.quit();
            driver = null;
        }
    }



}



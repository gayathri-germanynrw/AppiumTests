package com.cydeo.tests;

import com.cydeo.pages.SwagLabAppPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.cydeo.utilities.MobileUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC05_SwagLabsNativeAppTests {
    String username= ConfigurationReader.getProperty("userName");
    String password=ConfigurationReader.getProperty("password");

    @Test
    public void SignInTest(){
    AppiumDriver driver= Driver.getDriver("local-swagPlatform");
    System.out.println(((AndroidDriver)driver).getDeviceTime());
    driver.findElement(new AppiumBy.ByAccessibilityId("test-Username")).sendKeys(username);

    driver.findElement(new AppiumBy.ByAccessibilityId("test-Password")).sendKeys(password);
    driver.findElement(new AppiumBy.ByAccessibilityId("test-LOGIN")).click();
        MobileUtils.wait(3);


        WebElement aSampleUnit = driver.findElement(By.xpath("(//android.widget.TextView[@content-desc=\"test-Item title\"])[1]"));
        MobileUtils.wait(3);
        Assertions.assertTrue(aSampleUnit.getText().contains("Sauce"));
        MobileUtils.wait(3);
        System.out.println(((AndroidDriver)driver).getDeviceTime());

        Driver.closeDriver();

  }


    @Test
    public void signInTestWithPOM(){

        SwagLabAppPage page = new SwagLabAppPage("local-swagPlatform");

        page.userNameBox.sendKeys(username);
        page.passwordBox.sendKeys(password);
        page.LoginButton.click();

        MobileUtils.wait(3);
        System.out.println("page.sampleItem.getText()---"+page.sampleItem.getText());

        Assertions.assertTrue(page.sampleItem.getText().contains("Sauce"));
        Driver.closeDriver();

    }

}


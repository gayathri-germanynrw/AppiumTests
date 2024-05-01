package com.cydeo.tests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;

public class TC02_CalculatorOperationsTest {
    /**
     *
     * We will locate elements of calculator app with Appium Inspector tool
     * We will create Android driver in before Method of Junit, Then Quit the Driver at after Method
     * Assertions from Junit to verify the result
     */
    AndroidDriver driver; // driver object that will open and interact with app.
    @BeforeEach
    public void TestSetUp(){
        UiAutomator2Options options=new UiAutomator2Options();
        options.setApp("https://cybertek-appium.s3.amazonaws.com/calculator.apk");


        try {
            driver=new AndroidDriver(new URL("http://192.168.178.72:4723/"),options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void AddingTest(){
        // Locate Elements of Numbers , Lets add 10 and 5
        WebElement firstNum=driver.findElement(By.id("com.google.android.calculator:id/digit_4"));
        firstNum.click();

        WebElement plusButton=driver.findElement(new AppiumBy.ByAccessibilityId(("plus")));
        plusButton.click();

        WebElement secondNum=driver.findElement(By.id("com.google.android.calculator:id/digit_5"));
        secondNum.click();

        WebElement equalsButton=driver.findElement(new AppiumBy.ByAccessibilityId("equals"));
        equalsButton.click();

        WebElement result=driver.findElement(By.id("com.google.android.calculator:id/result_final"));
        String actualResult=result.getText();
        int expresult=9;

        Assertions.assertEquals(expresult,Integer.parseInt(actualResult));

    }
    @AfterEach
    public void Teardown(){
       driver.quit();
    }



}

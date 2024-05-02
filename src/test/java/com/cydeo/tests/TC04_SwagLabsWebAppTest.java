package com.cydeo.tests;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.MobileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class TC04_SwagLabsWebAppTest extends WebAppTestBase{
    //appium --allow-insecure chromedriver_autodownload  --> This comment which u need to type in
    // cmd and  allow you open chrome driver

    @Test
    public void LoginTest(){
        //Navigate to https://www.saucedemo.com/v1/
        driver.get("https://www.saucedemo.com/v1/");

        WebElement userNameBox=driver.findElement(By.id("user-name"));
        userNameBox.sendKeys(ConfigurationReader.getProperty("userName"));

        WebElement passwordBox=driver.findElement(By.id("password"));
        passwordBox.sendKeys(ConfigurationReader.getProperty("password")+ Keys.ENTER);
        MobileUtils.wait(3);

        List<WebElement> productList = driver.findElements(By.cssSelector(".inventory_item_name"));

        for(WebElement eachProduct:productList){
            System.out.println("eachProduct.getText() ="+eachProduct.getText());
            if(eachProduct.getText().contains("Test")){
               // Assertions.assertTrue(eachProduct.getText().toLowerCase().contains("t-Shirt"));
                Assertions.assertTrue(eachProduct.getText().toLowerCase().contains("t-shirt"));
            }
        }
        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[6]"))).perform();
        MobileUtils.wait(3);
    }

}

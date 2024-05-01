package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;


public class CalculatorPage {
    public CalculatorPage(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()),this);
    }
    @AndroidFindBy(accessibility = "multiply")
    public WebElement multiplyButton;

    @AndroidFindBy(accessibility = "plus")
    public WebElement plusButton;

    @AndroidFindBy(accessibility = "equals")
    public WebElement equalsButton;

    @AndroidFindBy(id="com.google.android.calculator:id/result_final")
    public WebElement result;

    // create a method that will click on single digit
    public void clickSingleDigit(int digit){
        String idLocator="com.google.android.calculator:id/digit_"+digit;
        WebElement number_Element=Driver.getDriver().findElement(By.id(idLocator));
        number_Element.click();
    }




}

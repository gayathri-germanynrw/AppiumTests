package com.cydeo.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class SwagLapProductPage extends SwagLabAppPage{
    public SwagLapProductPage(String platformEnv) {
        super(platformEnv);
    }

    @AndroidFindBy(xpath = "(//*[@content-desc=\"test-ADD TO CART\"])[1]/android.widget.TextView")
    public WebElement addProduct;

    @AndroidFindBy(accessibility = "test-REMOVE")
    public WebElement removeProduct;

    @AndroidFindBy(xpath = "//*[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.TextView")
    public WebElement cartValue;

    @AndroidFindBy(xpath = "//*[@text='Terms of Service | Privacy Policy']")
    public WebElement privacyPolicy;

}
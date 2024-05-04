package com.cydeo.step_definitions;

import com.cydeo.pages.SwagLabAppPage;
import com.cydeo.pages.SwagLapProductPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.cydeo.utilities.MobileUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class SwagLabsStepDefs {

    SwagLabAppPage page;
    String username = ConfigurationReader.getProperty("userName");
    String password = ConfigurationReader.getProperty("password");

    @When("User navigates to login page of swaglabs native application on {string}")
    public void user_navigates_to_login_page_of_swaglabs_native_application_on(String env) {
        page = new SwagLabAppPage(env+"-swagPlatform");
        MobileUtils.wait(5);
    }
    @When("User logins with valid username and password")
    public void user_logins_with_valid_username_and_password() {
        MobileUtils.wait(2);
        page.userNameBox.sendKeys(username);
        page.passwordBox.sendKeys(password);
        page.LoginButton.click();

        MobileUtils.wait(3);
    }
    @Then("Verifies user can see a sample product item on the homepage")
    public void verifies_user_can_see_a_sample_product_item_on_the_homepage() {
        Assertions.assertTrue(page.sampleItem.getText().contains("Sauce"));
    }

    SwagLapProductPage productPage;
    @And("User clicks on Add To Cart button {string}")
    public void userClicksOnAddToCartButton(String env) {
        productPage = new SwagLapProductPage(env+"-swagPlatform");
        String actualText = productPage.addProduct.getAttribute("text");
        System.out.println("actualText = " + actualText);
        Assertions.assertEquals("ADD TO CART",actualText);
        productPage.addProduct.click();
    }

    @Then("Verifies product is added to cart")
    public void verifiesProductIsAddedToCart() {
        // locate REMOVE element and verify it is visible' and check cart has 1 product
        Assertions.assertTrue(productPage.removeProduct.isDisplayed());
        Assertions.assertEquals("1",productPage.cartValue.getAttribute("text"));
    }

    @And("User scrolls down to {string} at {string}")
    public void userScrollsDownToAt(String text, String env) {
        productPage = new SwagLapProductPage(env+"-swagPlatform");
        String platformType = env + "-swagPlatform";
        MobileUtils.scrollIntoView(platformType,text);
        MobileUtils.wait(3);
    }

    @Then("User verifies that {string} visible")
    public void userVerifiesThatVisible(String text) {
        System.out.println(productPage.privacyPolicy.getAttribute("text"));
        Assertions.assertEquals(text,productPage.privacyPolicy.getAttribute("text"));
        Assertions.assertTrue(productPage.privacyPolicy.isDisplayed());
    }
}
package com.cydeo.tests;

import com.cydeo.pages.CalculatorPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TC03_CalculatorPOM_Test {
    CalculatorPage calculatorPage=new CalculatorPage();

    @Test
    public void multiplyTest(){
        // 5 * 8 equals to 40
        calculatorPage.clickSingleDigit(5);
        calculatorPage.multiplyButton.click();
        calculatorPage.clickSingleDigit(8);
        calculatorPage.equalsButton.click();
        String resultText=calculatorPage.result.getText();

        //verification

        Assertions.assertEquals(40,Integer.parseInt(resultText));
  }
    @Test
    public void divideTest(){
        // 20 / 5 = 4
        calculatorPage.clickSingleDigit(10);
        calculatorPage.clickSingleDigit(5);
        calculatorPage.divideButton.click();
        calculatorPage.clickSingleDigit(5);
        calculatorPage.equalsButton.click();
        String resultText = calculatorPage.result.getText();
        Assertions.assertEquals("4",resultText);
    }

}

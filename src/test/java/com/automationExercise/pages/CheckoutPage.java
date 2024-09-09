package com.automationExercise.pages;

import com.automationExercise.utilities.BrowserUtils;
import com.automationExercise.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckoutPage extends BasePage {

    @FindBy(xpath = "//ul[@id='address_delivery']/li")
    public List<WebElement> deliveryAddress;
    @FindBy(xpath = "//ul[@id='address_invoice']/li")
    public List<WebElement> billingAddress;
    @FindBy(xpath = "//td/p[@class='cart_total_price']")
    public List<WebElement> amountList;
    @FindBy(tagName = "textarea")
    public WebElement commentTextArea;

    public void verifyAddressDetails() {
        for (int i = 2; i < deliveryAddress.size(); i++) {
            Assert.assertEquals(deliveryAddress.get(i).getText(), billingAddress.get(i).getText());
        }
    }

    public void verifyTotalAmount(String totalAmount) {
        BrowserUtils.scrollToElement(amountList.get(amountList.size()-1));
        Assert.assertEquals(totalAmount, amountList.get(amountList.size()-1).getText());

    }
}

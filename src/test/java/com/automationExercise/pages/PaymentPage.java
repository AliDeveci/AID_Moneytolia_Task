package com.automationExercise.pages;

import com.automationExercise.utilities.BrowserUtils;
import com.automationExercise.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends BasePage {
    @FindBy(name = "name_on_card")
    public WebElement nameOnCard;
    @FindBy(name = "card_number")
    public WebElement cardNumber;
    @FindBy(name = "cvc")
    public WebElement cvc;
    @FindBy(name = "expiry_month")
    public WebElement expiryMonth;
    @FindBy(name = "expiry_year")
    public WebElement expiryYear;
    @FindBy(id = "submit")
    public WebElement payAndConfirmBtn;
    @FindBy(css = "#success_message>div")
    public WebElement successMsg;
    @FindBy(xpath = "//h2/../p")
    public WebElement successMsgDone;
    @FindBy(xpath = "//h2/b")
    public WebElement orderPlacedMsg;

    public void enterPaymentDetailsAndFinishPurchase(String name, String cardNum, String cvcNum, String expiryMon, String expiryY) {
        nameOnCard.sendKeys(name);
        cardNumber.sendKeys(cardNum);
        cvc.sendKeys(cvcNum);
        expiryMonth.sendKeys(expiryMon);
        expiryYear.sendKeys(expiryY);
        payAndConfirmBtn.click();
     }

    public void verifySuccessMsg(String message) {
        BrowserUtils.waitForVisibility(orderPlacedMsg,10);
        Driver.get().navigate().back();
        Assert.assertTrue(successMsg.getText().contains(message));
        Driver.get().navigate().forward();

    }

    public void verifySuccessMsgDone(String message) {
        Assert.assertTrue(successMsgDone.getText().contains(message));
    }

}

package com.automationExercise.pages;

import com.automationExercise.utilities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteAccountPage extends BasePage{
    @FindBy(xpath = "//h2/b")
    public WebElement deletedMsg;
    public void verifyAccountDeleted(String message){
        Assert.assertTrue(deletedMsg.getText().contains(message));
    }
}

package com.automationExercise.pages;

import com.automationExercise.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(),this);
    }

    public void verifyPage(String pageTitle){
        Assert.assertEquals("color: orange;",Driver.get().findElement(By.linkText(pageTitle)).getAttribute("style"));
    }
    public void clickPageLink(String pageText){
        Driver.get().findElement(By.linkText(pageText)).click();
    }

}

package com.automationExercise.pages;

import com.automationExercise.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(name = "name")
    public WebElement signUpName;
    @FindBy(css = "[data-qa='signup-email']")
    public WebElement signUpEmail;
    @FindBy(css = "[data-qa='signup-button']")
    public WebElement signUpBtn;

    @FindBy(css = "[data-qa='login-email']")
    public WebElement loginEmail;
    @FindBy(name = "password")
    public WebElement loginPassword;
    @FindBy(css = "[data-qa='login-button']")
    public WebElement loginBtn;

    public void signUp(String name, String email){
        signUpName.sendKeys(name);
        signUpEmail.sendKeys(email);
        signUpBtn.click();
    }
    public void login(String email, String password){
        loginEmail.sendKeys(email);
        loginPassword.sendKeys(password);
        loginBtn.click();
    }
    public void loginVerification(String username){
        Assert.assertTrue(Driver.get().findElement(By.xpath("(//li/a)[10]")).getText().contains(username));
    }
}

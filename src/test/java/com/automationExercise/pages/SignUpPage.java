package com.automationExercise.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage extends BasePage {

    @FindBy(id = "password")
    public WebElement passwordInput;
    @FindBy(id = "first_name")
    public WebElement firstnameInput;
    @FindBy(id = "last_name")
    public WebElement lastnameInput;
    @FindBy(id = "address1")
    public WebElement address1Input;
    @FindBy(id = "country")
    public WebElement selectCountry;
    @FindBy(id = "state")
    public WebElement stateInput;
    @FindBy(id = "city")
    public WebElement cityInput;
    @FindBy(id = "zipcode")
    public WebElement zipcodeInput;
    @FindBy(id = "mobile_number")
    public WebElement mobileNumberInput;
    @FindBy(css = "[data-qa='create-account']")
    public WebElement createAccountBtn;

    public void createAccount(String password, String firstname,
                              String lastname, String address1, String country,
                              String state, String city, String zipcode, String mobileNum) {
        passwordInput.sendKeys(password);
        firstnameInput.sendKeys(firstname);
        lastnameInput.sendKeys(lastname);
        address1Input.sendKeys(address1);
        selectCountryMtd(country);
        stateInput.sendKeys(state);
        cityInput.sendKeys(city);
        zipcodeInput.sendKeys(zipcode);
        mobileNumberInput.sendKeys(mobileNum);
        createAccountBtn.click();
    }

    public void selectCountryMtd(String country) {
        Select countrySelection = new Select(selectCountry);
        countrySelection.selectByVisibleText(country);
    }
}

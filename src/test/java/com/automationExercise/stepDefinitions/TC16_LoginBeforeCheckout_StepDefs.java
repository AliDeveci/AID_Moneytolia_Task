package com.automationExercise.stepDefinitions;

import com.automationExercise.pages.*;
import com.automationExercise.utilities.ConfigurationReader;
import com.automationExercise.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class TC16_LoginBeforeCheckout_StepDefs {
    LoginPage loginPage = new LoginPage();
    ProductsPage productsPage = new ProductsPage();
    CheckoutPage checkoutPage = new CheckoutPage();
    PaymentPage paymentPage = new PaymentPage();
    DeleteAccountPage deleteAccountPage = new DeleteAccountPage();
    SignUpPage signUpPage = new SignUpPage();

    @When("The user opens browser and navigates to web site")
    public void theUserOpensBrowserAndNavigatesToWebSite() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @Then("The user verifies that land on {string} page")
    public void theUserVerifiesThatLandOnPage(String pageType) {
        loginPage.verifyPage(pageType);
    }

    @When("The user clicks on {string} page text")
    public void theUserClicksOnPageText(String pageText) {
        loginPage.clickPageLink(pageText);
    }

    @And("The user enters name as {string} email as {string} and clicks Signup button")
    public void theUserEntersNameAsEmailAsAndClicksSignupButton(String name, String email) {
        loginPage.signUp(name, email);
    }

    @And("The user enters {string} {string} {string} {string} {string} {string} {string} {string} {string} as required data and clicks create account button for sign up process on signup page")
    public void theUserEntersAsRequiredDataAndClicksCreateAccountButtonForSignUpProcessOnSignupPage
            (String password, String firstname, String lastname, String address,
             String country, String state, String city, String zipcode, String mobileNumber) {
        signUpPage.createAccount(password, firstname, lastname, address, country, state, city, zipcode, mobileNumber);
    }

    @And("The user fills email and password input areas with {string} and {string} and clicks login button")
    public void theUserFillsEmailAndPasswordInputAreasWithAndAndClicksLoginButton(String email, String password) {
        loginPage.login(email, password);
    }

    @Then("The user verifies that logged in as {string} successfully")
    public void theUserVerifiesThatLoggedInAsSuccessfully(String username) {
        loginPage.loginVerification(username);
    }

    @When("The user adds listed products")
    public void theUserAddsListedProducts(List<String> products) {
        for (String product : products) {
            productsPage.addProduct(product);
        }
    }

    @Then("The user verifies Address Details")
    public void theUserVerifiesAddressDetails() {
        checkoutPage.verifyAddressDetails();
    }

    @And("The user reviews order and verifies Total Amount is {string}")
    public void theUserReviewsOrderAndVerifiesTotalAmountIs(String totalAmount) {
        checkoutPage.verifyTotalAmount(totalAmount);
    }

    @When("The user enters {string} comment to text area")
    public void theUserEntersCommentToTextArea(String commentText) {
        checkoutPage.commentTextArea.sendKeys(commentText);
    }

    @And("The user enters payment details as {string} {string} {string} {string} {string} and clicks pay and confirm order button")
    public void theUserEntersPaymentDetailsAsCvcExpiryMonthExpiryYearAndClicksPayAndConfirmOrderButton
            (String nameOnCard, String cardNumber, String cvc, String expiryMonth, String expiryYear) {
        paymentPage.enterPaymentDetailsAndFinishPurchase(nameOnCard, cardNumber, cvc, expiryMonth, expiryYear);
    }

    @Then("The user verifies {string} message is shown on payment page")
    public void theUserVerifiesMessageIsShownOnPaymentPage(String expectedMsg) {
        paymentPage.verifySuccessMsg(expectedMsg);
    }

    @Then("The user verifies {string} message is shown on payment done page")
    public void theUserVerifiesMessageIsShownOnPaymentDonePage(String expectedMsg) {
        paymentPage.verifySuccessMsgDone(expectedMsg);
    }

    @Then("The user verifies {string} message")
    public void theUserVerifiesMessage(String deleteMsg) {
        deleteAccountPage.verifyAccountDeleted(deleteMsg);
    }

}

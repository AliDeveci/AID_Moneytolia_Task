package com.automationExercise.pages;

import com.automationExercise.utilities.BrowserUtils;
import com.automationExercise.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage{

    @FindBy(xpath = "//button[.='Continue Shopping']")
    public WebElement continueShopping;

    public void addProduct(String productName){
        WebElement product = Driver.get().findElement(By.xpath("(//div/p[text()='"+productName+"'])[1]/following-sibling::a"));
        BrowserUtils.clickWithJS(product);
        continueShopping.click();
    }
}

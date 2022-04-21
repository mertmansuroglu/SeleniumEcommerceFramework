package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.objects.BillingAddress;

public class CheckoutPage  extends BasePage {
    private final By first_name = By.id("billing_first_name");
    private final By last_name = By.id("billing_last_name");
    private final By address = By.id("billing_address_1");
    private final By city = By.id("billing_city");
    private final By postCode = By.id("billing_postcode");
    private final By email = By.id("billing_email");
    private final By place_order = By.name("place_order");
    private final By successNotice = By.cssSelector(".woocommerce-notice");


    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    public CheckoutPage enterFirstname(String firstName){
        driver.findElement(first_name).sendKeys(firstName);
        return this;
    }
    public CheckoutPage enterLastName(String lastName){
        driver.findElement(last_name).sendKeys(lastName);
        return this;
    }
    public CheckoutPage enterAddressLineOne(String enterAddressLineOne){
        driver.findElement(address).sendKeys(enterAddressLineOne);
        return this;
    }
    public CheckoutPage enterCity(String cityy){
        driver.findElement(city).sendKeys(cityy);
        return this;
    }

    public CheckoutPage enterPostCode(String postCodeS){
        driver.findElement(postCode).sendKeys(postCodeS);
        return this;
    }
    public CheckoutPage enterEmail(String emailS){
        driver.findElement(email).sendKeys(emailS);
        return this;
    }
    public CheckoutPage enterPlaceOrder(){
        driver.findElement(place_order).click();
        return this;
    }
    public String successNotice(){
     return  driver.findElement(successNotice).getText();
    }

}

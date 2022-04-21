package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;

public class HomePage extends BasePage {
//burda homepagedeki tum actionlar yer alir!!
private final By storeMenuLink = By.xpath("//li[@id='menu-item-1227']//a[normalize-space()='Store']");

    public HomePage(WebDriver driver) {
        super(driver);
    }
    public HomePage load(){
        load("/");
        return this;
    }

    //eger surekli obje yaratmak istemiyortsun fluence sekilde return type stpre page yapip ordanda ilerleyebilirsin
    public void clickStoreMenuLink(){
        driver.findElement(storeMenuLink).click();
    }

}

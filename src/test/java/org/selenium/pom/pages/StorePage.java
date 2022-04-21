package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;

public class StorePage extends BasePage {
    private final By searchField = By.xpath(" //input[@id='woocommerce-product-search-field-0']");
    private final By searchButton = By.xpath("//button[normalize-space()='Search']");
    private final By productTitle = By.cssSelector(".woocommerce-products-header__title.page-title");
    private final By viewCartlink = By.xpath("//a[@title='View cart']");
    public StorePage(WebDriver driver) {
        super(driver);
    }
    //below, we are returning the object of the same page!!! so we can put this!! this orda current classi ifade eder!! yani storepage
    private StorePage enterTextSearchFld(String txt){
        driver.findElement(searchField).sendKeys(txt);
        return this;
    }

    private StorePage clickSearchBtn(){
        driver.findElement(searchButton).click();
        return this;
    }
    //biren cok metodu functional odakli icerde tutabiliriz
    public StorePage search(String txt){
     enterTextSearchFld(txt).clickSearchBtn();
        return this;
    }
    public String getTitle(){
      return driver.findElement(productTitle).getText();
    }
    //asagidaki gibi paramtrik hale getirip by olarak cekeriz ve istedigimiz yerden cagiririz
    //simdi private yapariz cunku test class a expose etmek istemiyoruz
    private By getAddToCartBtnElement(String productName){
        return By.xpath("//a[normalize-space()='"+productName+"'] /parent::div /a[2]");
    }
    public StorePage clickAddToCartBtn(String productName){
        By addToCartBtn= getAddToCartBtnElement(productName);
        driver.findElement(addToCartBtn).click();
        return this;
    }
    public CartPage clickViewCart(){
        driver.findElement(viewCartlink).click();
        return new CartPage(driver);
    }
}

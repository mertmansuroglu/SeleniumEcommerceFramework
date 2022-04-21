package org.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.BillingAddress;
import org.selenium.pom.pages.CartPage;
import org.selenium.pom.pages.CheckoutPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyFirstCase extends BaseTest {

    //alwyas best practice to put the class in packages
    //selenium cannot interact with browser directly it need to use driver to access to the browser
    @Test
    public void LoginCheckOutUsingDirectBankTransfer() throws InterruptedException {
//asagidaki driver base testing driveridir
        driver.get("https://askomdch.com/");
        driver.manage().window().maximize();
        HomePage homePage= new HomePage(driver);
        StorePage storePage= new StorePage(driver);
        homePage.clickStoreMenuLink();
        storePage.search("Blue");
        Assert.assertEquals(storePage.getTitle(),"Search results: “blue”");
        storePage.clickAddToCartBtn("Blue Shoes");
        Thread.sleep(4000);
        CartPage cartPage= new CartPage(driver);
        storePage.clickViewCart();
        Assert.assertEquals(cartPage.getProductName(),"Blue Shoes");
        cartPage.clickVCheckoutbtn();
        Thread.sleep(4000);
        driver.findElement(By.className("showlogin")).click();
        Thread.sleep(4000);
        driver.findElement(By.id("username")).sendKeys("demouser2");
        driver.findElement(By.id("password")).sendKeys("demopwd");
        driver.findElement(By.name("login")).click();
        driver.findElement(By.id("billing_first_name")).sendKeys("demo");
        driver.findElement(By.id("billing_last_name")).sendKeys("user");
        driver.findElement(By.id("billing_address_1")).sendKeys("San Francisco");
        driver.findElement(By.id("billing_city")).sendKeys("san fransisco");
        driver.findElement(By.id("billing_postcode")).sendKeys("94188");
        driver.findElement(By.id("billing_email")).clear();
        driver.findElement(By.id("billing_email")).sendKeys("mertmansurolu@gmail.com");
        driver.findElement(By.name("place_order")).click();
        Thread.sleep(4000);
        driver.quit();
        //div[@class='site-primary-header-wrap ast-builder-grid-row-container site-header-focus-item ast-container']//div[@class='ast-cart-menu-wrap']

    }
    @Test
    public void guestCheckOutUsingDirectBankTransfer() throws InterruptedException {

        BillingAddress billingAddress= new BillingAddress();
        billingAddress.setFirstName("demo");
        billingAddress.setLastName("demo");
        billingAddress.setAddressLineOne("demo");
        billingAddress.setPostalCode("34000");
        billingAddress.setCity("dima");
        driver.get("https://askomdch.com/");
        driver.manage().window().maximize();
        //asagida biz pagelere gore endpointleri  load ederiz!!!
        HomePage homePage= new HomePage(driver).load();
        StorePage storePage= new StorePage(driver);
        homePage.clickStoreMenuLink();
        storePage.search("Blue");
        Assert.assertEquals(storePage.getTitle(),"Search results: “Blue”");
        storePage.clickAddToCartBtn("Blue Shoes");
        Thread.sleep(4000);
        CartPage cartPage= new CartPage(driver);
        storePage.clickViewCart();
        Assert.assertEquals(cartPage.getProductName(),"Blue Shoes");
        cartPage.clickVCheckoutbtn();
        Thread.sleep(4000);
        CheckoutPage checkoutPage= new CheckoutPage(driver);
        //asagidaki structured sekilde page object olur
        //ama biz eger functional istersek bir methoda asagidakini ekleriz ve tum parametreleri bir gireriz
        checkoutPage.
                enterFirstname("demo").
                enterLastName("user").
                enterAddressLineOne("San Francisco").
                enterCity("san fransisco").
                enterPostCode("94188").
                enterEmail("mertmansurolu@gmail.com").
                enterPlaceOrder();
        Thread.sleep(4000);
        Assert.assertEquals(checkoutPage.successNotice(),"Thank you. Your order has been received.");
        driver.quit();
        //div[@class='site-primary-header-wrap ast-builder-grid-row-container site-header-focus-item ast-container']//div[@class='ast-cart-menu-wrap']

    }
}

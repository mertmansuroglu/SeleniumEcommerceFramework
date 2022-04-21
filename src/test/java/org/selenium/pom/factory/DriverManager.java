package org.selenium.pom.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    //only job of the method is the return the intialized driver object!
    //yani atomic sadece ilgili olan isi yapar!
    public WebDriver initializeDriver(){
        WebDriverManager.chromedriver().cachePath("Drivers").setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }
}

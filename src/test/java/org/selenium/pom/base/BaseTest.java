package org.selenium.pom.base;

import org.openqa.selenium.WebDriver;
import org.selenium.pom.factory.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {


    //the driver should not be made accessible outside the base class and the sub classes!!!!
    //eger public olsaydi hazardous wayler icin isteyen kullanaiblirdi! encapsulation
  protected WebDriver driver;
//driver managerdan driveri cektik start ettirip quit ettik
    @BeforeMethod
    public void startDriver(){
        driver= new DriverManager().initializeDriver();
    }

    @AfterMethod
    public void quitDriver(){
            driver.quit();
    }

}

package test;

import Utils.TestListener;
import driver.DriverSingletone;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public class CommonConditions {
    protected WebDriver driver;
    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = DriverSingletone.getDriver();
//        driver = DriverSingletone.getRemoteDriver();
    }
    @AfterMethod(alwaysRun = true)
    public void browserClose() {
       DriverSingletone.closeDriver();
    }
}

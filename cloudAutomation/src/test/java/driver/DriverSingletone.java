package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverSingletone {
    private static WebDriver driver;
    private static final String NODE_URL = "http://192.168.0.103:5555/wd/hub";

    private DriverSingletone(){}

    public static WebDriver getDriver(){
        if(null==driver){
            switch (System.getProperty("browser")){
                case "firefox":{
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                }
                default:{
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                }
                driver.manage().window().maximize();
            }

        }
        return driver;
    }

    public static WebDriver getRemoteDriver(){
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.WINDOWS);
        try {
            driver = new RemoteWebDriver(new URL(NODE_URL), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().window().maximize();
        return driver;
    }

    public static void closeDriver(){
        driver.quit();
        driver = null;
    }

}

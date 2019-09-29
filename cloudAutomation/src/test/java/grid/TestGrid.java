package grid;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class TestGrid {
    static WebDriver driver;
    static String nodeUrl;

    public static void main(String[] args) {

            nodeUrl = "http://192.168.0.103:5555/wd/hub";
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
  //          capabilities.setBrowserName("chrome");
            capabilities.setPlatform(Platform.WINDOWS);
        try {
            driver = new RemoteWebDriver(new URL(nodeUrl), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().window().maximize();
        driver.get("https://www.tut.by/");

    }
}

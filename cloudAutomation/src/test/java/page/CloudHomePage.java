package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CloudHomePage extends CloudAbstractPage {

    private static final String HOME_URL = "https://cloud.google.com/";
    private static final String XPATH_SEE_ALL_PRODUCTS_BTN = "//a[contains(text(),'See products')]";
    private static final Logger logger = LogManager.getRootLogger();

    public CloudHomePage(WebDriver driver) {
        super(driver);
    }

    public CloudHomePage openPage() {
        driver.get(HOME_URL);
        logger.info("CloudHomePage is open");
        return this;
    }

    public CloudProductsAndServicesPage seeAllProducts(){
        WebElement seeAllProductsBtn = waitForElementLocatedBy(By.xpath(XPATH_SEE_ALL_PRODUCTS_BTN));
        seeAllProductsBtn.click();
        return new CloudProductsAndServicesPage(driver);
    }

    public String getAllProductsBtnName(){
        WebElement seeAllProductsBtn = waitForElementLocatedBy(By.xpath(XPATH_SEE_ALL_PRODUCTS_BTN));
        return seeAllProductsBtn.getText();
    }
}
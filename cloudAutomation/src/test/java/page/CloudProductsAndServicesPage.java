package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.CloudAbstractPage;
import page.CloudPricingPage;

public class CloudProductsAndServicesPage extends CloudAbstractPage {
    private static final String XPATH_SEE_PRICING_BTN = "//a[contains(text(),'See pricing')]";
    private static final Logger logger = LogManager.getRootLogger();

    public CloudProductsAndServicesPage(WebDriver driver) {
        super(driver);
        logger.info("CloudProductsAndServicesPage is open");
    }

    public CloudPricingPage seePricing(){
        WebElement seePricingBtn = waitForElementLocatedBy(By.xpath(XPATH_SEE_PRICING_BTN));
        seePricingBtn.click();
        return new CloudPricingPage(driver);
    }
}

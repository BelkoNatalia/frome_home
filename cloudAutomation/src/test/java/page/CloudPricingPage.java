package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import page.CloudFillingCalculationFormPage;
import page.CloudAbstractPage;

public class CloudPricingPage  extends CloudAbstractPage {
    private static final String XPATH_CALCULATORS_BTN = "//a[text()='Calculators']";
    private static final Logger logger = LogManager.getRootLogger();

    public CloudPricingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        logger.info("CloudPricingPage is open");
    }

    public CloudFillingCalculationFormPage usePricingCalculator(){
        WebElement calculatorsBtn = waitForElementLocatedBy(By.xpath(XPATH_CALCULATORS_BTN));
        calculatorsBtn.click();
        return new CloudFillingCalculationFormPage(driver);
    }
}

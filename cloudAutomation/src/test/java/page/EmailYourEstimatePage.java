package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmailYourEstimatePage extends CloudAbstractPage {

    private static final String ID_IFRAME = "idIframe";
    private static final String XPATH_EMAIL_FIELD = "//label[contains(text(),'Email')]/following-sibling::input";
    private static final String XPATH_SEND_EMAIL_BTN = "//button[contains(text(),'Send Email') and not(@disabled)]";
    private static final Logger logger = LogManager.getRootLogger();

    public EmailYourEstimatePage(WebDriver driver) {
        super(driver);
        logger.info("EmailYourEstimatePage is open");
    }

    public EmailYourEstimatePage fillEmailField(String email) {
        WebElement iFrame = waitForElementLocatedBy(By.id(ID_IFRAME));
        driver.switchTo().frame(iFrame);
        waitForElementLocatedBy(By.xpath(XPATH_EMAIL_FIELD)).sendKeys(email);
        return this;
    }

    public CloudCalkulationResultPage sendEmail() {
        waitForElementToBeClickableBy(By.xpath(XPATH_SEND_EMAIL_BTN)).click();
        logger.info("Email is sent");
        return new CloudCalkulationResultPage(driver);
    }
}

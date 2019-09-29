package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmailContentPage extends CloudAbstractPage {

    private static final String XPATH_COST_IN_EMAIL_FIELD = "//h3[text() = 'Total Estimated Monthly Cost']/following::h3";
    private static final String ID_IFRAME = "mess_frame";
    private static final Logger logger = LogManager.getRootLogger();

    public EmailContentPage(WebDriver driver) {
        super(driver);
        logger.info("EmailContentPage is open");
    }

    public String getTotalEstimateCost(){
       WebElement iFrame = waitForElementLocatedBy(By.id(ID_IFRAME));
       driver.switchTo().frame(iFrame);
       return waitForElementLocatedBy(By.xpath(XPATH_COST_IN_EMAIL_FIELD)).getText();
    }
}

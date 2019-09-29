package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CloudCalkulationResultPage extends CloudAbstractPage {
    private static final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//b[contains(text(), 'Total Estimated Cost:')]")
    private WebElement totalEstimatedCostRow;

    @FindBy(xpath = "//button[contains(text(),'Email Estimate')]")
    private WebElement emailEstimateBtn;

    public CloudCalkulationResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        logger.info("CloudCalkulationResultPage is open");
    }

    public String getTotalEstimatedCost() {
        return totalEstimatedCostRow.getText();
    }

    public EmailYourEstimatePage chooseEmailEstimate(){
        emailEstimateBtn.click();
        return new EmailYourEstimatePage(driver);
    }
}

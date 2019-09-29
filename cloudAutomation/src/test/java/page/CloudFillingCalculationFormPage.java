package page;

import model.ComputerEngine;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CloudFillingCalculationFormPage extends CloudAbstractPage {
    private static final String ID_IFRAME = "idIframe";
    private static final String TEMPLATE_XPATH_ITEM_DROP_DOWN_MENU = "//div[@class='md-select-menu-container md-active md-clickable']" +
            "//md-option/div[contains(text(),'%s')]";
    private static final String XPATH_GPUS_CHECK_BOX = "//div[contains(text(),'Add GPUs.')]/preceding-sibling::div";
    private static final String ID_LOCAL_SSD_FIELD = "select_value_label_49";
    private static final String XPATH_WAIT_CLOSE_MENU = "//md-select[@aria-expanded='true']";
    private static final String XPATH_ESTIMATE_BTN = "//form[@name='ComputeEngineForm']" +
            "//button[@class ='md-raised md-primary cpc-button md-button md-ink-ripple' ]";
    private static final Logger logger = LogManager.getRootLogger();

    @FindBy(id = "idIframe")
    private WebElement iframe;

    @FindBy(xpath = "//md-tab-item//div[text()='Compute Engine' ]")
    private WebElement computeEngineBtn;

    @FindBy(id = "input_52")//"input[@id='input_1493']"
    private WebElement numberOfInstancesInput;

    @FindBy(id = "select_value_label_45")
    private WebElement operatingSystemSoftwareField;

    @FindBy(id = "select_value_label_46")
    private WebElement machineClassField;

    @FindBy(id = "select_value_label_48")
    private WebElement machineTypeField;

    @FindBy(id = "select_value_label_339")
    private WebElement numberOfGPUsField;

    @FindBy(id = "select_value_label_340")
    private WebElement GPuTypeField;

    @FindBy(id = "select_value_label_50")
    private WebElement datacenterLocationField;

    @FindBy(xpath = "//form[@name='ComputeEngineForm']//md-select[@placeholder='Committed usage']")
    private WebElement commitedUsageField;

    public CloudFillingCalculationFormPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        logger.info("CloudProductsAndServicesPage is open");
    }

    public CloudFillingCalculationFormPage activateComputeEngine() {
        waitForElementLocatedBy(By.id(ID_IFRAME));
        driver.switchTo().frame(iframe);
        computeEngineBtn.click();
        return this;
    }

    public CloudFillingCalculationFormPage fillNumberOfInstances(ComputerEngine computerEngine) {
        numberOfInstancesInput.sendKeys(computerEngine.getNumberOfInstances());
        return this;
    }

    public CloudFillingCalculationFormPage chooseOperatingSystem(ComputerEngine computerEngine) {
        String xpathOperatingSystem = String.format(TEMPLATE_XPATH_ITEM_DROP_DOWN_MENU, computerEngine.getOperatingSystem());
        operatingSystemSoftwareField.click();
        WebElement operatingSystemOption = waitForElementLocatedBy(By.xpath(xpathOperatingSystem));
        operatingSystemOption.click();
        return this;
    }

    public CloudFillingCalculationFormPage chooseMachineClass(ComputerEngine computerEngine) {
        String xpathMachineClass = String.format(TEMPLATE_XPATH_ITEM_DROP_DOWN_MENU, computerEngine.getMachineClass());
        machineClassField.click();
        waitForElementLocatedBy(By.xpath(xpathMachineClass)).click();
        return this;
    }

    public CloudFillingCalculationFormPage chooseMachineType(ComputerEngine computerEngine){
        String xpathMachineType = String.format(TEMPLATE_XPATH_ITEM_DROP_DOWN_MENU, computerEngine.getMachineType());
        machineTypeField.click();
        waitForElementToBeClickableBy(By.xpath(xpathMachineType)).click();
        return this;
    }

    public CloudFillingCalculationFormPage pickGPUs() {
        WebElement gpusCheckBox = waitForElementToBeClickableBy(By.xpath(XPATH_GPUS_CHECK_BOX));
        if (!gpusCheckBox.isSelected()) {
            gpusCheckBox.click();
        }
        return this;
    }

    public CloudFillingCalculationFormPage chooseNumberOfGPUs(ComputerEngine computerEngine){
        String xpathNumberOfGPUs = String.format(TEMPLATE_XPATH_ITEM_DROP_DOWN_MENU, computerEngine.getNumberOfGpu());
        numberOfGPUsField.click();
        WebElement element = waitForElementToBeClickableBy(By.xpath(xpathNumberOfGPUs));
        element.click();
        return this;
    }

    public CloudFillingCalculationFormPage chooseGPuType(ComputerEngine computerEngine) {
        String xpathGPuTyp = String.format(TEMPLATE_XPATH_ITEM_DROP_DOWN_MENU, computerEngine.getGpuType());
        GPuTypeField.click();
        waitForElementLocatedBy(By.xpath(xpathGPuTyp)).click();
        return this;
    }

    public CloudFillingCalculationFormPage chooseLocalSsd(ComputerEngine computerEngine) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(XPATH_ESTIMATE_BTN)));
        String xpathLocalSsd = String.format(TEMPLATE_XPATH_ITEM_DROP_DOWN_MENU, computerEngine.getLocalSsd());
        WebElement localSsdField = waitForElementToBeClickableBy(By.id(ID_LOCAL_SSD_FIELD));

        waitInvisibilityOfElementLocated(By.xpath(XPATH_WAIT_CLOSE_MENU));

        localSsdField.click();
        waitForElementToBeClickableBy(By.xpath(xpathLocalSsd)).click();
        return this;
    }

    public CloudFillingCalculationFormPage chooseDatacenterLocation(ComputerEngine computerEngine) {
        String xpathDatacenterLocation = String.format(TEMPLATE_XPATH_ITEM_DROP_DOWN_MENU, computerEngine.getDatacenterLocation());
        datacenterLocationField.click();
        waitForElementToBeClickableBy(By.xpath(xpathDatacenterLocation)).click();
        return this;
    }

    public CloudFillingCalculationFormPage chooseCommittedUsage(ComputerEngine computerEngine) {
        String xpathCommittedUsage = String.format(TEMPLATE_XPATH_ITEM_DROP_DOWN_MENU, computerEngine.getCommitedUsach());
        commitedUsageField.click();
        waitForElementToBeClickableBy(By.xpath(xpathCommittedUsage)).click();
        return this;
    }

    public CloudCalkulationResultPage getEstimation() {
        waitForElementLocatedBy(By.xpath(XPATH_ESTIMATE_BTN)).click();
        logger.info("Form is filled in and gone to calculate");
        return new CloudCalkulationResultPage(driver);
    }
}

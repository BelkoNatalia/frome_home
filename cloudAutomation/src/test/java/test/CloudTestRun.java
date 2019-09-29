package test;

import Utils.StringUtils;
import model.ComputerEngine;
import org.testng.annotations.Test;
import page.CloudCalkulationResultPage;
import page.CloudHomePage;
import page.CrazyMailingPage;
import page.EmailYourEstimatePage;
import service.ProductCreator;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CloudTestRun extends CommonConditions {

    @Test(description = "Filling form correct amount of the order by email")
    public void checkTheCorrectAmountOfTheOrderByEmail() {
        String emailSubject = "Google Cloud Platform Price Estimate";
        String temporaryMail = "https://www.crazymailing.com";

        ComputerEngine testComputerEngine = ProductCreator.createProductComputerEngine();

        CloudHomePage cloudHomePage = new CloudHomePage(driver);

        String estimatedCostByPage = cloudHomePage.openPage()
                .seeAllProducts()
                .seePricing()
                .usePricingCalculator()
                .activateComputeEngine()
                .fillNumberOfInstances(testComputerEngine)
                .chooseOperatingSystem(testComputerEngine)
                .chooseMachineClass(testComputerEngine)
                .chooseMachineType(testComputerEngine)
                .pickGPUs()
                .chooseNumberOfGPUs(testComputerEngine)
                .chooseGPuType(testComputerEngine)
                .chooseLocalSsd(testComputerEngine)
                .chooseDatacenterLocation(testComputerEngine)
                .chooseCommittedUsage(testComputerEngine)
                .getEstimation()
                .getTotalEstimatedCost();

        CloudCalkulationResultPage cloudCalkulationResultPage = new CloudCalkulationResultPage(driver);

        EmailYourEstimatePage emailYourEstimatePage = cloudCalkulationResultPage.chooseEmailEstimate();

        String emailEstimateWindowHandle = emailYourEstimatePage.getCurrentWindowHandle();
        emailYourEstimatePage.openNewTabWithUrl(temporaryMail);

        CrazyMailingPage crazyMailingPage = new CrazyMailingPage(driver);
        String emailAddress = crazyMailingPage.getEmail();
        String crazyMailingWindowHandle = crazyMailingPage.getCurrentWindowHandle();
        crazyMailingPage.goToTabByWindowHandle(emailEstimateWindowHandle);

        new EmailYourEstimatePage(driver).fillEmailField(emailAddress)
                .sendEmail()
                .goToTabByWindowHandle(crazyMailingWindowHandle);

        String totalEstimateCostFromEmail = crazyMailingPage.openEmailBySubject(emailSubject)
                .getTotalEstimateCost().trim();

        String expectedEstimatedCostValue = StringUtils.formatEstimatedCost(estimatedCostByPage);

        assertThat(expectedEstimatedCostValue, is(equalTo(totalEstimateCostFromEmail)));
    }

}

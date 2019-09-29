package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import page.CloudHomePage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class FindAiHubTest extends CommonConditions{
    @Test(description = "Find AiHub section")
    public void findAiHubSection() {

        String expectedlSectionName = "AI Hub";

        CloudHomePage cloudHomePage = new CloudHomePage(driver);

        String currentSectionName = cloudHomePage.openPage()
                .goToSearchField().searchSupport().goToSupportSection();
        assertThat(currentBtnName, is(equalTo(expectedlBtnName)));
    }

}

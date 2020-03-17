package by.epamtc.automation.selenium.task4.test;

import by.epamtc.automation.selenium.task4.page.GoogleCloudMainPageTask4;
import by.epamtc.automation.selenium.task4.page.TemporaryEmailPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FourthTaskTest {

    private WebDriver driver;
    private TemporaryEmailPage resultPage;
    private static final String PAGE_COST = "USD 1,082.77";

    @BeforeMethod(alwaysRun = true)
    public void findCostOfComputeEngineRent() {
        driver = new ChromeDriver();
        resultPage = new GoogleCloudMainPageTask4(driver)
                .openHomePage()
                .fillInSearchInputLine()
                .selectDesiredSearchResult()
                .fillInCalculatorFields()
                .clickEmailEstimateButton()
                .getEmail()
                .addEmail();
    }

    @Test
    public void compareCostsFromDifferentSources() {
        String mailCost = resultPage.getCostOfLetter();
        Assert.assertEquals(mailCost, PAGE_COST);
    }

    @AfterMethod (alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

}

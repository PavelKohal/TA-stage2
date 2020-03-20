package by.epamtc.automation.selenium.task4.test;

import by.epamtc.automation.selenium.task4.page.CalculatorPageTask4;
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

    @BeforeMethod (alwaysRun = true)
    public void getSourceData() {
        driver = new ChromeDriver();
        resultPage = new GoogleCloudMainPageTask4(driver)
                .openHomePage()
                .fillInSearchInputLine()
                .selectDesiredSearchResult()
                .clickComputerEngineButton()
                .fillInNumberOfInstance()
                .fillInRequiredData()
                .clickEmailEstimateButton()
                .getEmail()
                .addEmail();
    }

    @Test
    public void compareCostsFromDifferentSources() {
        Assert.assertTrue(CalculatorPageTask4.costOnPage.contains(resultPage.getCostInLetter()));
    }

    @AfterMethod (alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

}

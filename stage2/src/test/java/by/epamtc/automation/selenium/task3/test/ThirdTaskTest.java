package by.epamtc.automation.selenium.task3.test;

import by.epamtc.automation.selenium.task3.page.EstimatePageTask3;
import by.epamtc.automation.selenium.task3.page.GoogleCloudMainPageTask3;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class ThirdTaskTest {

    private WebDriver driver;
    private EstimatePageTask3 resultPage;

    @BeforeClass(alwaysRun = true)
    public void makeAnEstimateOfComputeEngineRent() {
        driver = new ChromeDriver();
        resultPage = new GoogleCloudMainPageTask3(driver)
                .openHomePage()
                .fillInSearchInputLine()
                .selectDesiredSearchResult()
                .clickComputerEngineButton()
                .fillInNumberOfInstance()
                .selectOperationSystem()
                .selectMachineClass()
                .selectInstanceType()
                .selectGPUs()
                .selectLocalSSD()
                .selectDatacenterLocation()
                .selectCommittedUsage()
                .clickAddToEstimateButton();
    }

    @Test
    public void machineClassFieldMatching() {
        Assert.assertTrue(resultPage.findResultMachineClassText().contains("regular".toLowerCase()));
    }

    @Test
    public void instanceTypeFieldMatching() {
        Assert.assertTrue(resultPage.findResultInstanceTypeText().contains("n1-standard-8".toLowerCase()));
    }

    @Test
    public void regionFieldMatching() {
        Assert.assertTrue(resultPage.findResultRegionText().contains("Frankfurt".toLowerCase()));
    }

    @Test
    public void ssdFieldMatching() {
        Assert.assertTrue(resultPage.findResultSsdText().contains("2x375 GB".toLowerCase()));
    }

    @Test
    public void commitmentTermFieldMatching() {
        Assert.assertTrue(resultPage.findCommitmentTermText().contains("1 Year".toLowerCase()));
    }

    @Test
    public void totalCostFieldMatching() {
        Assert.assertTrue(resultPage.findTotalCost().contains("1,082.77"));
    }

    @AfterClass (alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}

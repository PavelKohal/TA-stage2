package by.epamtc.automation.selenium.task3.test;

import by.epamtc.automation.selenium.task3.page.GoogleCloudMainPageTask3;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ThirdTaskTest {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        new GoogleCloudMainPageTask3(driver)
                .openHomePage()
                .fillInSearchInputLine()
                .selectDesiredSearchResult()
                .fillInNumberOfInstance()
                .selectOperationSystem()
                .selectMachineClass()
                .selectInstanceType()
                .selectGPUs()
                .selectLocalSSD()
                .selectDatacenterLocation()
                .selectCommittedUsage()
                .clickAddToEstimateButton();

        Thread.sleep(10000);
        driver.quit();
    }


}

package by.epamtc.automation.selenium.task2.test;

import by.epamtc.automation.selenium.task1.page.PastebinCreationResultPage;
import by.epamtc.automation.selenium.task1.page.PastebinHomePage;
import by.epamtc.automation.selenium.task2.page.PastebinCreationResultPageTask2;
import by.epamtc.automation.selenium.task2.page.PastebinHomePageTask2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SecondTaskTest {

    private WebDriver driver;
    private PastebinCreationResultPageTask2 resultPage;

    @BeforeClass(alwaysRun = true)
    public void createNewPaste() throws InterruptedException {
        driver = new ChromeDriver();
        resultPage = new PastebinHomePageTask2(driver).
                openHomePage().
                enterBodyOfNewPaste().
                selectSyntaxHighlighting().
                selectPasteInspiration().
                enterPasteName().
                createNewPaste();
        Thread.sleep(10000);
    }

    @Test
    public void test1111() { //naming


        Assert.assertTrue(resultPage.equals(null));
    }

    @AfterClass(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}

package by.epamtc.automation.selenium.task2.test;

import by.epamtc.automation.selenium.task2.page.PastebinCreationResultPageTask2;
import by.epamtc.automation.selenium.task2.page.PastebinHomePageTask2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static by.epamtc.automation.selenium.task2.page.PastebinHomePageTask2.*;

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
    }

    @Test
    public void browserPageTitleMatching() {
        Assert.assertTrue(resultPage.findPageTitleText().equals(PASTE_TITLE));
    }

    @Test
    public void syntaxHighlightingMatching() {
        Assert.assertTrue(resultPage.findSyntaxHighlightning().equals(PASTE_FORMAT));
    }

    @Test
    public void pasteCodeMatching() {
        Assert.assertTrue(resultPage.findPasteCodeText().equals(PASTE_BODY));
    }

    @AfterClass(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}

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
    public void createNewPaste() {
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
        Assert.assertEquals(PASTE_TITLE, resultPage.findPageTitleText());
    }

    @Test
    public void syntaxHighlightingMatching() {
        Assert.assertEquals(resultPage.findSyntaxHighlightning(),PASTE_FORMAT);
    }

    @Test
    public void pasteCodeMatching() {
        Assert.assertEquals(PASTE_BODY, resultPage.findPasteCodeText());
    }

    @AfterClass(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}

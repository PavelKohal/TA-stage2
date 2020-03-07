package by.epamtc.automation.selenium.task1.test;

import by.epamtc.automation.selenium.task1.page.PastebinHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstTaskTest {

    private WebDriver driver;
    private static final String EXPECTED_MESSAGE = "Your guest paste has been posted.";

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
    }

    @Test
    public void createNewPaste() {
        String expectedNoteAboutNewPaste = new PastebinHomePage(driver)
                .openHomePage()
                .enterBodyOfNewPaste()
                .selectPasteInspiration()
                .enterPasteName()
                .createNewPaste()
                .getSuccessfulCreationMessage();
        Assert.assertTrue(expectedNoteAboutNewPaste.contains(EXPECTED_MESSAGE), "No new paste created.");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}

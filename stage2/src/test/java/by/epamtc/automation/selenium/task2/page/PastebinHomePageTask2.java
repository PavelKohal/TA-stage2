package by.epamtc.automation.selenium.task2.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PastebinHomePageTask2 {

    private WebDriver driver;

    public PastebinHomePageTask2(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private static final String HOME_PAGE_URL = "https://pastebin.com";
    public static final String PASTE_BODY = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";
    public static final String PASTE_FORMAT = "Bash";
    private static final String EXPIRATION_TIME = "10 Minutes";
    public static final String PASTE_TITLE = "how to gain dominance among developers";

    @FindBy(id = "paste_code")
    WebElement codeInputArea;

    @FindBy(name = "paste_expire_date")
    WebElement selectPasteExpiration;

    @FindBy(name = "paste_format")
    WebElement selectSyntaxHighlighting;

    @FindBy(name = "paste_name")
    WebElement pasteNameInput;

    @FindBy(id = "submit")
    WebElement createPasteButton;

    public PastebinHomePageTask2 openHomePage() {
        driver.get(HOME_PAGE_URL);
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("paste_code")));
        return this;
    }

    public PastebinHomePageTask2 enterBodyOfNewPaste() {
        codeInputArea.sendKeys(PASTE_BODY);
        return this;
    }

    public PastebinHomePageTask2 selectSyntaxHighlighting() {
        Select select = new Select(selectSyntaxHighlighting);
        select.selectByVisibleText(PASTE_FORMAT);
        return this;
    }

    public PastebinHomePageTask2 selectPasteInspiration() {
        Select select = new Select(selectPasteExpiration);
        select.selectByVisibleText(EXPIRATION_TIME);
        return this;
    }

    public PastebinHomePageTask2 enterPasteName() {
        pasteNameInput.sendKeys(PASTE_TITLE);
        return this;
    }

    public PastebinCreationResultPageTask2 createNewPaste() {
        createPasteButton.click();
        return new PastebinCreationResultPageTask2(driver);
    }
}

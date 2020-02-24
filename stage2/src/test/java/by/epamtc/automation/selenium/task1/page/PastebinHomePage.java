package by.epamtc.automation.selenium.task1.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PastebinHomePage {

    private WebDriver driver;

    public PastebinHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private static final String HOME_PAGE_URL = "https://pastebin.com";
    private static final String PASTE_BODY = "Hello from WebDriver";
    private static final String EXPIRATION_TIME = "10 Minutes";
    private static final String PASTE_TITLE = "helloweb";

    @FindBy(id = "paste_code")
    WebElement codeInputArea;

    @FindBy(name = "paste_expire_date")
    WebElement selectPasteExpiration;

    @FindBy(name = "paste_name")
    WebElement pasteNameInput;

    @FindBy(id = "submit")
    WebElement createPasteButton;

    public PastebinHomePage openHomePage() {
        driver.get(HOME_PAGE_URL);
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("paste_code")));
        return  this;
    }

    public PastebinHomePage enterBodyOfNewPaste() {
        codeInputArea.sendKeys(PASTE_BODY);
        return  this;
    }

    public PastebinHomePage selectPasteInspiration() {
        Select select = new Select(selectPasteExpiration);
        select.selectByVisibleText(EXPIRATION_TIME);
        return this;
    }

    public PastebinHomePage enterPasteName() {
        pasteNameInput.sendKeys(PASTE_TITLE);
        return this;
    }

    public PastebinCreationResultPage createNewPaste() {
        createPasteButton.click();
        return new PastebinCreationResultPage(driver);
    }
}

package by.epamtc.automation.selenium.task2.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PastebinCreationResultPageTask2 {

    WebDriver driver;

    public PastebinCreationResultPageTask2(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "success")
    WebElement blockDescribingSuccessfulCreation;

    @FindBy(xpath = "//*[@class='paste_box_line1']")
    WebElement resultPageTitle;

    @FindBy(xpath = "//a[@href='/archive/bash']")
    WebElement codeButton;

    @FindBy(id = "selectable")
    WebElement resultPasteCode;

    public String findPageTitleText() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='paste_box_line1']")));
        return resultPageTitle.getText();
    }

    public String findSyntaxHighlightning() {
        return codeButton.getText();
    }

    public String findPasteCodeText() {
        return resultPasteCode.getText();
    }
}

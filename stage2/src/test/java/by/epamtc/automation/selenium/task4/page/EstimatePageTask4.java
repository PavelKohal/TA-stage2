package by.epamtc.automation.selenium.task4.page;

import by.epamtc.automation.selenium.TestMailPAge;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;

public class EstimatePageTask4 {

    WebDriver driver;
    String email;

    public EstimatePageTask4(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public EstimatePageTask4(WebDriver driver, String email) {
        this.driver = driver;
        this.email = email;
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//div[@class='md-list-item-text']")
    WebElement totalCostField;

    @FindBy (xpath = "//*[@id='email_quote']")
    WebElement emailEstimateButton;

    @FindBy (xpath = "//*[@id='cloud-site']/devsite-iframe/iframe")
    WebElement firstFrameEmail;

    @FindBy (xpath = "//*[@id='myFrame']")
    WebElement secondFrameEmail;

    @FindBy (xpath = "//*[@id='input_393']")
    WebElement emailInputField;

    public TestMailPAge clickEmailEstimateButton() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(emailEstimateButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", emailEstimateButton);
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> browserPages = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(browserPages.get(1));
        return new TestMailPAge(driver);
    }

    public TestMailPAge addEmail() throws  InterruptedException  {
        driver.switchTo().frame(firstFrameEmail).switchTo().frame(secondFrameEmail);
        WebElement emailField = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='input_393']")));
        emailField.sendKeys(email);
        WebElement emailSendButton = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='dialogContent_399']/form/md-dialog-actions/button[2]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", emailSendButton);
        Thread.sleep(5000);
        ArrayList<String> browserPages = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(browserPages.get(1));

        return new TestMailPAge(driver);
    }
}

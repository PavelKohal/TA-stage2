package by.epamtc.automation.selenium.task4.page;

import by.epamtc.automation.selenium.task4.page.EstimatePageTask4;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;

public class TemporaryEmailPage {

    WebDriver driver;


    public TemporaryEmailPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy (xpath = "//input[@id='fe_text']")
    WebElement mail;

    @FindBy (xpath = "//*[@id='maillist']//a[text()='Google Cloud Platform Price Estimate']")
    WebElement expectedMail;

    @FindBy (xpath = "//*[@id='tab1']/div/div/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/h3")
    WebElement mailCost;

    public EstimatePageTask4 getEmail() {
        driver.get("https://10minutemail.net");
         new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='fe_text']")));
        new WebDriverWait(driver, 10).until(ExpectedConditions.attributeToBeNotEmpty(mail, "value"));
        String emailStringValue = mail.getAttribute("value");
        ArrayList<String> browserPages = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(browserPages.get(0));
        return new EstimatePageTask4(driver, emailStringValue);
    }

    public String getCostOfLetter() {
        new WebDriverWait(driver, 180)
                .until(ExpectedConditions.elementToBeClickable(expectedMail));
        expectedMail.click();
         new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='tab1']/div/div/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/h3")));
        return  mailCost.getText();
    }
}

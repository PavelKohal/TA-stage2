package by.epamtc.automation.selenium;

import by.epamtc.automation.selenium.task4.page.EstimatePageTask4;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;

public class TestMailPAge {
    WebDriver driver;

    public TestMailPAge(WebDriver driver) {
        this.driver = driver;
    }

    public EstimatePageTask4 getEmail() throws InterruptedException {
        driver.get("https://10minutemail.net");
        WebElement mail = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='fe_text']")));
        new WebDriverWait(driver, 10).until(ExpectedConditions.attributeToBeNotEmpty(mail, "value"));
        String emailStringValue = mail.getAttribute("value");
        ArrayList<String> browserPages = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(browserPages.get(0));
        return new EstimatePageTask4(driver, emailStringValue);
    }

    public EstimatePageTask4 getBodyOfLetter() throws InterruptedException {
        WebElement mail = new WebDriverWait(driver, 180)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='maillist']//a[text()='Google Cloud Platform Price Estimate']")));
        mail.click();
        WebElement mailCost = new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='tab1']/div/div/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/h3")));
        
        System.out.println(mailCost.getText());

        return  new EstimatePageTask4(driver);



    }
}

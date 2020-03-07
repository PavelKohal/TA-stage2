package by.epamtc.automation.selenium.task3;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebDriverScript {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get(" https://cloud.google.com");

        WebElement inputSearchButton = driver.findElement(By.xpath("//div[@class='devsite-searchbox']"));
        inputSearchButton.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .visibilityOf(inputSearchButton));

        WebElement inputSearchLine = driver.findElement(By.name("q"));
        inputSearchLine.sendKeys("Google Cloud Platform Pricing Calculator" + Keys.ENTER);

        Thread.sleep(4000);

        driver.quit();
    }
}

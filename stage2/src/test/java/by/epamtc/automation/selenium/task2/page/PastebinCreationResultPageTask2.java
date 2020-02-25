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

//    public PastebinCreationResultPage getSuccessfulCreationMessage() {
//        new WebDriverWait(driver, 10)
//                .until(ExpectedConditions.presenceOfElementLocated(By.id("success")));
//        return this
//    }
}

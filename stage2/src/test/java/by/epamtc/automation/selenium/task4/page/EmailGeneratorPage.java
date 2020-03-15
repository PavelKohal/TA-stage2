package by.epamtc.automation.selenium.task4.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;

public class EmailGeneratorPage {

    WebDriver driver;

    public EmailGeneratorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    private By emailAddressBy = By.id("mailAddress");



//    public EstimatePageTask4 copyEmailAddress() throws IOException, UnsupportedFlavorException {
//
//            String emailAddress = new WebDriverWait(driver, 20)
//                    .until(ExpectedConditions.visibilityOfElementLocated(emailAddressBy)).getAttribute("value");
//            ArrayList<String> browserPages = new ArrayList<String>(driver.getWindowHandles());
//            driver.switchTo().window(browserPages.get(0));
//            return new EstimatePageTask4(driver, emailAddress);
//    }
}

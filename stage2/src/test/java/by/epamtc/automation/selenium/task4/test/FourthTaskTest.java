package by.epamtc.automation.selenium.task4.test;

import by.epamtc.automation.selenium.TestMailPAge;
import by.epamtc.automation.selenium.task4.page.EmailGeneratorPage;
import by.epamtc.automation.selenium.task4.page.EstimatePageTask4;
import by.epamtc.automation.selenium.task4.page.GoogleCloudMainPageTask4;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;


public class FourthTaskTest {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        EstimatePageTask4 resultPage = new GoogleCloudMainPageTask4(driver)
                .openHomePage()
                .fillInSearchInputLine()
                .selectDesiredSearchResult()
                .fillInCalculatorFields()
                .clickEmailEstimateButton()
                .getEmail()
                .addEmail()
                .getBodyOfLetter();
        
        driver.quit();
    }

}

package by.epamtc.automation.selenium.task3.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class EstimatePageTask3 {

    WebDriver driver;

    public EstimatePageTask3(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    
}

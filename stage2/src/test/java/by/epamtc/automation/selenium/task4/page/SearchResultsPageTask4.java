package by.epamtc.automation.selenium.task4.page;

import by.epamtc.automation.selenium.task3.page.CalculatorPageTask3;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPageTask4 {

    private WebDriver driver;

    public SearchResultsPageTask4(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='___gcse_0']//div[@class='gs-title']//b[text()='Google Cloud Platform Pricing Calculator']")
    WebElement desiredSearchResult;

    public CalculatorPageTask4 selectDesiredSearchResult() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(desiredSearchResult));
        desiredSearchResult.click();
        return new CalculatorPageTask4(driver);
    }

}

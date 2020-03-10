package by.epamtc.automation.selenium.task3.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPageTask3 {

    private WebDriver driver;

    public SearchResultsPageTask3(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='___gcse_0']/div/div/div/div[5]/div[2]/div/div/div[1]/div[1]/div[1]/div[1]/div/a")
    WebElement desiredSearchResult;

    public CalculatorPageTask3 selectDesiredSearchResult() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(desiredSearchResult));
        desiredSearchResult.click();
        return new CalculatorPageTask3(driver);
    }

}

package by.epamtc.automation.selenium.task3.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculatorPageTask3 {

    WebDriver driver;

    public CalculatorPageTask3(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='cloud-site']/devsite-iframe/iframe")
    WebElement firstFrame;

    @FindBy(xpath = "//*[@id='myFrame']")
    WebElement secondFrame;

    @FindBy(id="input_55")
    WebElement inputLineNumberOfInstances;

    @FindBy(xpath = "//*[@id='select_67']")
    WebElement choiceOfOperationSystem;

    @FindBy(xpath = "//*[@id='select_option_62']")
    WebElement desiredOperationSystem;

    public CalculatorPageTask3 fillInNumberOfInstance() {
        driver.switchTo().frame(firstFrame).switchTo().frame(secondFrame);
        inputLineNumberOfInstances.sendKeys("4");
        return this;
    }

    public CalculatorPageTask3 selectOperationSystem() {
       new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(choiceOfOperationSystem));
       choiceOfOperationSystem.click();
       new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(desiredOperationSystem));
       desiredOperationSystem.click();
        return this;
    }



}

package by.epamtc.automation.selenium.task4.page;

import by.epamtc.automation.selenium.task3.page.EstimatePageTask3;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculatorPageTask4 {

    WebDriver driver;

    public CalculatorPageTask4(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private static final String NUMBER_OF_INSTANCE = "4";

    @FindBy (xpath = "//*[@id='cloud-site']/devsite-iframe/iframe")
    WebElement firstFrame;

    @FindBy (id = "myFrame")
    WebElement secondFrame;

    @FindBy (xpath = "//*[@id='mainForm']//div[@title='Compute Engine']")
    WebElement computeEngineButton;

    @FindBy (id = "input_55")
    WebElement inputLineNumberOfInstances;

    @FindBy (id = "select_value_label_48")
    WebElement choiceOfOperationSystem;

    @FindBy (id = "select_option_57")
    WebElement desiredOperationSystem;

    @FindBy (id = "select_value_label_49")
    WebElement choiceOfMachineClass;

    @FindBy (id = "select_option_69")
    WebElement desiredMachineClass;

    @FindBy (id = "select_value_label_52")
    WebElement choiceOfInstanceType;

    @FindBy (id = "select_option_208")
    WebElement desiredInstanceType;

    @FindBy (xpath = "//md-checkbox[@aria-label='Add GPUs']")
    WebElement addGPUChexkbox;

    //отсюда не работает
    @FindBy (id = "select_value_label_326")
    WebElement choiceOfNumberOfGPUs;

    @FindBy (id = "select_option_333")
    WebElement desiredNumberOfGPUs;

    @FindBy (id = "select_value_label_327")
    WebElement choiceOfGPUType;

    @FindBy (id = "select_option_340")
    WebElement desiredGPUType;

    @FindBy (id = "select_value_label_166")
    WebElement choiceOfLocalSSD;

    @FindBy (id = "select_option_229")
    WebElement desiredLocalSSD;

    @FindBy (id = "select_value_label_53")
    WebElement choiceOfLocation;

    @FindBy (id = "select_option_177")
    WebElement desiredLocation;

    @FindBy (id = "select_value_label_54")
    WebElement choiceOfCommittedUsage;

    @FindBy (id = "select_option_87")
    WebElement desiredCommittedUsage;

    @FindBy (xpath = "//button[@aria-label = 'Add to Estimate']")
    WebElement buttonAddToEstimate;

    public CalculatorPageTask4 clickComputerEngineButton() {
        driver.switchTo().frame(firstFrame).switchTo().frame(secondFrame);
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(computeEngineButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", computeEngineButton);
        return this;
    }

    public CalculatorPageTask4 fillInNumberOfInstance() {
        inputLineNumberOfInstances.sendKeys(NUMBER_OF_INSTANCE);
        return this;
    }

    public CalculatorPageTask4 selectOperationSystem() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(choiceOfOperationSystem));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", choiceOfOperationSystem);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(desiredOperationSystem));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", desiredOperationSystem);
        return this;
    }

    public CalculatorPageTask4 selectMachineClass() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(choiceOfMachineClass));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", choiceOfMachineClass);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(desiredMachineClass));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", desiredMachineClass);
        return this;
    }

    public CalculatorPageTask4 selectInstanceType() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(choiceOfInstanceType));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", choiceOfInstanceType);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(desiredInstanceType));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", desiredInstanceType);
        return this;
    }

    public CalculatorPageTask4 selectGPUs() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(addGPUChexkbox));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addGPUChexkbox);

        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(choiceOfNumberOfGPUs));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", choiceOfNumberOfGPUs);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(desiredNumberOfGPUs));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", desiredNumberOfGPUs);

        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(choiceOfGPUType));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", choiceOfGPUType);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(desiredGPUType));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", desiredGPUType);
        return this;
    }

    public CalculatorPageTask4 selectLocalSSD() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(choiceOfLocalSSD));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", choiceOfLocalSSD);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(desiredLocalSSD));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", desiredLocalSSD);
        return this;
    }

    public CalculatorPageTask4 selectDatacenterLocation() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(choiceOfLocation));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", choiceOfLocation);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(desiredLocation));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", desiredLocation);
        return this;
    }

    public CalculatorPageTask4 selectCommittedUsage() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(choiceOfCommittedUsage));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", choiceOfCommittedUsage);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(desiredCommittedUsage));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", desiredCommittedUsage);
        return this;
    }

    public EstimatePageTask4 clickAddToEstimateButton() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(buttonAddToEstimate));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", buttonAddToEstimate);
        return new EstimatePageTask4(driver);
    }

    public EstimatePageTask4 fillInCalculatorFields() {
        clickComputerEngineButton()
                .fillInNumberOfInstance()
                .selectOperationSystem()
                .selectMachineClass()
                .selectInstanceType()
                .selectGPUs()
                .selectLocalSSD()
                .selectDatacenterLocation()
                .selectCommittedUsage()
                .clickAddToEstimateButton();
        return new EstimatePageTask4(driver);
    }
}

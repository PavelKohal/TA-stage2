package by.epamtc.automation.selenium.task3.page;

import org.openqa.selenium.JavascriptExecutor;
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

    @FindBy (xpath = "//*[@id='cloud-site']/devsite-iframe/iframe")
    WebElement firstFrame;

    @FindBy (id = "myFrame")
    WebElement secondFrame;

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

    @FindBy (xpath = "//*[@id='mainForm']/div[1]/div/md-card/md-card-content/div/div[1]/form/div[8]/div[1]/md-input-container/md-checkbox")
    WebElement addGPUChexkbox;

    @FindBy (id = "select_value_label_324")
    WebElement choiceOfNumberOfGPUs;

    @FindBy (id = "select_option_331")
    WebElement desiredNumberOfGPUs;

    @FindBy (id = "select_value_label_325")
    WebElement choiceOfGPUType;

    @FindBy (id = "select_option_336")
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

    @FindBy (xpath = "//*[@id=\"mainForm\"]/div[1]/div/md-card/md-card-content/div/div[1]/form/div[15]/button")
    WebElement buttonAddToEstimate;

    public CalculatorPageTask3 fillInNumberOfInstance() {
        driver.switchTo().frame(firstFrame).switchTo().frame(secondFrame);
        inputLineNumberOfInstances.sendKeys("4");
        return this;
    }

    public CalculatorPageTask3 selectOperationSystem() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(choiceOfOperationSystem));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", choiceOfOperationSystem);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(desiredOperationSystem));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", desiredOperationSystem);
        return this;
    }

    public CalculatorPageTask3 selectMachineClass() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(choiceOfMachineClass));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", choiceOfMachineClass);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(desiredMachineClass));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", desiredMachineClass);
        return this;
    }

    public CalculatorPageTask3 selectInstanceType() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(choiceOfInstanceType));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", choiceOfInstanceType);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(desiredInstanceType));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", desiredInstanceType);
        return this;
    }

    public CalculatorPageTask3 selectGPUs() {
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

    public CalculatorPageTask3 selectLocalSSD() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(choiceOfLocalSSD));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", choiceOfLocalSSD);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(desiredLocalSSD));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", desiredLocalSSD);
        return this;
    }

    public CalculatorPageTask3 selectDatacenterLocation() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(choiceOfLocation));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", choiceOfLocation);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(desiredLocation));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", desiredLocation);
        return this;
    }

    public CalculatorPageTask3 selectCommittedUsage() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(choiceOfCommittedUsage));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", choiceOfCommittedUsage);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(desiredCommittedUsage));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", desiredCommittedUsage);
        return this;
    }

    public EstimatePageTask3 clickAddToEstimateButton() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(buttonAddToEstimate));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", buttonAddToEstimate);
        return new EstimatePageTask3(driver);
    }
}

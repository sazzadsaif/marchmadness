package page_objects;

import command_providers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RealApr extends NavigationBar {
    private final By CalculatorTab = By.xpath("//label[text()='Calculator']");
    private final By HomePriceBox = By.name("HomeValue");
    private final By DownPaymentDollar = By.id("DownPaymentSel0");
    private final By DownPaymentBox = By.name("DownPayment");
    private final By InterestRateBox = By.name("Interest");
    private final By CalculateButton = By.name("calculate");
    private final By ActualAprRate = By.xpath("//*[@id='analysisDiv']/table/tbody/tr/td/strong[text()='Actual APR:']/../../td[2]/strong");

    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());

    public RealApr(WebDriver driver){
        super(driver);
    }
    public RealApr waitingForPageToLoad(){
        LOGGER.debug("Waiting for page to load");
         ActOn.wait(driver,CalculatorTab).waitForElementToBeVisible();
        return this;
    }
    public RealApr typingHomePrice(String value){
        LOGGER.debug("Typing Home Price " + value);
        ActOn.elementsActions(driver,HomePriceBox).setValue(value);
        return this;
    }
    public RealApr clickDownPaymentButton(){
        LOGGER.debug("Clicking Down Payment button" );
        ActOn.elementsActions(driver,DownPaymentDollar).click();
        return this;
    }
    public RealApr typingDownPaymentBox(String value){
        LOGGER.debug("Typing Down Payment Box " + value);
        ActOn.elementsActions(driver,DownPaymentBox).setValue(value);
        return this;
    }
    public RealApr typingInterestRate(String value){
        LOGGER.debug("Typing Interest Rate " + value);
        ActOn.elementsActions(driver,InterestRateBox).setValue(value);
        return this;
    }
    public RealApr clickOnTheCalculateButton(){
        LOGGER.debug("Clicking on the Calculate button");
        ActOn.elementsActions(driver,CalculateButton).click();
        return this;
    }
    public RealApr validateRate(String expectedValue){
        LOGGER.debug("Validating APR Rate is " + expectedValue);
        String actualRealAprRealRate = ActOn.elementsActions(driver,ActualAprRate).getTextValue();
        Assert.assertEquals(actualRealAprRealRate,expectedValue);
        return this;

    }
}

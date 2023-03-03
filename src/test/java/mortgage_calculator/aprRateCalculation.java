package mortgage_calculator;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class aprRateCalculation {
    private final By RatesLink = By.linkText("Rates");
    private final By RealAprLink = By.linkText("Real APR");
    private final By CalculatorTab = By.xpath("//label[text()='Calculator']");
    private final By HomePriceBox = By.name("HomeValue");
    private final By DownPaymentDollar = By.id("DownPaymentSel0");
    private final By DownPaymentBox = By.name("DownPayment");

    private final By InterestRateBox = By.name("Interest");
    private final By CalculateButton = By.name("calculate");
    private final By ActualAprRate = By.xpath("//*[@id='analysisDiv']/table/tbody/tr/td/strong[text()='Actual APR:']/../../td[2]/strong");
    WebDriver driver;
    Select select;
    @BeforeMethod
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.mortgagecalculator.org/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    public void navigateToRealAprPage(){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(RatesLink)).perform();

        driver.findElement(RealAprLink).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(CalculatorTab));


    }
    public void enterData(){

        driver.findElement(HomePriceBox).clear();
        driver.findElement(HomePriceBox).sendKeys("200000");
        driver.findElement(DownPaymentDollar).click();
        driver.findElement(DownPaymentBox).clear();
        driver.findElement(DownPaymentBox).sendKeys("15000");
        driver.findElement(InterestRateBox).clear();
        driver.findElement(InterestRateBox).sendKeys("3");
    }
    @Test
    public void calculateRealApr(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        navigateToRealAprPage();
        enterData();

        driver.findElement(CalculateButton).click();
        //3.130%
        String actualRealAprRealRate = driver.findElement(ActualAprRate).getText();
        System.out.println(actualRealAprRealRate);
        Assert.assertEquals(actualRealAprRealRate,"3.130%");
    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}

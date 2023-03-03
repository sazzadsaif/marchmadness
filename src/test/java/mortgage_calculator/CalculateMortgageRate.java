package mortgage_calculator;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.implementation.bytecode.ShiftRight;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class CalculateMortgageRate {
    private final By HomeValue = By.id("homeval");
    private final By DownPaymment = By.id("downpayment");
    private final By ClickDollarButton = By.name("param[downpayment_type]");
    private final By LoanAmount = By.id("loanamt");
    private final By InterestRate = By.id("intrstsrate");
    private final By LoanTerm = By.id("loanterm");
    private final By SelectMonth = By.name("param[start_month]");
    private final By SelectYear = By.id("start_year");
    private final By PropertyTax = By.id("pptytax");
    private final By Pmi = By.id("pmi");
    private final By HomeIns = By.id("hoi");
    private final By Hoa = By.id("hoa");
    private final By SelectLoanType = By.name("param[milserve]");
    private final By SelectBuy = By.name("param[refiorbuy]");
    private final By CalculateButton = By.name("cal");

    WebDriver driver;
    Select select;
    @BeforeMethod
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.mortgagecalculator.org/");
        driver.manage().window().maximize();
    }
    public void enterData(){
        driver.findElement(HomeValue).clear();
        driver.findElement(HomeValue).sendKeys("300000");
        driver.findElement(DownPaymment ).clear();
        driver.findElement(DownPaymment ).sendKeys("60000");
        driver.findElement(ClickDollarButton).click();
        driver.findElement(LoanAmount).clear();
        driver.findElement(LoanAmount).sendKeys("240000");
        driver.findElement(InterestRate).clear();
        driver.findElement(InterestRate).sendKeys("3");
        driver.findElement(LoanTerm).clear();
        driver.findElement(LoanTerm).sendKeys("30");

        select = new Select(driver.findElement(SelectMonth));
        select.selectByVisibleText("Mar");

        driver.findElement(SelectYear).clear();
        driver.findElement(SelectYear).sendKeys("2023");
        driver.findElement(PropertyTax).clear();
        driver.findElement(PropertyTax).sendKeys("5000");
        driver.findElement(Pmi).clear();
        driver.findElement(Pmi).sendKeys("0.5");
        driver.findElement(HomeIns).clear();
        driver.findElement(HomeIns).sendKeys("1000");
        driver.findElement(Hoa).clear();
        driver.findElement(Hoa).sendKeys("100");

        select = new Select(driver.findElement(SelectLoanType));
        select.selectByVisibleText("FHA");

        select = new Select(driver.findElement(SelectBuy));
        select.selectByVisibleText("Buy");
    }
    @Test
    public void calculateMonthlyPayment(){
        enterData();
        driver.findElement(CalculateButton).click();

        //original XPath = //h3[text()='$1,611.85']

        String expectedTotalMonthlyPayment = "1,611.85";
        String xPath = "//h3[text()='$" + expectedTotalMonthlyPayment + "']";
        //String formattedXpath = String.format("//h3[text()='$%s']",expectedTotalMonthlyPayment);

        boolean present = driver.findElement(By.xpath(xPath)).isDisplayed();

        Assert.assertTrue(present,"Total monthly payment is incorrect");
    }
    @AfterMethod
    public void closeBrowser(){
       driver.quit();
    }
}

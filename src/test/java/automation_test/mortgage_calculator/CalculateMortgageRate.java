package automation_test.mortgage_calculator;

import command_providers.ActOn;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.Home;
import utilities.DateUtils;
import utilities.ScreenCapture;
public class CalculateMortgageRate{
    WebDriver driver;
    Select select;
    @BeforeMethod
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        ActOn.browser(driver).openBrowser("https://www.mortgagecalculator.org/");
    }
    @Test
    public void calculateMonthlyPayment(){
       String[] date = DateUtils.returnNextMonth();
       new Home(driver)
               .typeHomeValue("300000")
               .typeDownPayment("60000")
               .clickDollarButton()
               .typeLoanAmount("240000")
               .typeInterestRate("3")
               .typeLoanTerm("30")
               .selectMonth(date[0])
               .typeYear(date[1])
               .typePropertyTax("5000")
               .typePmi("0.5")
               .typeHomeInsurance("1000")
               .typeHoa("100")
               .selectLoanType("FHA")
               .selectBuyOrRefi("Buy")
               .clickCalculateButton()
               .validateTotalMonthlyPayment("1,611.85");
    }
    @AfterMethod
    public void closeBrowser(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus()){
            ScreenCapture.getScreenShot(driver);
        }
            ActOn.browser(driver).closeBrowser();
        }
}



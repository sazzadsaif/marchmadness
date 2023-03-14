package automation_test.mortgage_calculator;

import command_providers.ActOn;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.Home;
import utilities.ScreenCapture;
public class aprRateCalculation {
   WebDriver driver;
    @BeforeMethod
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        ActOn.browser(driver).openBrowser("https://www.mortgagecalculator.org/");
    }
    @Test
    public void calculateRealApr(){
        new Home(driver)
                .mouseHoverToRates()
                .navigateToRealAprPage()
                .waitingForPageToLoad()
                .typingHomePrice("200000")
                .clickDownPaymentButton()
                .typingDownPaymentBox("15000")
                .typingInterestRate("3")
                .clickOnTheCalculateButton()
                .validateRate("3.130%");
    }
    @AfterMethod
    public void closeBrowser(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus()){
            ScreenCapture.getScreenShot(driver);
        }
        ActOn.browser(driver).closeBrowser();
    }

}

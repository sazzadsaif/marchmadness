package automation_test.mortgage_calculator;

import automation_test.BaseUIClass;
import org.testng.annotations.Test;
import page_objects.Home;
public class aprRateCalculation extends BaseUIClass {
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

}

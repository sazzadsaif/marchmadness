package automation_test.mortgage_calculator;

import automation_test.BaseUIClass;
import org.testng.annotations.Test;
import page_objects.Home;
import utilities.DateUtils;
public class CalculateMortgageRate extends BaseUIClass {
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

}



package page_objects;

import command_providers.ActOn;
import command_providers.AsserThat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class Home extends NavigationBar {
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

    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());

    public Home(WebDriver driver){
        super(driver);
    }
    public Home typeHomeValue(String value){
        LOGGER.debug("Typing Home Value " + value);
        ActOn.elementsActions(driver,HomeValue).setValue(value);
        return this;
    }
    public Home typeDownPayment(String value){
        LOGGER.debug("Typing Down Payment " + value);
        ActOn.elementsActions(driver,DownPaymment).setValue(value);
        return this;
    }
    public Home clickDollarButton(){
        LOGGER.debug("Clicked Dollar button");
        ActOn.elementsActions(driver,ClickDollarButton).click();
        return this;
    }
    public Home typeLoanAmount(String value){
        LOGGER.debug("Typing Loan Amount " + value );
        ActOn.elementsActions(driver,LoanAmount).setValue(value);
        return this;
    }
    public Home typeInterestRate(String value){
        LOGGER.debug("Typing Interest Rate " + value);
        ActOn.elementsActions(driver,InterestRate).setValue(value);
        return this;
    }
    public Home typeLoanTerm(String value){
        LOGGER.debug("typing Loan Term " + value);
        ActOn.elementsActions(driver,LoanTerm).setValue(value);
        return this;
    }
    public Home selectMonth(String month){
        LOGGER.debug("Select the start month " + month);
        ActOn.elementsActions(driver,SelectMonth).selectValue(month);
        return this;
    }
    public Home typeYear(String year){
        LOGGER.debug("Typing the year " + year);
        ActOn.elementsActions(driver, SelectYear).setValue(year);
        return this;
    }
    public Home typePropertyTax(String value){
        LOGGER.debug("Typing Property Tax " + value);
        ActOn.elementsActions(driver,PropertyTax).setValue(value);
        return this;
    }
    public Home typePmi(String value){
        LOGGER.debug("Typing PMI value " + value);
        ActOn.elementsActions(driver,Pmi).setValue(value);
        return this;
    }
    public Home typeHomeInsurance(String value){
        LOGGER.debug("Typing Home Insurance " + value);
        ActOn.elementsActions(driver,HomeIns).setValue(value);
        return this;
    }
    public Home typeHoa(String value){
        LOGGER.debug("Typing HOA " + value);
        ActOn.elementsActions(driver,Hoa).setValue(value);
        return this;
    }
    public Home selectLoanType(String value){
        LOGGER.debug("Selecting Loan type " + value);
        ActOn.elementsActions(driver,SelectLoanType).selectValue(value);
        return this;
    }
    public Home selectBuyOrRefi(String value){
        LOGGER.debug("Selecting " + value);
        ActOn.elementsActions(driver,SelectBuy).selectValue(value);
        return this;
    }
    public Home clickCalculateButton(){
        LOGGER.debug("Clicking on calculate button");
        ActOn.elementsActions(driver,CalculateButton).click();
        return this;
    }
    public Home validateTotalMonthlyPayment(String totalMonthlyPayment){
        LOGGER.debug("Validating total monthly payment is " + totalMonthlyPayment);
        String xPath = "//h3[text()='$" + totalMonthlyPayment + "']";
        AsserThat.elementAssertions(driver, By.xpath(xPath)).elementIsDisplayed();

        //original XPath = //h3[text()='$1,611.85']
        //String formattedXpath = String.format("//h3[text()='$%s']",expectedTotalMonthlyPayment);
        //boolean present = driver.findElement(By.xpath(xPath)).isDisplayed();
        //Assert.assertTrue(present,"Total monthly payment is incorrect")
        return this;
    }

}

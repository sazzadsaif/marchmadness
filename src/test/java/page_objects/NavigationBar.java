package page_objects;

import command_providers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBar {
    private final By RatesLink = By.linkText("Rates");
    private final By RealAprLink = By.linkText("Real APR");
    private final By MortgageCalculatorLogo = By.xpath("//img[@alt='Logo']");

    public WebDriver driver;
    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());
    public NavigationBar(WebDriver driver){
        this.driver = driver;
    }
    public NavigationBar mouseHoverToRates(){
        LOGGER.debug("Mouse Hover to rates link");
        ActOn.elementsActions(driver,RatesLink).mouseHover();
        return this;
    }
    public RealApr navigateToRealAprPage(){
        LOGGER.debug("Click on real apr link");
        ActOn.elementsActions(driver,RealAprLink).click();
        return new RealApr(driver);
    }
    public Home returnToHomePage(){
        LOGGER.debug("Click on the Mortgage calculator logo");
        ActOn.elementsActions(driver,MortgageCalculatorLogo).click();
        return new Home(driver);
    }


}

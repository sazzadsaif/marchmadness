package selenium_grid;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utilities.DriverFactory;

public class SeleniumGridChrome {
    DriverFactory dfDriver = DriverFactory.getInstance();
    @Test
    public void executeInAwsDocker() {
        dfDriver.getDriver().get("https://www.mortgagecalculator.org/");
        System.out.println(dfDriver.getDriver().getTitle());
        dfDriver.removeDriver();
    }
}

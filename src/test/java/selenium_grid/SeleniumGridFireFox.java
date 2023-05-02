package selenium_grid;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utilities.DriverFactory;
public class SeleniumGridFireFox {
    DriverFactory dfDriver = DriverFactory.getInstance();
    @Test
    public void executeInAwsDockerFirefox(){
        dfDriver.getDriver().get("https://www.cnbc.com/");
        System.out.println(dfDriver.getDriver().getTitle());
        dfDriver.removeDriver();
    }
    }



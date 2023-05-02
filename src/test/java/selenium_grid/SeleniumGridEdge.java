package selenium_grid;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utilities.DriverFactory;

public class SeleniumGridEdge {
    DriverFactory dfDriver = DriverFactory.getInstance();
    @Test
    public void awsDockerWithEdge(){
        dfDriver.getDriver().get("https://stackoverflow.com/");
        System.out.println(dfDriver.getDriver().getTitle());
        dfDriver.removeDriver();
    }

    }


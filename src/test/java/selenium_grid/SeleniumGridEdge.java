package selenium_grid;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utilities.DriverFactory;

public class SeleniumGridEdge {
    @Test
    public void awsDockerWithEdge(){
        WebDriver driver = DriverFactory.getInstance().getDriver();
        driver.get("https://stackoverflow.com/");
        System.out.println(driver.getTitle());
        driver.quit();
    }

    }


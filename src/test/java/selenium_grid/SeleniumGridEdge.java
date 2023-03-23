package selenium_grid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import utilities.DriverFactory;

import java.net.URL;

public class SeleniumGridEdge {
    @Test
    public void awsDockerWithEdge(){
        WebDriver driver = DriverFactory.getInstance().getDriver();
        driver.get("https://stackoverflow.com/");
        System.out.println(driver.getTitle());
        driver.quit();
    }

    }


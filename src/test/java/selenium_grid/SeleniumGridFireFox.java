package selenium_grid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import utilities.DriverFactory;

import java.net.URL;

public class SeleniumGridFireFox {
    @Test
    public void executeInAwsDockerFirefox(){
        WebDriver driver = DriverFactory.getInstance().getDriver();
        driver.get("https://www.cnbc.com/");
        System.out.println(driver.getTitle());
        driver.quit();
    }
    }



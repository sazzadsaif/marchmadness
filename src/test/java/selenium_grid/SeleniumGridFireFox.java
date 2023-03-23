package selenium_grid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.URL;

public class SeleniumGridFireFox {
    WebDriver driver;
    URL gridUrl;
    @Test
    public void executeInAwsDockerFirefox(){
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        try {
            gridUrl = new URL("http://18.204.221.215:4444/wd/hub");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        driver = new RemoteWebDriver(gridUrl,firefoxOptions);
        driver.get("https://www.cnbc.com/");
        System.out.println(driver.getTitle());
        driver.quit();
    }
    }



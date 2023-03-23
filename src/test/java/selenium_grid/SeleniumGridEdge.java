package selenium_grid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.URL;

public class SeleniumGridEdge {
    WebDriver driver;
    URL gridUrl;
    @Test
    public void awsDockerWithEdge(){
        EdgeOptions edgeOptions = new EdgeOptions();
        try {
            gridUrl = new URL("http://18.204.221.215:4444/wd/hub");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        driver = new RemoteWebDriver(gridUrl,edgeOptions);
        driver.get("https://stackoverflow.com/");
        System.out.println(driver.getTitle());
        driver.quit();
    }

    }


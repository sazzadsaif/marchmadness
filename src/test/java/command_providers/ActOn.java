package command_providers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ActOn {
    public static BrowserActions browser(WebDriver driver){
        return new BrowserActions(driver);
    }
    public static ElementsActions elementsActions(WebDriver driver,By locator){
        return new ElementsActions(driver,locator);
    }
    public static WaitFor wait(WebDriver driver, By locator){
        return new WaitFor(driver,locator);

    }
}

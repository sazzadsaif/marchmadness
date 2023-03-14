package command_providers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AsserThat {
    public static ElementAssertions elementAssertions(WebDriver driver, By locator){
        return new ElementAssertions(driver,locator);

    }
}

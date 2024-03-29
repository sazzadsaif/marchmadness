package command_providers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ElementAssertions {
    WebDriver driver;
    By locator;
    public ElementAssertions(WebDriver driver, By locator){
        this.driver = driver;
        this.locator = locator;
    }
    public ElementAssertions elementIsDisplayed(){
        boolean displayed = driver.findElement(locator).isDisplayed();

        Assert.assertTrue(displayed,"The expected element does not exist");
        return this;
    }
}

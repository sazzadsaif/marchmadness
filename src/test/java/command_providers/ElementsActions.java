package command_providers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.ScreenCapture;

import java.time.Duration;

public class ElementsActions {
    Logger LOGGER = LogManager.getLogger(this.getClass().getName());
    By locator;
    WebDriver driver;
        public ElementsActions(WebDriver driver, By locator){
        this.driver = driver;
        this.locator = locator;
    }
    public WebElement getElement(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement element = null;
        try{
         element = driver.findElement(locator);
        }catch (Exception e){
            ScreenCapture.getScreenShot(driver);
            LOGGER.error("Element Exception " + locator + " is " + e.getMessage() );
        }
        return element;
    }
    public ElementsActions click(){
        getElement().click();
        return this;
    }
    public ElementsActions setValue(String value){
        getElement().clear();
        getElement().sendKeys(value);
        return this;
    }
    public ElementsActions selectValue(String value){
        Select select = new Select(getElement());// getElement = driver.findElement
        select.selectByVisibleText(value);
        return this;
    }
    public ElementsActions mouseHover(){
        Actions actions = new Actions(driver);
        actions.moveToElement(getElement()).perform();
        return this;
    }
    public String getTextValue(){
        return getElement().getText();
    }
}

package Pages;

import Utils.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/***
 * The class manages repeat operations on web pages.
 */
public class BasePage {
    WebDriver driver = DriverSingleton.getDriverInstance();

    public BasePage() {
    }

    /***
     * Finds an element by locator.
     */
    private WebElement getWebElement(By locator) throws NoSuchElementException {
        return driver.findElement(locator);
    }

    /***
     * Click on the element.
     */
    public void clickElement(By locator){
        getWebElement(locator).click();
    }

    /***
     * Returns the text of an element.
     */
    public String getElementAttribute(By locator, String attribute){
        return getWebElement(locator).getAttribute(attribute);
    }

    public boolean waitForElement(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return getWebElement(locator).isDisplayed();
    }

    /***
     * Send text to the element using a locator.
     */
    public void sendKeysToElement(By locator, String text){
        getWebElement(locator).clear();
        getWebElement(locator).sendKeys(text);
    }

    /***
     * Sends text to the element using the Web element.
     */
    public void sendKeysToElement(WebElement element, String text){
        element.clear();
        element.sendKeys(text);
    }

    /***
     * Selects the wanted index from a list element.
     */
    public void selectValueFromListElement(By locator,String tagName, int index){
        WebElement listElement = getWebElement(locator);
        listElement.click();
        listElement.findElements(By.tagName(tagName)).get(index).click();
    }

    public void selectValueFromListElement(WebElement element,String tagName, int index){
        element.click();
        element.findElements(By.tagName(tagName)).get(index).click();
    }

    /***
     * Gets the child elements from a parent element by tag name.
     */
    public List<WebElement> getElementChildren(By locator, String cssSelector){
        WebElement listElement = getWebElement(locator);
        listElement.click();
        return listElement.findElements(By.cssSelector(cssSelector));
    }


}

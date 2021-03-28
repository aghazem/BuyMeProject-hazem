package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

/***
 * Home page management
 */
public class HomePage extends BasePage {
    /***
     * The class constructor.
     */
    public HomePage() {
    }

    /***
     * Search for a present using the parameters values.
     */
    public String findPresent(int budget, int region, int category) throws NoSuchElementException {
        List<WebElement> presentParameterList = getElementChildren(By.className("form"),"div[class='chosen-container']");

        // Select an option from the amount dropdown list
        selectValueFromListElement(presentParameterList.get(0),"li", budget);

        // Select an option from the area dropdown list
        selectValueFromListElement(presentParameterList.get(1),"li", region);

        // Select an option from the category dropdown list
        selectValueFromListElement(presentParameterList.get(2),"li", category);

        String findPresentValues = getElementAttribute(By.cssSelector("a[class='ui-btn']"),"href");
        clickElement(By.cssSelector("a[class='ui-btn']"));
        return findPresentValues;
    }
}

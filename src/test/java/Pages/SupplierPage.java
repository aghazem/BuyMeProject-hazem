package Pages;

import org.openqa.selenium.By;

/***
 * Home page management
 */
public class SupplierPage extends BasePage {

    /***
     * The class constructor.
     */
    public SupplierPage() {
    }

    /***
     * Input the amount of money and submit
     */
    public void inputMoneyAmount(double amount){
        waitForElement(By.cssSelector("input[data-parsley-type='number']"));
        sendKeysToElement(By.cssSelector("input[data-parsley-type='number']"), String.valueOf(amount));
        clickElement(By.cssSelector("button[gtm='בחירה']"));
    }
}

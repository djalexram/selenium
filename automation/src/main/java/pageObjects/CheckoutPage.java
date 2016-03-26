package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by ar2130 on 3/26/16.
 */
public class CheckoutPage  {
    private static WebElement element = null;

    public static void inputField(WebDriver driver, String locator, String input){
        element = driver.findElement(By.cssSelector(locator));
        element.sendKeys(input);

    }
    public static void fillOutCheckout(WebDriver driver){
        inputField(driver, UIMapper.FIRST_NAME, System.getProperty("store.fname"));
        inputField(driver, UIMapper.LAST_NAME,System.getProperty("store.lname"));
        inputField(driver, UIMapper.ADDRESS1,System.getProperty("store.address1"));
        inputField(driver, UIMapper.ZIP, System.getProperty("store.zip"));
    }
}

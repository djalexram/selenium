package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ar2130 on 3/26/16.
 */
public class CheckoutPage  {

    public static void inputField(WebDriver driver, String locator, String input){
        driver.findElement(By.cssSelector(locator)).sendKeys(input);

    }
    public static void fillOutCheckout(WebDriver driver){
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(UIMapper.FIRST_NAME)));
        inputField(driver, UIMapper.FIRST_NAME, System.getProperty("store.fname"));
        inputField(driver, UIMapper.LAST_NAME,System.getProperty("store.lname"));
        inputField(driver, UIMapper.ADDRESS1,System.getProperty("store.address1"));
        inputField(driver, UIMapper.ZIP, System.getProperty("store.zip"));
    }

    public static void clickGuestCheckout(WebDriver driver){
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.cssSelector(UIMapper.GUEST_CHECKOUT)));
        driver.findElement(By.cssSelector(UIMapper.GUEST_CHECKOUT)).click();
    }

    public static void clickDeliveryContinue(WebDriver driver){
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.cssSelector(UIMapper.DELIVERY_CONTINUE)));
        driver.findElement(By.cssSelector(UIMapper.DELIVERY_CONTINUE)).click();
    }

    public static void clickContinueToPay(WebDriver driver){
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.cssSelector(UIMapper.CONTINUE_TO_PAY)));
        driver.findElement(By.cssSelector(UIMapper.CONTINUE_TO_PAY)).click();
    }

}

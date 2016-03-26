package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by ar2130 on 3/25/16.
 */
public class StorePage {
    private static WebElement element = null;


    public static void clickMyBag(WebDriver driver){
        driver.findElement(By.cssSelector(UIMapper.MY_BAG)).click();
    }

    public static void clickCheckout(WebDriver driver){
        driver.findElement(By.cssSelector(UIMapper.CHECKOUT)).click();
    }

    public static void clickBeginCheckout(WebDriver driver){
        driver.findElement(By.cssSelector(UIMapper.BEGIN_CHECKOUT)).click();
    }

    public static void clickGuestCheckout(WebDriver driver){
        driver.findElement(By.cssSelector(UIMapper.GUEST_CHECKOUT)).click();
    }

    public static void clickDeliveryContinue(WebDriver driver){
        driver.findElement(By.cssSelector(UIMapper.GUEST_CHECKOUT)).click();
    }



}

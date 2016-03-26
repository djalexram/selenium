package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ar2130 on 3/25/16.
 */
public class StorePage {

    public static void clickMyBag(WebDriver driver){
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.cssSelector(UIMapper.MY_BAG)));
        driver.findElement(By.cssSelector(UIMapper.MY_BAG)).click();
    }

    public static void clickCheckout(WebDriver driver){
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.cssSelector(UIMapper.CHECKOUT)));
        driver.findElement(By.cssSelector(UIMapper.CHECKOUT)).click();
    }

    public static void clickBeginCheckout(WebDriver driver){
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.cssSelector(UIMapper.BEGIN_CHECKOUT)));
        driver.findElement(By.cssSelector(UIMapper.BEGIN_CHECKOUT)).click();
    }





}

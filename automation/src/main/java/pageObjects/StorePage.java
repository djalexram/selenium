package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by ar2130 on 3/25/16.
 */
public class StorePage {
    private static WebElement element = null;

    public static WebElement lnk_MyAccount(WebDriver driver){

        element = driver.findElement(By.id("account"));

        return element;

    }
}

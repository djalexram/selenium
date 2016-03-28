package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by ar2130 on 3/26/16.
 */
public class CheckoutPage {


    public static void fillOutCheckout(WebDriver driver) {
        Properties prop = new Properties();

        try {
            InputStream in = CheckoutPage.class.getResourceAsStream("/qa1.properties");
            prop.load(in);
        } catch (IOException e) {
            System.out.println("Properties file not found");
            e.printStackTrace();
        }
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(UIMapper.FIRST_NAME)));
        driver.findElement(By.cssSelector(UIMapper.FIRST_NAME)).sendKeys(prop.getProperty("store.fname"));
        driver.findElement(By.cssSelector(UIMapper.LAST_NAME)).sendKeys(prop.getProperty("store.lname"));
        driver.findElement(By.cssSelector(UIMapper.ADDRESS1)).sendKeys(prop.getProperty("store.address1"));
        driver.findElement(By.cssSelector(UIMapper.ZIP)).sendKeys(prop.getProperty("store.zip"));
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(UIMapper.DEFAULT_STATE)));
        driver.findElement(By.cssSelector(UIMapper.PHONE)).sendKeys(prop.getProperty("store.phone"));

    }

}

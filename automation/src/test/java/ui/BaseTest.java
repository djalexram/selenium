package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.UIMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ar2130 on 3/26/16.
 */
public class BaseTest {
    private static WebElement element = null;

    public static WebElement getElement(WebDriver driver, String cssPath){
        element =  driver.findElement(By.cssSelector(cssPath));
        return element;
    }

    public static void isLoading(WebDriver driver) throws InterruptedException {
        Boolean isPresent = driver.findElements(By.cssSelector(UIMapper.LOADING)).size() > 0;
        if (isPresent) {
            element = driver.findElement(By.cssSelector(UIMapper.LOADING));
            if (element.isDisplayed()) {
                Thread.sleep(3000);
            }
        }
    }



    public static String getElementText(WebDriver driver, String cssPath){
        String text =  driver.findElement(By.cssSelector(cssPath)).getText();
        return text;
    }

    public static boolean isDisplayed(WebDriver driver, String cssPath){
        return driver.findElement(By.cssSelector(cssPath)).isDisplayed();
    }

    public static List<String> getElementsText(WebDriver driver, String cssPath){
        List<String> elementTextList = new ArrayList<String>();
        List<WebElement> elementList;
        elementList = driver.findElements(By.cssSelector(cssPath));
        for(WebElement temp: elementList) {
            elementTextList.add(temp.getText());
        }
        return elementTextList;
    }

    public static void clickLink(WebDriver driver, String xPath, String menu){
        driver.findElement(By.xpath(xPath + "[contains(normalize-space(.),'" + menu + "')]")).click();
    }

    public static void clickButton(WebDriver driver, String locator){
        driver.findElement(By.cssSelector(locator)).click();
    }

}

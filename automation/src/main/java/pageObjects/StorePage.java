package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ar2130 on 3/25/16.
 */
public class StorePage {
    private static WebElement element = null;

    public static WebElement getElement(WebDriver driver, String cssPath){

        element =  driver.findElement(By.cssSelector(cssPath));

        return element;

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

}

package ui;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.StorePage;
import pageObjects.UIMapper;

import java.util.List;

/**
 * Created by ar2130 on 3/25/16.
 */
public class StoreTest {
    public WebDriver driver;
    String url = "http://www.disneystore.com/";


    @BeforeTest
    public void getUrl() {
        driver = new FirefoxDriver();
        driver.get(url);
    }

    @Test(description = "Verify product title contains search term") public void testSearch() {
        String searchText = "star wars";
        StorePage.getElement(driver, UIMapper.SEARCH_BOX).sendKeys(searchText);
        StorePage.getElement(driver, UIMapper.SEARCH_BOX).sendKeys(Keys.ENTER);
        List<String> productListTitle = StorePage.getElementsText(driver, UIMapper.PRODUCT_TITLE);
        Assert.assertTrue(productListTitle.size() > 0, "No results found");
        for (String tempText: productListTitle) {
            Reporter.log(tempText, true);
            Assert.assertTrue(tempText.matches("(?i)(.*)" + searchText + "(.*)|^" + searchText ));
        }

    }


    @AfterTest
    public void endSession() {
        driver.quit();
    }

}
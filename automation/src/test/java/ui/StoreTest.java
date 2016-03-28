package ui;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.CheckoutPage;
import pageObjects.UIMapper;

import java.util.List;

/**
 * Created by ar2130 on 3/25/16.
 */
public class StoreTest extends BaseTest {
    public WebDriver driver;
    String url = "http://www.disneystore.com/";


    @BeforeTest
    public void getUrl() {
        driver = new FirefoxDriver();
        driver.get(url);
    }

    @Test(description = "Verify product title contains search term")
    public void testSearch() {
        String searchText = "star wars";
        getElement(driver, UIMapper.SEARCH_BOX).sendKeys(searchText);
        getElement(driver, UIMapper.SEARCH_BOX).sendKeys(Keys.ENTER);
        //Get text for all product titles
        List<String> productListTitle = getElementsText(driver, UIMapper.PRODUCT_TITLE);
        Assert.assertTrue(productListTitle.size() > 0, "No results found");
        //Verify product title contains search text
        for (String tempText: productListTitle) {
            Reporter.log(tempText, true);
            Assert.assertTrue(tempText.matches("(?i)(.*)" + searchText + "(.*)|^" + searchText ));
        }

    }

    @Test(description = "Verify Checkout Process")
    public void testCheckOut() throws InterruptedException {
        String mainMenu = "Girls";
        String category = "Clothes";
        String item = "Darth Vader Lightsaber";
        clickLinkXpath(driver, UIMapper.TOP_MENU, mainMenu);
        clickLinkXpath(driver, UIMapper.CATEGORY_MENU, category);
        clickLinkXpath(driver, UIMapper.PRODUCT_TITLE_XPATH, item);
        isLoading(driver);
        //Add to cart
        clickButton(driver, UIMapper.ADD2_BAG);
        waitForLinkThenClick(driver, UIMapper.MY_BAG);
        waitForLinkThenClick(driver, UIMapper.CHECKOUT);
        Assert.assertTrue(isDisplayed(driver,UIMapper.TOP_BAG_CONTAINER));
        String header = getElementText(driver,UIMapper.TOP_BAG_CONTAINER);
        Reporter.log(header, true);
        Assert.assertTrue(header.equalsIgnoreCase("My Bag"));
        waitForLinkThenClick(driver, UIMapper.BEGIN_CHECKOUT);
        isLoading(driver);
        Assert.assertTrue(isDisplayed(driver,UIMapper.TOP_CHECKOUT_CONTAINER));
        String header2 = getElementText(driver,UIMapper.TOP_CHECKOUT_CONTAINER);
        Reporter.log(header2, true);
        Assert.assertTrue(header2.equalsIgnoreCase("Secure Checkout"));
        waitForLinkThenClick(driver, UIMapper.GUEST_CHECKOUT);
        //Enter customer info on checkout
        CheckoutPage.fillOutCheckout(driver);
        waitForLinkThenClick(driver, UIMapper.DELIVERY_CONTINUE);
        waitForLinkThenClick(driver, UIMapper.USE_ENTERED_ADDRESS);
        String url = driver.getCurrentUrl();
        Reporter.log(url, true);
        waitForElementVisible(driver,UIMapper.CREDIT_CARD);
        Assert.assertTrue(url.contains("https://"),"Page for credit card info is not secure");
    }


    @AfterTest
    public void endSession() {
        driver.quit();
    }

}
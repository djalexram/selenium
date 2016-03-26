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
import pageObjects.StorePage;
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
        List<String> productListTitle = getElementsText(driver, UIMapper.PRODUCT_TITLE);
        Assert.assertTrue(productListTitle.size() > 0, "No results found");
        for (String tempText: productListTitle) {
            Reporter.log(tempText, true);
            Assert.assertTrue(tempText.matches("(?i)(.*)" + searchText + "(.*)|^" + searchText ));
        }

    }

    @Test()
    public void testCheckOut() throws InterruptedException {
        clickLink(driver, UIMapper.TOP_MENU, "Girls");
        clickLink(driver, UIMapper.CATEGORY_MENU, "Clothes");
        clickLink(driver, UIMapper.PRODUCT_TITLE_XPATH, "Darth Vader Lightsaber");
        isLoading(driver);
        clickButton(driver, UIMapper.ADD2_BAG);
        isLoading(driver);
        StorePage.clickMyBag(driver);
        isLoading(driver);
        StorePage.clickCheckout(driver);
        Assert.assertTrue(isDisplayed(driver,UIMapper.TOP_BAG_CONTAINER));
        String header = getElementText(driver,UIMapper.TOP_BAG_CONTAINER);
        Reporter.log(header, true);
        Assert.assertTrue(header.equalsIgnoreCase("My Bag"));
        StorePage.clickBeginCheckout(driver);
        isLoading(driver);
        Assert.assertTrue(isDisplayed(driver,UIMapper.TOP_CHECKOUT_CONTAINER));
        String header2 = getElementText(driver,UIMapper.TOP_CHECKOUT_CONTAINER);
        Reporter.log(header2, true);
        Assert.assertTrue(header2.equalsIgnoreCase("Secure Checkout"));
        CheckoutPage.clickGuestCheckout(driver);
        CheckoutPage.fillOutCheckout(driver);

        CheckoutPage.clickDeliveryContinue(driver);
        isLoading(driver);
        CheckoutPage.clickContinueToPay(driver);
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
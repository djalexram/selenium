package pageObjects;

/**
 * Created by ar2130 on 3/25/16.
 */
public class UIMapper {
    public static final String SEARCH_BOX = "div#ghSearch>form>input[type='text'][class='searchTextBox rfk_sb']";
    public static final String PRODUCT_TITLE = "div.productTile>a>h3";
    public static final String PRODUCT_TITLE_XPATH = "//div[@class='productTile']/a/h3";
    public static final String TOP_MENU = "//nav[@id='mainNav']/ul/li/a";
    public static final String CATEGORY_MENU = "//div[@class='widgetContainer clearfix categoryWidget']/section[@id='charterThemeCategory']/div[@class='categoryContainer']/div[@class='categoryLink']/a";
    public static final String ADD2_BAG = "div.productAdd>a[class='button primary'][data-dojo-attach-point='action']";
    public static final String MY_BAG = "div#ghBag>a[data-contentid='miniBagHolder']";
    public static final String CHECKOUT = "a[data-dojo-attach-point='checkoutButton']";
    public static final String BEGIN_CHECKOUT = "p.checkOutButton>a[class='button primary secure']";
    public static final String GUEST_CHECKOUT = "a#guestCheckoutButton[class='button primary']";
    public static final String FIRST_NAME = "input#firstNameInput";
    public static final String LAST_NAME = "input#lastNameInput";
    public static final String ADDRESS1 = "input#address1Input";
    public static final String ZIP = "input#zipcodeInput";
    public static final String PHONE = "input#phone1Input";
    public static final String DELIVERY_CONTINUE = "button#continueToPayButton";
    public static final String TOP_BAG_CONTAINER = "div#topBagContainer>h1";
    public static final String TOP_CHECKOUT_CONTAINER = "div#topCheckoutContainer>h1";
    public static final String LOADING = "div#loaderBackground";
    public static final String CREDIT_CARD = "input#CC_cardNumber";
    public static final String USE_ENTERED_ADDRESS = "a.useEnteredAddress";
    public static final String DEFAULT_STATE = "//div[@class='customSelect cityState']/select/option[normalize-space(.)='Enter Zip Code for City/State']";
}

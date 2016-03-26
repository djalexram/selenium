package pageObjects;

/**
 * Created by ar2130 on 3/25/16.
 */
public class UIMapper {
    public static final String SEARCH_BOX = "div[id='ghSearch']>form>input[type='text'][class='searchTextBox rfk_sb']";
    public static final String PRODUCT_TITLE = "div[class='productTile']>a>h3";
    public static final String PRODUCT_TITLE_XPATH = "//div[@class='productTile']/a/h3";
    public static final String TOP_MENU = "//nav[@id='mainNav']/ul/li/a";
    public static final String CATEGORY_MENU = "//div[@class='widgetContainer clearfix categoryWidget']/section[@id='charterThemeCategory']/div[@class='categoryContainer']/div[@class='categoryLink']/a";
    public static final String ADD2_BAG = "div[class='productAdd']>a[class='button primary'][data-dojo-attach-point='action']";
    public static final String MY_BAG = "div[id='ghBag']>a[data-contentid='miniBagHolder']";
    public static final String CHECKOUT = "a[data-dojo-attach-point='checkoutButton']";
    public static final String BEGIN_CHECKOUT = "p[class='checkOutButton']>a[class='button primary secure']";
    public static final String GUEST_CHECKOUT = "a[id='guestCheckoutButton'][class='button primary']";
    public static final String FIRST_NAME = "input[id='firstNameInput']";
    public static final String LAST_NAME = "input[id='lastNameInput']";
    public static final String ADDRESS1 = "input[id='address1Input']";
    public static final String ZIP = "input[id='zipcodeInput']";
    public static final String PHONE = "input[id='phone1Input']";
    public static final String DELIVERY_CONTINUE = "button[id='continueToPayButton']";
    public static final String TOP_BAG_CONTAINER = "div[id='topBagContainer']>h1";
    public static final String TOP_CHECKOUT_CONTAINER = "div[id='topCheckoutContainer']>h1";
    public static final String LOADING = "div[id='loaderBackground']";
}

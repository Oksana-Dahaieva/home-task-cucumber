package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;;
import manager.PageFactoryManager;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 60;
    private static final String EMAIL_FAIL_ERROR = "Email fail!";
    private static final String SEARCH_ERROR = "NOTHING MATCHES YOUR SEARCH";
    private static final String HELP = "Помощь";
    private static final String SEARCH_KEYWORD = "dress";
    private static final String ERROR_MESSAGE = "Please select";
    private static final String REQUEST_FAILED = "OH NO! NOTHING MATCHES";

    private WebDriver driver;
    private HomePage homePage;
    private SignInPage signInPage;
    private ProductPage productPage;
    private SearchResultPage searchResultPage;
    private WishListPage wishListPage;
    private HelpPage helpPage;
    private PageFactoryManager pageFactoryManager;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
        homePage = pageFactoryManager.getHomePage();
        productPage = pageFactoryManager.getProductPage();
        searchResultPage = pageFactoryManager.getSearchResultPage();
        signInPage = pageFactoryManager.getSignInPage();
        helpPage = pageFactoryManager.getHelpPage();
        wishListPage = pageFactoryManager.getWishListPage();
    }

    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage.openHomePage(url);
    }

    @And("User checks header visibility")
    public void checkHeaderVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        homePage.isHeaderVisible();
    }

    @And("User checks sales header visibility")
    public void userChecksFooterVisibility() {
        homePage.isSalesHeaderVisible();
    }

    @And("User checks search field visibility")
    public void userChecksSearchFieldVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.isSearchFieldVisible();
    }

    @And("User checks cart icon visibility")
    public void userChecksCartIconVisibility() {
        homePage.isShoppingCartIconVisible();
    }

    @And("User checks wish list icon visibility")
    public void userChecksWishListIconVisibility() {
        homePage.isWishListIconVisible();
    }

    @And("User checks 'My account' button visibility")
    public void userChecksMyAccountButtonVisibility() {
        homePage.isMyAccountButtonVisible();
    }

    @When("User clicks 'My account' button")
    public void userClicksMyAccountButton() {
        homePage.clickMyAccountButton();
    }

    @Then("User checks signIn and join buttons visibility on sign in popup")
    public void userChecksLogInAndJoinButtonsVisibilityOnSignInPopup() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getMyAccountPopup());
        assertTrue(homePage.isSignInButtonVisible());
        assertTrue(homePage.isJoinButtonVisible());
    }

    @And("User clicks 'Sign In' button on popup")
    public void userClickSignInLogInButtonOnPopup() {
        homePage.clickSignInButton();
    }

    @And("User checks email field visibility")
    public void userChecksEmailFieldVisibility() {
        signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        signInPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        signInPage.isEmailAddressFieldVisible();
    }

    @And("User checks password field visibility")
    public void userChecksPasswordFieldVisibility() {
        signInPage.isPasswordFieldVisible();
    }

    @And("User checks signIn field visibility")
    public void userChecksSignInFieldVisibility() {
        signInPage.isNewSignInButtonVisible();
    }

    @Then("User checks forgot password field visibility")
    public void userChecksForgotPasswordFieldVisibility() {
        Assert.assertTrue(signInPage.isForgotPasswordFieldVisible());
    }

    @When("User makes search by keyword {string}")
    public void userMakesSearchByKeywordKeyword(final String keyword) {
        homePage.enterTextToSearchField(keyword);
    }

    @And("User clicks 'Search' button")
    public void userClicksSearchButton() throws InterruptedException {
        sleep(1500);
        homePage.clickSearchButton();
    }

    @And("User clicks selected product")
    public void userClicksSelectedProduct() {
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productPage.waitForAjaxToCompletePdp(DEFAULT_TIMEOUT);
        searchResultPage.clickSelectedProduct();
    }

    @And("User clicks on the field with size")
    public void userClicksOnTheFieldWithSize() {
        productPage.clickSelectSizeField();
    }

    @And("User clicks size")
    public void userClicksSize() {
        productPage.clickSelectSize();
    }

    @And("User clicks 'Add to cart' button on product")
    public void userClicksAddToCartButtonOnProduct() {
        productPage.clickAddToCartButton();
    }

    @And("User checks that add to cart popup visibility")
    public void userChecksThatAddToCartPopupVisible() {
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getAddToCartPopupHeader());
        assertTrue(productPage.isAddToCartPopupVisible());
    }


    @And("User checks 'View bag' button visibility")
    public void userChecksViewBagButtonVisibility() {
        productPage.isViewBagButtonVisible();
    }

    @And("User checks 'Checkout' button visibility")
    public void userChecksCheckoutButtonVisibility() {
        productPage.isCheckoutButtonVisible();
    }

    @Then("User checks that add to cart popup header is {string}")
    public void userChecksThatAddToCartPopupHeaderIsHeader(final String expectedText) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertEquals(productPage.getTitleWithQuantityOfProductText(), expectedText);
    }

    @And("User checks 'View all' button visibility")
    public void userChecksViewAllButtonVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        homePage.isViewAllButtonVisible();
    }

    @And("User clicks 'View all' button")
    public void userClicksViewAllButton() {
        homePage.clickViewAllButton();
    }

    @And("User clicks 'Add to wish list' button on the first product")
    public void userClicksAddToWishListButtonOnTheFirstProduct() {
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultPage.clickAddToWishListButton();
    }

    @And("User checks that 'Wish list' button visibility")
    public void userChecksThatWishListButtonVisibility() {
        searchResultPage.isWishListButtonVisible();
    }

    @And("User clicks 'Wish list' button")
    public void userClicksWishListButton() {
        searchResultPage.clickWishListButton();
    }

    @Then("User checks the amount of product in wish list are {string}")
    public void userChecksTheAmountOfProductInWishListAreAmountOfProducts(String expectedAmount) {
        wishListPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        wishListPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        for (WebElement webElement : wishListPage.getSearchResultsList()) {
            Assert.assertEquals(webElement.getSize(), expectedAmount);
        }
    }

    @And("User checks 'Men' button visibility")
    public void userChecksMenButtonVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.isMenCategoryButtonVisible();
    }

    @And("User clicks 'Men' button")
    public void userClicksMenButton() {
        homePage.clickMenCategoryButton();
    }

    @Then("User checks that current url contains {string} query")
    public void userChecksThatCurrentUrlContainsMenQuery(final String query) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        assertTrue(driver.getCurrentUrl().contains(query));
    }

    @And("User checks 'Change country' button visible")
    public void userChecksChangeCountryButtonVisible() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        homePage.isChangeCountryButtonVisible();
    }

    @And("User clicks 'Change country' button")
    public void userClicksChangeCountryButton() {
        homePage.clickChangeCountryButton();
    }

    @And("User clicks selected country")
    public void userClicksSelectedCountry() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getChangeCountryPopup());
        homePage.clickSelectCounty();
    }

    @Then("User clicks 'Update sittings' button")
    public void userClicksUpdateSittingsButton() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getChangeCountryPopup());
        homePage.clickUpdateSettingsButton();
    }

    @Then("User checks that language changed")
    public void userChecksThatLanguageChanged() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        Assert.assertTrue(homePage.getTextFromHelpAndSupportButton().contains(HELP));
    }

    @Then("User checks that results contains search word")
    public void userChecksThatResultsContainsSearchWord() {
        searchResultPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        for (WebElement webElement : searchResultPage.getSearchResultsList()) {
            Assert.assertTrue(StringUtils.containsIgnoreCase(webElement.getText(), SEARCH_KEYWORD));
        }
    }

    @And("User enter text in email field {string}")
    public void userEnterTextInEmailFieldKeyword(final String keyword) {
        signInPage.enterTextToEmailField(keyword);
    }

    @When("User clicks 'Sign in' button")
    public void userClicksSignInButton() {
        signInPage.clickNewSignInButton();
    }

    @Then("User checks that he cannot log in without data")
    public void userChecksThatHeCannotLogInWithoutData() {
        assertTrue(signInPage.getErrorWhileEnteringEmailText().contains(EMAIL_FAIL_ERROR));
    }

    @Then("User checks for an error message")
    public void userChecksForAnErrorMessage() {
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productPage.waitForAjaxToCompletePdp(DEFAULT_TIMEOUT);
        Assert.assertTrue(searchResultPage.getErrorHeaderText().contains(SEARCH_ERROR));
    }

    @And("User checks that an error has occurred")
    public void userChecksThatAnErrorHasOccurred() {
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        Assert.assertTrue(productPage.getErrorText().contains(ERROR_MESSAGE));
    }

    @And("User checks 'Help' button visibility")
    public void userChecksHelpButtonVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        homePage.isHelpButtonVisible();
    }

    @And("User clicks 'Help' button")
    public void useClicksHelpButton() {
        homePage.clickHelpButton();
    }

    @And("User checks search for help field visibility")
    public void userChecksSearchForHelpFieldVisibility() {
        helpPage.isSearchForHelpFieldVisible();
    }

    @And("User makes search for help by keyword {string}")
    public void userMakesSearchForHelpByKeywordKeyword(final String keyword) {
        helpPage.enterTextToSearchForHelpField(keyword);
    }

    @And("User clicks search for help button")
    public void userClicksSearchForHelpButton() {
        helpPage.clickSearchForHelpButton();
    }

    @And("User checks the search error message")
    public void userChecksTheSearchErrorMessage() {
        helpPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        Assert.assertTrue(helpPage.getSearchErrorText().contains(REQUEST_FAILED));
    }

    @After
    public void tearDown() {
        driver.close();
    }
}

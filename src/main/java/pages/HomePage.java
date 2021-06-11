package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage {

    private static final String RUSSIA_COUNTRY = "Russia";

    private Select dropdownMenu;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='_1I2c49V headroom-wrapper']")
    private WebElement header;

    @FindBy(xpath = "//div[@class='salesBanner']")
    private WebElement salesHeader;

    @FindBy(xpath = "//input[@id='chrome-search']")
    private WebElement searchField;

    @FindBy(xpath = "//a[@data-testid='miniBagIcon']")
    private WebElement shoppingCart;

    @FindBy(xpath = "//a[@data-testid='savedItemsIcon']")
    private WebElement wishList;

    @FindBy(xpath = "//div[@id='myAccountDropdown']")
    private WebElement myAccount;

    @FindBy(xpath = "//div[@id='myaccount-dropdown']")
    private WebElement myAccountPopup;

    @FindBy(xpath = "//a[text()='Sign In']")
    private WebElement sigIn;

    @FindBy(xpath = "//a[text()='Join']")
    private WebElement join;

    @FindBy(xpath = "//button[@data-testid='search-button-inline']")
    private WebElement searchButton;

    @FindBy(xpath = "//a[@class='salesBanner__cta js-buttonHover']")
    private WebElement viewAllButton;

    @FindBy(xpath = "//a[@id='men-floor']")
    private WebElement menCategoryButton;

    @FindBy(xpath = "//ul[@class='_1sqB8tC']//button[@data-testid='country-selector-btn']")
    private WebElement changeCountryButton;

    @FindBy(xpath = "//select[@id='country']")
    private WebElement selectCountry;

    @FindBy(xpath = "//div[@class='_3bZNClC']")
    private WebElement changeCountryPopup;

    @FindBy(xpath = "//button[@data-testid='save-country-button']")
    private WebElement updateSettingsButton;

    @FindBy(xpath = "//a[text()='Помощь и FAQ']")
    private WebElement helpAndSupportButton;

    @FindBy(xpath = "//a[text()='Help']")
    private WebElement helpButton;


    public void openHomePage(String url) {
        driver.get(url);
    }

    public void isHeaderVisible() {
        header.isDisplayed();
    }

    public void isSalesHeaderVisible() {
        salesHeader.isDisplayed();
    }

    public void isSearchFieldVisible() {
        searchField.isDisplayed();
    }

    public void isShoppingCartIconVisible() {
        shoppingCart.isDisplayed();
    }

    public void isWishListIconVisible() {
        wishList.isDisplayed();
    }

    public void isMyAccountButtonVisible() {
        myAccount.isDisplayed();
    }

    public void clickMyAccountButton() {
        myAccount.click();
    }

    public WebElement getMyAccountPopup() {
        return myAccountPopup;
    }

    public boolean isSignInButtonVisible() {
        return sigIn.isDisplayed();
    }

    public boolean isJoinButtonVisible() {
        return join.isDisplayed();
    }

    public void clickSignInButton() {
        sigIn.click();
    }

    public void enterTextToSearchField(final String searchText) {
        searchField.sendKeys(searchText);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void isViewAllButtonVisible() {
        viewAllButton.isDisplayed();
    }

    public void clickViewAllButton() {
        viewAllButton.click();
    }

    public void isMenCategoryButtonVisible() {
        menCategoryButton.isDisplayed();
    }

    public void clickMenCategoryButton() {
        menCategoryButton.click();
    }

    public void isChangeCountryButtonVisible() {
        changeCountryButton.isDisplayed();
    }

    public void clickChangeCountryButton() {
        changeCountryButton.click();
    }

    public void clickSelectCounty() {
        this.dropdownMenu = new Select(this.selectCountry);
        this.dropdownMenu.selectByVisibleText(RUSSIA_COUNTRY);
    }

    public WebElement getChangeCountryPopup() {
        return changeCountryPopup;
    }

    public void clickUpdateSettingsButton() {
        updateSettingsButton.click();
    }

    public String getTextFromHelpAndSupportButton() {
        return helpAndSupportButton.getText();
    }

    public void isHelpButtonVisible() {
        helpButton.isDisplayed();
    }

    public void clickHelpButton() {
        helpButton.click();
    }
}

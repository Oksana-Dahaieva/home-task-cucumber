package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SearchResultPage extends BasePage {

    private Select dropdownMenu;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='_3J74XsK']")
    private List<WebElement> selectProduct;

    @FindBy(xpath = "//section[contains(@class,'grid-backgroundWrapper__row js-dynamicBackground')]")
    private WebElement errorHeader;

    @FindBy(xpath = "//button[@data-auto-id='saveForLater']")
    private List<WebElement> addToWishListButton;

    @FindBy(xpath = "//span[@class='aECYnc0 -rhP1cz gBrrjX4 _2nHArcS']")
    private WebElement wishListButton;

    @FindBy(xpath = "//div[@data-auto-id='productTileDescription']")
    private List<WebElement> itemSearch;

    public void clickSelectedProduct() {
        selectProduct.get(0).click();
    }

    public String getErrorHeaderText() {
        return errorHeader.getText();
    }

    public void clickAddToWishListButton() {
        addToWishListButton.get(0).click();
    }

    public void isWishListButtonVisible() {
        wishListButton.isDisplayed();
    }

    public void clickWishListButton() {
        wishListButton.click();
    }

    public List<WebElement> getSearchResultsList() {
        return itemSearch;
    }

}

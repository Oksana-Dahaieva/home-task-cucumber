package pages;

import org.apache.commons.io.output.FileWriterWithEncoding;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductPage extends BasePage {

    private Select dropdownMenu;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//select[@data-id='sizeSelect']")
    private WebElement selectSizeField;

    @FindBy(xpath = "//select[@data-id='sizeSelect']")
    private WebElement selectSize;

    @FindBy(xpath = "//button[@data-test-id='add-button']")
    private WebElement addToCart;

    @FindBy(xpath = "//div[@id='minibag-dropdown']")
    private WebElement addToCartPopupHeader;

    @FindBy(xpath = "//a[@class='_1TlOB9h _2tvh469 _12h15d-']")
    private WebElement viewBagButton;

    @FindBy(xpath = "//a[@class='_1TlOB9h _2tvh469 _3olGy8t']")
    private WebElement checkoutButton;

    @FindBy(xpath = "//div[@class='_1tPq-2-']")
    private WebElement titleWithQuantityOfProduct;

    @FindBy(xpath = "//span[@id='selectSizeError']")
    private WebElement errorText;

    public void clickSelectSizeField() {
        selectSizeField.click();
    }

    public void clickSelectSize() {
        this.dropdownMenu = new Select(this.selectSize);
        this.dropdownMenu.selectByIndex(2);
    }

    public void clickAddToCartButton() {
        addToCart.click();
    }

    public boolean isAddToCartPopupVisible() {
        return addToCartPopupHeader.isDisplayed();
    }

    public WebElement getAddToCartPopupHeader() {
        return addToCartPopupHeader;
    }

    public void isViewBagButtonVisible() {
        viewBagButton.isDisplayed();
    }

    public void isCheckoutButtonVisible() {
        checkoutButton.isDisplayed();
    }

    public String getTitleWithQuantityOfProductText() {
        return titleWithQuantityOfProduct.getText();
    }

    public String getErrorText() {
        return errorText.getText();
    }
}

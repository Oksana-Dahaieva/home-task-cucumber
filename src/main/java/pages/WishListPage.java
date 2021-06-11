package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WishListPage extends BasePage {

    public WishListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='overflowFade_2Vvqr']")
    private List<WebElement> itemSearch;

    public List<WebElement> getSearchResultsList() {
        return itemSearch;
    }
}

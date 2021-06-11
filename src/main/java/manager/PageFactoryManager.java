package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {

    private WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public SignInPage getSignInPage() {
        return new SignInPage(driver);
    }

    public ProductPage getProductPage() {
        return new ProductPage(driver);
    }

    public SearchResultPage getSearchResultPage() {
        return new SearchResultPage(driver);
    }

    public WishListPage getWishListPage() {
        return new WishListPage(driver);
    }

    public HelpPage getHelpPage() {
        return new HelpPage(driver);
    }
}


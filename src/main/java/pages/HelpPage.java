package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HelpPage extends BasePage {

    public HelpPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@aria-label='Search for help']")
    private WebElement searchForHelpField;

    @FindBy(xpath = "//button[@aria-label='Search for help']")
    private WebElement searchForHelpButton;

    @FindBy(xpath = "//p[@class='NoResultsSearchList_noFoundFaqs']")
    private WebElement searchErrorText;

    public void isSearchForHelpFieldVisible() {
        searchForHelpField.isDisplayed();
    }

    public void clickSearchForHelpButton() {
        searchForHelpButton.click();
    }

    public void enterTextToSearchForHelpField(final String searchText) {
        searchForHelpField.sendKeys(searchText);
    }

    public String getSearchErrorText() {
        return searchErrorText.getText();
    }
}

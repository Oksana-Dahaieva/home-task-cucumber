package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@aria-labelledby='EmailLabel']")
    private WebElement emailAddress;

    @FindBy(xpath = "//div[@aria-labelledby='PasswordLabel']")
    private WebElement password;

    @FindBy(xpath = "//input[@class='g-recaptcha qa-submit adobeTrackedButton']")
    private WebElement newSignInButton;

    @FindBy(xpath = "//a[text()='Forgot password?']")
    private WebElement forgotPassword;

    @FindBy(xpath = "//input[@id='EmailAddress']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@class='qa-password-textbox valid']")
    private WebElement passwordField;

    @FindBy(xpath = "//span[@class='qa-email-validation field-validation-error']")
    private WebElement errorWhileEnteringEmail;


    public void isEmailAddressFieldVisible() {
        emailAddress.isDisplayed();
    }

    public void isPasswordFieldVisible() {
        password.isDisplayed();
    }

    public void isNewSignInButtonVisible() {
        newSignInButton.isDisplayed();
    }

    public void clickNewSignInButton() {
        newSignInButton.click();
    }

    public boolean isForgotPasswordFieldVisible() {
        return forgotPassword.isDisplayed();
    }

    public void enterTextToEmailField(final String enterText) {
        emailField.sendKeys(enterText);
    }

    public String getErrorWhileEnteringEmailText() {
        return errorWhileEnteringEmail.getText();
    }

}

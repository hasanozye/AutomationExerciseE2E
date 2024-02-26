package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseTest {

    public LoginPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[contains(.,'New User Signup!')]")
    private WebElement userSignUpText;
    @FindBy(xpath = "//div[@class='signup-form']//*[contains(@data-qa,'signup-name')]")
    private WebElement newName;
    @FindBy(xpath = "//div[@class='signup-form']//*[contains(@data-qa,'signup-email')]")
    private WebElement newEmail;
    @FindBy(xpath = "//div[@class='signup-form']//*[contains(@data-qa,'signup-button')]")
    private WebElement signUpButton;

    public boolean verifyTextIsLoaded() {
        waitForVisibility(userSignUpText);
        return userSignUpText.isDisplayed();
    }

    public void enterNameAndMailAddress() {
        sendKeys(newName, faker.name().fullName());
        sendKeys(newEmail, faker.internet().emailAddress());

    }

    public void clickSignupButton() {
        click(signUpButton);
    }


}

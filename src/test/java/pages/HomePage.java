package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseTest {

    public HomePage() {
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//ul[contains(@class,'navbar')]/descendant::a[contains(.,'Signup')]")
    private WebElement upperMenuSignUpLogin;

    @FindBy(xpath = "//div[contains(@class,'logo')]")
    private WebElement homePageLogo;

    @FindBy(xpath = "//li[.//a[contains(.,' Hasan')]]")
    private WebElement upNavBarLoggedInUserVerification;

    public boolean isHomePageLoaded() {
        waitForVisibility(homePageLogo);
        return homePageLogo.isDisplayed();
    }

    public void clickSignupMenu() {
        click(upperMenuSignUpLogin);
    }


}

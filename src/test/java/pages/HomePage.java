package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BaseTest {

    @FindBy(xpath = "//ul[contains(@class,'navbar')]/descendant::a[contains(.,'Signup')]")
    public WebElement upperMenuSignUpLogin;

    @FindBy(xpath = "//div[contains(@class,'logo')]")
    public WebElement homePageLogo;

    @FindBy(xpath = "//li[.//a[contains(.,' Hasan')]]")
    public WebElement upNavBarLoggedInUserVerification;

    public boolean isHomePageLoaded() {
        waitForVisibility(homePageLogo);
        return homePageLogo.isDisplayed();
    }

    public void clickSignupMenu() {
        click(upperMenuSignUpLogin);

    }


}

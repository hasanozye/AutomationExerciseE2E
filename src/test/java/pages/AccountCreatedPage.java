package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreatedPage extends BaseTest {

    public AccountCreatedPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[@data-qa='account-created']")
    private WebElement accCreatedSuccessMsg;
    @FindBy(xpath = "//div[@class='pull-right']/a[contains(@data-qa,'continue')]")
    private WebElement btnContinue;

    public boolean accCreatedMsg() {
        return accCreatedSuccessMsg.isDisplayed();
    }

    public void clickContinue() {
        click(btnContinue);
    }


}

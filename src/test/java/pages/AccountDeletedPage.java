package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountDeletedPage extends BaseTest {

    public AccountDeletedPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[@data-qa='account-deleted']")
    private WebElement accDeletedSuccessMsg;
    @FindBy(xpath = "//div[@class='pull-right']/a[contains(@data-qa,'continue')]")
    private WebElement btnContinue;

    public boolean accDeletedMsg() {
        return accDeletedSuccessMsg.isDisplayed();
    }

    public void clickContinue() {
        click(btnContinue);
    }




}

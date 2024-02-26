package stepdefs;

import io.cucumber.java.en.And;
import org.testng.Assert;
import pages.AccountCreatedPage;

public class AccountCreatedPageSteps {

    AccountCreatedPage accCreatedPage;

    public AccountCreatedPageSteps() {
        accCreatedPage = new AccountCreatedPage();
    }

    @And("Verify that ACCOUNT CREATED! is visible")
    public void verifyThatACCOUNTCREATEDIsVisible() {
        Assert.assertTrue(accCreatedPage.accCreatedMsg());
    }

    @And("Click Continue button")
    public void clickContinueButton() {
        accCreatedPage.clickContinue();
    }
}

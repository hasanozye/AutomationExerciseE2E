package stepdefs;

import io.cucumber.java.en.And;
import org.testng.Assert;
import pages.AccountDeletedPage;

public class AccountDeletedPageSteps {

    AccountDeletedPage accDeletedPage;

    public AccountDeletedPageSteps() {
        accDeletedPage = new AccountDeletedPage();
    }

    @And("Verify that ACCOUNT DELETED! is visible and click Continue button")
    public void verifyThatACCOUNTDELETEDIsVisibleAndClickContinueButton() {
        Assert.assertTrue(accDeletedPage.accDeletedMsg());
        accDeletedPage.clickContinue();
    }
}

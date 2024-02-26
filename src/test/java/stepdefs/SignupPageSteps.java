package stepdefs;

import io.cucumber.java.en.And;
import org.testng.Assert;
import pages.SignupPage;

public class SignupPageSteps {
    SignupPage signupPage;

    public SignupPageSteps() {
        signupPage = new SignupPage();
    }

    @And("Verify that ENTER ACCOUNT INFORMATION is visible")
    public void verifyThatENTERACCOUNTINFORMATIONIsVisible() {
        Assert.assertTrue(signupPage.verifyTextIsLoaded());
    }

    @And("Fill details: Title, Name, Email, Password, Date of birth")
    public void fillDetailsTitleNameEmailPasswordDateOfBirth() {
        signupPage.fillTitlePasswordDoB();
    }

    @And("Select checkbox Sign up for our newsletter!")
    public void selectCheckboxSignUpForOurNewsletter() {
        signupPage.selectNewsLetter();
    }

    @And("Select checkbox Receive special offers from our partners!")
    public void selectCheckboxReceiveSpecialOffersFromOurPartners() {
        signupPage.selectSpecialOffers();
    }

    @And("Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number")
    public void fillDetailsFirstNameLastNameCompanyAddressAddressCountryStateCityZipcodeMobileNumber() {
        signupPage.fillTheRestOfTheForm();
    }

    @And("Click Create Account button")
    public void clickCreateAccountButton() {
        signupPage.clickCreateAccountButton();
    }
}

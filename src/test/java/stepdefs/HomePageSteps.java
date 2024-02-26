package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;
import driver.Driver;
import readers.property.PropertyReader;

public class HomePageSteps {
    HomePage homePage;
    WebDriver driver;
    String url = PropertyReader.read().getProperty("url");

    public HomePageSteps() {
        driver = Driver.getDriver();
        homePage = new HomePage();
    }

    @When("Navigate to url {string}")
    public void navigateToUrlHttpAutomationExerciseCom(String url) {
        url = this.url;
        driver.get(url);
    }

    @Then("Verify that home page is visible successfully")
    public void verifyThatHomePageIsVisibleSuccessfully() {
        Assert.assertTrue(homePage.isHomePageLoaded());
    }

    @And("Click on Signup button")
    public void clickOnSignupButton() {
        homePage.clickSignupMenu();
    }

    @And("Verify that Logged in as username is visible")
    public void verifyThatLoggedInAsUsernameIsVisible() {
        Assert.assertTrue(homePage.isUserLoggedIn());

    }

    @And("Click Delete Account button")
    public void clickDeleteAccountButton() {
        homePage.deleteUserAcc();
    }
}

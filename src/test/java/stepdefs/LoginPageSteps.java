package stepdefs;
import io.cucumber.java.en.And;
import org.testng.Assert;
import pages.LoginPage;

public class LoginPageSteps {

    LoginPage loginPage;

    public LoginPageSteps() {
        loginPage = new LoginPage();
    }

    /*@And("user login with the following credentials")
    public void userLoginWithTheFollowingCredentials(DataTable table) {
        /*loginPage = new LoginPage();
        Map<String, String> datas = table.asMap();
        String email = datas.get("username") == null ? "" : datas.get("username");
        String password = datas.get("password") == null ? "" : datas.get("password");
        waitForVisibility(loginPage.loginEmail);
        sendKeys(loginPage.loginEmail, email);
        sendKeys(loginPage.loginPassword, password);
        click(loginPage.loginSignIn);*/

    @And("Verify New User Signup! is visible")
    public void verifyNewUserSignupIsVisible() {
        Assert.assertTrue(loginPage.verifyTextIsLoaded());
    }

    @And("Enter name and email address")
    public void enterNameAndEmailAddress() {
        loginPage.enterNameAndMailAddress();
    }

    @And("Click Signup button")
    public void clickSignupButton() {
        loginPage.clickSignupButton();
    }
}

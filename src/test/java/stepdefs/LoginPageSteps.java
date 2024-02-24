package stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import utils.Driver;

import java.util.Map;

public class LoginPageSteps extends BaseSteps {

    LoginPage loginPage;

    @And("user login with the following credentials")
    public void userLoginWithTheFollowingCredentials(DataTable table) {
        loginPage = new LoginPage();
        Map<String, String> datas = table.asMap();
        String email = datas.get("username") == null ? "" : datas.get("username");
        String password = datas.get("password") == null ? "" : datas.get("password");
        waitForVisibility(loginPage.loginEmail);
        sendKeys(loginPage.loginEmail, email);
        sendKeys(loginPage.loginPassword, password);
        click(loginPage.loginSignIn);


    }


}

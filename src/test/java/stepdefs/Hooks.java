package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;
import pages.LoginPage;
import utils.Driver;

public class Hooks {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = Driver.getDriver();
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);


    }

    @After
    public void tearDown() {
        if (Driver.getDriver() != null) {
            Driver.quitDriver();
        }
    }
}

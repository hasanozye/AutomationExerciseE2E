package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;
import pages.LoginPage;
import driver.Driver;

public class Hooks {

    @After
    public void tearDown() {
        if (Driver.getDriver() != null) {
            Driver.quitDriver();
        }
    }
}

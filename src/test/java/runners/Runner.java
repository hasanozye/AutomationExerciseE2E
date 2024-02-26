package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = {"src/test/resources/features/RegisterUser.feature"},
        glue = {"stepdefs"}
)
public class Runner extends AbstractTestNGCucumberTests {

}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import driver.Driver;

import java.util.Arrays;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;


    public BaseTest() {
        driver = Driver.getDriver();
        wait = Driver.getWait();

    }

    public void click(By locator) {
        WebElement webElement = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        click(webElement);

    }

    public void click(WebElement element) {
        wait.until(webDriver -> {
            try {
                element.click();
                return true;
            } catch (Exception e) {
                try {
                    new Actions(webDriver)
                            .moveToElement(element)
                            .click()
                            .perform();
                    return true;
                } catch (Exception exception) {
                    try {
                        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
                        return true;
                    } catch (Exception e1) {
                        return false;
                    }
                }
            }
        });

    }

    public void sendKeys(WebElement element, CharSequence... text) {

        wait.until(webDriver -> {
            try {
                element.clear();
                element.sendKeys(text);
                return true;
            } catch (Exception e) {
                try {
                    element.clear();
                    new Actions(webDriver)
                            .moveToElement(element)
                            .sendKeys(text)
                            .perform();
                    return true;
                } catch (Exception e2) {
                    try {
                        ((JavascriptExecutor) webDriver).executeScript("arguments[0].value()'" + Arrays.toString(text) + "'", element);
                        return true;
                    } catch (Exception e3) {
                        return false;
                    }
                }

            }
        });

    }

    public void sendKeys(By locator, CharSequence... text) {
        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        webElement.clear();
        sendKeys(webElement, text);
    }


    public void sleep(int millis) {

        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }

    public void waitForVisibility(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    public void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    public void waitForElementToBeClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


}

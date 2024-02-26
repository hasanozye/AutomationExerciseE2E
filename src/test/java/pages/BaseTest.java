package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import driver.Driver;

import java.util.ArrayList;
import java.util.Arrays;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Faker faker;


    public BaseTest() {
        driver = Driver.getDriver();
        wait = Driver.getWait();
        faker = new Faker();
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

    public void selectByVisibleText(WebElement element, String visibleTextMsg) {
        waitForVisibility(element);
        Select select = new Select(element);
        select.selectByVisibleText(visibleTextMsg);
    }

    public void scrollIntoElement(WebElement element) {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView();", element);
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

    /**
     * Closes any new tabs or windows and switches back to the original window.
     * This is for AdBlocker opening a new TY page when downloaded while UI Testing.
     *
     * @param driver the WebDriver instance
     */
    public void closeNewTabsAndSwitchBack(WebDriver driver) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        if (tabs.size() > 1) {
            // Assumes the first tab is the original one and closes all others
            for (int i = 1; i < tabs.size(); i++) {
                driver.switchTo().window(tabs.get(i)); // Switch to the new tab/window
                driver.close(); // Close the new tab/window
            }
            driver.switchTo().window(tabs.get(0)); // Switch back to the original tab/window
        }
    }

    /**
     * Alert dialog'unun belirtilen süre içinde görünüp görünmediğini kontrol eder.
     * Eğer alert görünürse, true döner.
     * @return Alert görünürse true, aksi halde false.
     */
    public boolean isAlertPresent() {
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Eğer bir alert dialog'u mevcutsa, onu kabul eder (OK tuşuna basar).
     */
    public void acceptAlertIfExists() {
        if (isAlertPresent()) {
            Alert alert = Driver.getDriver().switchTo().alert();
            alert.accept();
        }
    }

    /**
     * Eğer bir alert dialog'u mevcutsa, onu reddeder (Cancel tuşuna basar veya kapatır).
     */
    public void dismissAlertIfExists() {
        if (isAlertPresent()) {
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
        }
    }

    /**
     * Mevcut alert dialog'unun metnini alır.
     *
     * @return Alert dialog'unun metni.
     */
    public String getAlertText() {
        if (isAlertPresent()) {
            Alert alert = driver.switchTo().alert();
            return alert.getText();
        }
        return null;
    }


}

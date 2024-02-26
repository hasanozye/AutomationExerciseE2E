package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import readers.property.PropertyReader;

import java.io.File;

public class DriverFactory {

    public static WebDriver createChrome() {
        ChromeOptions options = new ChromeOptions();
        PropertyReader pr = PropertyReader.read();

        // Chrome options ekleme
        for (String s : pr.getProperty("chrome.options").split(",")) {
            options.addArguments(s.trim());
        }

        // Eklenti dosya yolunu okuma ve eklenti ekleme için
        String extensionPath = pr.getProperty("extension.path");
        if (extensionPath != null && !extensionPath.isEmpty()) {
            options.addExtensions(new File(extensionPath));
        }
        return new ChromeDriver(options);
    }

    public static WebDriver createEdge() {
        EdgeOptions options = new EdgeOptions();
        PropertyReader pr = PropertyReader.read();
        for (String s : pr.getProperty("edge.options").split(",")) {
            options.addArguments(s.trim());
        }
        return new EdgeDriver(options);
    }

    public static WebDriver createFirefox() {
        FirefoxOptions options = new FirefoxOptions();
        PropertyReader pr = PropertyReader.read();
        for (String s : pr.getProperty("firefox.options").split(",")) {
            options.addArguments(s.trim());
        }

        return new FirefoxDriver(options);
    }


}

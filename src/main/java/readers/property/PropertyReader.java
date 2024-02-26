package readers.property;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    Properties prop = new Properties();
    FileReader fileReader;
    String filePath;

    /**
     * Constructor Loads properties from a file.
     * @param fileName The name of the file to load, defaulting to "config" if not specified.
     */
    public PropertyReader(String fileName) {

        try {
            this.filePath = "src/test/resources/datafiles/" + fileName + ".properties";
            fileReader = new FileReader(filePath);
            prop.load(fileReader);
        } catch (IOException e) {
            throw new ConfigurationLoadException("Failed to load properties from file: " + filePath, e);
        }

    }

    public static PropertyReader read() {
        return read("config");
    }

    public static PropertyReader read(String fileName) {
        return new PropertyReader(fileName);
    }

    // Method to get a property value by its key
    public String getProperty(String key) {
        return this.prop.getProperty(key);
    }


}
/**
 * Custom exception to indicate issues with loading configuration.
 */
class ConfigurationLoadException extends RuntimeException {
    public ConfigurationLoadException(String message, Throwable cause) {
        super(message, cause);
    }
}
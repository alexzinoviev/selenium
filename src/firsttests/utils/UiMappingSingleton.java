package firsttests.utils;
import org.openqa.selenium.By;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UiMappingSingleton {

    /// переписать класс с паттерном SingleTon

    //TODO Maven
    public static String uiMappingFile = "src/firsttests/utils/UIMapping.properties";

    public static String getValueFromFile(String key, String fileName) throws IOException {
        Properties p = new Properties();
        try {
            p.load(new FileInputStream(fileName));
            // p.load
        } catch (IOException e) {
            throw new IllegalStateException("Incorrect file path " + e.getMessage());
        }
        return (p.getProperty(key));
    }


    public static By ui(String key) throws IOException {
        String[] partsOfLocators = getValueFromFile(key, uiMappingFile).split("\"");
        String locatorType = partsOfLocators[0];
        String locatorValue = partsOfLocators[1];


        // Return By class with appropriate method and locatorValue
        // Refactor code in Switch Case
        // save to hash map

        if (locatorType.equals("id")) {
            return By.id(locatorValue);
        } else {
            if (locatorType.equals("xpath")) {
                return By.xpath(locatorValue);
            } else {
                if (locatorType.equals("name")) {
                    return By.name(locatorValue);
                } else {
                    if (locatorType.equals("linkText")) {
                        return By.linkText(locatorValue);
                    } else {
                        if (locatorType.equals("tagName")) {
                            return By.tagName(locatorValue);
                        } else {
                            if (locatorType.equals("className")) {
                                return By.className(locatorValue);
                            } else {
                                if (locatorType.equals("cssSelector")) {
                                    return By.cssSelector(locatorValue);
                                } else {
                                    return By.partialLinkText(locatorValue);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
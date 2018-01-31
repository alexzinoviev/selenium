package firsttests.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WebElementActions {

    private WebDriver driver;

    public WebElementActions(WebDriver driver) throws IOException{
        this.driver = driver;
    }

    public void clickElement(String elementLocator) throws IOException {
        driver.findElement(UiMappingSingleton.ui(elementLocator)).click();
    }

    /**
     * Click a button
     */
    public void clickButton(String buttonLocator) throws IOException {
        driver.findElement(UiMappingSingleton.ui(buttonLocator)).click();
//        log.info("Click on Button " + buttonLocator);
    }

    /**
     * Submit a button
     */
    public void submitButton(String buttonLocator) throws IOException {
        driver.findElement(UiMappingSingleton.ui(buttonLocator)).submit();
//        log.info("Click on Button " + buttonLocator);
    }

    /**
     * Click link
     */
    public void clickLink(String linkLocator) throws IOException {
        driver.findElement(UiMappingSingleton.ui(linkLocator)).click();
//        log.info("Click on Link " + linkLocator);
    }


    /**
     * Insert value into text input HTML field
     */
    public void input(String inputLocator, String inputData) throws IOException {
        driver.findElement(UiMappingSingleton.ui(inputLocator)).clear();
        driver.findElement(UiMappingSingleton.ui(inputLocator)).sendKeys(inputData);
//        log.info("Input in " + inputLocator + ", value - " + inputData);
    }


    /**
     * Insert value into text input HTML field and Click ENTER for Field which used "Value" in the xpath expression
     */
    public void inputAndClickEnter(String inputLocator, String inputData) throws IOException {
        driver.findElement(UiMappingSingleton.ui(inputLocator)).clear();
        driver.findElement(UiMappingSingleton.ui(inputLocator)).sendKeys(inputData);
        driver.findElement(UiMappingSingleton.ui(inputLocator)).sendKeys(Keys.ENTER);
//        log.info("Input in " + inputLocator + ", value - " + inputData);
    }


    /**
     * Method is used to check that element is present on page.
     */
    public boolean isElementPresent(String elementLocator) throws IOException {
        List<WebElement> list = driver.findElements(UiMappingSingleton.ui(elementLocator));

        if (list.size() == 0) {
//            log.warn("Element _" + elementLocator + "_is NOT Present in DOM!");
            return false;
        }

        if (list.get(0).isDisplayed()) {
//            log.info("Element " + elementLocator + " is Present");
            return true;
        }
        else {
//            log.error("Element " + elementLocator + " is NOT Displayed Present!");
            return false;
        }
    }

    public boolean isAllElementsPresent(String elementLocator) throws IOException {
        List<WebElement> list = new ArrayList<>();
        list.addAll(driver.findElements(UiMappingSingleton.ui(elementLocator)));

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isDisplayed()) {
                list.get(i).equals("");
                //log.info("Element " + list.get(i) + " is present!");
            } else {
//                log.warn("Element " + list.get(i) + "_; element (" + i + ") is NOT Present!");
                return false;
            }
        }

//        log.info("Total quantity of " + elementLocator + " - " + list.size());
        return true;
    }


    /**
     * This method is used to agree messages on pop-up windows
     */
    public boolean isAlertPresent() throws IOException {
        boolean alertPresence = false;
        try {
            Alert alert = driver.switchTo().alert();
            alertPresence = true;
            alert.accept();
        } catch (NoAlertPresentException ex) {
            ex.printStackTrace();
            return alertPresence;
        }
        return alertPresence;
    }


    /**
     * This method is used to get text from pop-up windows
     */
    public String getAlertText() throws IOException {
        String alertText;
        try {
            Alert alert = driver.switchTo().alert();
            alertText = alert.getText();
            alert.accept();
//            log.info("Alert text: " + alertText);
        } catch (NoAlertPresentException ex) {
            alertText = "Alert is not found";
//            log.error("Alert is not found");
            ex.printStackTrace();
        }
        return alertText;
    }

    public void moveToElementAndClick(String moveToLocator, String clickToElement) throws IOException {
        WebElement webElement = driver.findElement(UiMappingSingleton.ui(moveToLocator));

        Actions actions = new Actions(driver);
        actions.moveToElement(webElement);
        actions.perform();  //!!! always need
        clickButton(clickToElement);

//        log.info("moved To Element " + moveToLocator + "and clicked on" + clickToElement);
    }

    /**
     *Method#1 for refresh page
     */
    public void refreshPage() throws IOException {
        driver.navigate().refresh();
//        log.info("Refresh page performed");
    }

    /**
     *Methods for pressing the keypad buttons
     */
    public void pressSpaceKey(String inputLocator) throws IOException {
        driver.findElement(UiMappingSingleton.ui(inputLocator)).sendKeys(Keys.SPACE);
//        log.info("Space clicked on " + inputLocator);
    }

    public void pressEnterKey(String inputLocator) throws IOException {
        driver.findElement(UiMappingSingleton.ui(inputLocator)).sendKeys(Keys.ENTER);
//        log.info("Enter clicked on " + inputLocator);
    }

    public void pressESCAPEKey(String inputLocator) throws IOException {
        driver.findElement(UiMappingSingleton.ui(inputLocator)).sendKeys(Keys.ESCAPE);
//        log.info("Escape clicked on " + inputLocator);
    }

    public void pressPageUp(String inputLocator) throws IOException {
        driver.findElement(UiMappingSingleton.ui(inputLocator)).sendKeys(Keys.PAGE_UP);
//        log.info("PageUp clicked on " + inputLocator);
    }


    /**
     * This method is used to do Focus to Element And Click
     * Use Actions class
     */
    public void doFocusToElementAndClick(String focusElementLocator, String elementLocator) throws IOException {
        new Actions(driver).moveToElement(getElement(focusElementLocator)).perform();
//        log.info("Focus in to element" + focusElementLocator);
        driver.switchTo();
        if (isElementPresent(elementLocator)) {
            clickButton(elementLocator);
        }
    }


    public WebElement getElement(String elementLocator) throws IOException {
        return driver.findElement(UiMappingSingleton.ui(elementLocator));
    }

    public List<WebElement> getElements(String elementsLocator) throws IOException {
        return driver.findElements(UiMappingSingleton.ui(elementsLocator));
    }


    public String getElementText(String elementsLocator) throws IOException {
        return driver.findElement(UiMappingSingleton.ui(elementsLocator)).getText();
    }

}

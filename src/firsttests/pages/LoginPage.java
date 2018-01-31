package firsttests.pages;

import firsttests.utils.WebElementActions;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class LoginPage {

    WebElementActions web;

    public LoginPage (WebDriver driver) throws IOException {
        web = new WebElementActions(driver);
    }

    public void inputUserEmail(String inputData) throws IOException {
        web.input("login.page.email", inputData);
    }

    public void inputUserPassword(String inputData) throws IOException {
        web.input("login.page.password", inputData);
    }

    public void clickLoginButton() throws IOException {
        web.clickButton("login.page.login.button");
    }

    public void errorMessage() throws  IOException {
        String errorTextMessage = web.getElementText("login.page.error.message");
        System.out.println("Error message is: " + errorTextMessage);
    }

    public void requiredEmailMessage() throws IOException {
        boolean isPresent = web.isElementPresent("login.page.required.email");
        System.out.println("Required email alert is present: " + isPresent);
        if (isPresent) {
            String errorTextMessage = web.getElementText("login.page.required.email");
            System.out.println("Error text message: " + errorTextMessage);
        }
    }

    public void requiredPasswordMessage() throws IOException {
        boolean isPresent = web.isElementPresent("login.page.required.password");
        System.out.println("Required password alert is present: " + isPresent);
        if (isPresent) {
            String errorTextMessage = web.getElementText("login.page.required.password");
            System.out.println("Error text message: " + errorTextMessage);
        }
    }



//    public void errorPopup() throws IOException {
//        boolean isPresent = web.isElementPresent("login.page.error.popup");
//        System.out.println("Popup appeared " + isPresent);
//
//        if (isPresent) {
//            String popupErrorMessage = web.getElementText("login.page.error.popup");
//            System.out.println("Error message is:" + popupErrorMessage);
//        }
//    }
}

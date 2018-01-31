package firsttests.pages;

import firsttests.utils.WebElementActions;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class RegisterPage {

    WebElementActions web;

    public RegisterPage (WebDriver driver) throws IOException {
        web = new WebElementActions(driver);
    }


    public void inputUserFirstName(String firstName) throws IOException {
        web.input("reg.page.first.name", firstName);
    }

    public void inputUserLastName(String lastName) throws IOException {
        web.input("reg.page.last.name", lastName);
    }

    public void inputUserEmail(String userEmail) throws IOException {
        web.input("reg.page.email", userEmail);
    }

    public void inputUserPassword(String userPassword) throws IOException {
        web.input("reg.page.password", userPassword);
    }

    public void inputUserConfirmPassword(String userConfirmPassword) throws IOException {
        web.input("reg.page.confirm.password", userConfirmPassword);
    }

    public void submitRegisterButton() throws IOException {
        web.clickButton("reg.page.register.button");
    }


}

package firsttests.pages;

import firsttests.utils.WebElementActions;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class HomePage {

    WebElementActions web;

    public HomePage (WebDriver driver) throws IOException  {
        web = new WebElementActions(driver);
    }

    public void clickAccountButton() throws IOException {
        web.clickButton("home.page.account.button");
    }


    public void clickLoginButton() throws IOException  {
        web.clickButton("home.page.login.button");
    }

    public void clickRegisterButton() throws IOException {
        web.clickButton("home.page.registration.button");
    }

//    public void loggedUserNameControl() throws IOException {
////        web.getElement(".//span[contains(@class,'leftBtn')]");
//        String text = web.getElementText("home.page.logged.username.control");
//        System.out.println("Logged user name is: " + text);
//    }

//    public void userLogout() throws IOException {
//        web.clickButton("home.page.logged.username.control.menu");
//        web.clickButton("home.page.logout.button");
//    }

}

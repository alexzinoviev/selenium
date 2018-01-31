package firsttests.pages;

import firsttests.utils.WebElementActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class DashBoardPage {

    WebElementActions web;

    public DashBoardPage (WebDriver driver) throws IOException {
        web = new WebElementActions(driver);
    }

    public void loggedUserName() throws IOException {
        String text = web.getElementText("dashboard.page.hello.message");
        System.out.println("Welcome message: " + text);
    }



    //    public void loggedUserNameControl() throws IOException {
////        web.getElement(".//span[contains(@class,'leftBtn')]");
//        String text = web.getElementText("home.page.logged.username.control");
//        System.out.println("Logged user name is: " + text);
//    }

}

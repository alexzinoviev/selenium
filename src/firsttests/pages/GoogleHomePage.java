package firsttests.pages;

import firsttests.utils.WebElementActions;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class GoogleHomePage {

    private WebElementActions web;
    private static Logger LOG = Logger.getLogger(GoogleHomePage.class);


    public GoogleHomePage(WebDriver driver) throws IOException {
        web = new WebElementActions(driver);
    }


    public void inputSomeValue(String value) throws IOException {
        web.input("google.search.field", value);
        LOG.info("In google search field inputed fvalue " + value);
    }


    public void submitSearchButton() throws IOException {
        web.clickButton("google.search.button");
    }
}

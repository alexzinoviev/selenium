package firsttests.tests;

import firsttests.pages.*;
import firsttests.utils.UiMappingSingleton;
import firsttests.utils.WebElementActions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.fail;

public class FirstSelTest {
    private WebDriver driver;
    private WebElementActions web;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();



    @Before // называется фикстура
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "/Users/oleksandrzinoviev/Downloads/geckodriver");
        driver = new FirefoxDriver();
        web = new WebElementActions(driver);
        baseUrl = "http://magento-demo.lexiconn.com";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        UiMappingSingleton.getInstance();
    }

//
//    @Test
//    public void googleTest() throws Exception {
//        driver.get("http://google.com.ua");
//        GoogleHomePage googleHomePage = new GoogleHomePage(driver);
//        googleHomePage.inputSomeValue("Torgoviy dom");
//        googleHomePage.submitSearchButton();
//    }


    @Test
    public void incorrectLoginCredentialsTest() throws Exception {
        driver.get(baseUrl);

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        homePage.clickAccountButton();
        homePage.clickLoginButton();
        loginPage.inputUserEmail("assds@test.com");
        loginPage.inputUserPassword("assdd1");
        loginPage.clickLoginButton();
        loginPage.errorMessage();

//        boolean isErrorPopupDisplayed = isElementPresent(By.cssSelector(".ial-err"));
//        if (isErrorPopupDisplayed) {
//            WebElement errorPopup = driver.findElement(By.cssSelector(".ial-err"));
//            String popupText = errorPopup.getText();
//            boolean compareTextValue = INCORRECT_LOGIN_ERROR.equals(popupText);
//            if (compareTextValue) {
//                System.out.println("Pass Text on popup: " + popupText);
//            } else throw new Exception("Failed. Incorrect message displayed" + popupText);
//        } else throw new Exception("Error popup doesn't appered");

    }


    @Test
    public void emptyLoginCredentialsTest() throws Exception {
        driver.get(baseUrl);

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        homePage.clickAccountButton();
        homePage.clickLoginButton();
        loginPage.inputUserEmail("");
        loginPage.inputUserPassword("");
        loginPage.clickLoginButton();
        loginPage.requiredEmailMessage();
        loginPage.requiredPasswordMessage();

//        boolean isErrorPopupDisplayed = isElementPresent(By.cssSelector(".ial-err"));
//        if (isErrorPopupDisplayed) {
//            WebElement errorPopup = driver.findElement(By.cssSelector(".ial-err"));
//            String popupText = errorPopup.getText();
//            boolean compareTextValue = EMPTY_LOGIN_ERROR.equals(popupText);
//            if (compareTextValue) {
//                System.out.println("Pass. Text on popup: " + popupText);
//            } else throw new Exception("Failed. Incorrect message displayed");
//        } else throw new Exception("Error popup doesn't appered");
    }

    @Test
    public void emptyLoginEmailTest() throws Exception {
        driver.get(baseUrl);

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        homePage.clickAccountButton();
        homePage.clickLoginButton();
        loginPage.inputUserEmail("");
        loginPage.inputUserPassword("12345678");
        loginPage.clickLoginButton();
        loginPage.requiredEmailMessage();
    }


    @Test
    public void emptyLoginPasswordTest() throws Exception {
        driver.get(baseUrl);

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        homePage.clickAccountButton();
        homePage.clickLoginButton();
        loginPage.inputUserEmail("myemail1@email.com");
        loginPage.inputUserPassword("");
        loginPage.clickLoginButton();
        loginPage.requiredPasswordMessage();
    }



    @Test
    public void correctLoginCredentialsTest() throws Exception {
        driver.get(baseUrl);

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        DashBoardPage dashBoardPage = new DashBoardPage(driver);
        homePage.clickAccountButton();
        homePage.clickLoginButton();
        loginPage.inputUserEmail("myemail1@email.com");
        loginPage.inputUserPassword("12345678");
        loginPage.clickLoginButton();
        dashBoardPage.loggedUserName();
    }


//    @Test
//    public void logoutTest() throws Exception {
//        driver.get(baseUrl);
//
//        HomePage homePage = new HomePage(driver);
//        LoginPage loginPage = new LoginPage(driver);
//        homePage.clickLoginButton();
//        loginPage.inputUserLogin("testlogin_alex");
//        loginPage.inputUserPassword("12345678");
//        loginPage.clickLoginButton();
//        homePage.loggedUserNameControl();
//        homePage.userLogout();
//    }


    @Test
    public void userRegisterTest() throws Exception {
        driver.get(baseUrl);
        HomePage homePage = new HomePage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        DashBoardPage dashBoardPage = new DashBoardPage(driver);
        homePage.clickAccountButton();
        homePage.clickRegisterButton();

        registerPage.inputUserFirstName("Fname111");
        registerPage.inputUserLastName("LName111");
        registerPage.inputUserEmail("myemail111@email.com");
        registerPage.inputUserPassword("12345678");
        registerPage.inputUserConfirmPassword("12345678");
        registerPage.submitRegisterButton();
        dashBoardPage.loggedUserName();
//        Thread.sleep(1000000);

    }



    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
package firsttests.tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
        LoginTest.class,
        RegisterTest.class
}
)

public class TestSuit {
    @BeforeClass
    public static void suitSetUp() {
        System.out.println("Here need to add run of browser etc");
    }

    @AfterClass
    public static void suitTearDown() {
        System.out.println("here need to add quit from browser");
    }
}

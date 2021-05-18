package scripts;

import base.BaseTests;
import org.testng.annotations.Test;

public class LogInTests extends BaseTests {

    @Test
    public void loginToOneHeathCare() throws InterruptedException {
        homePage.
                clickOnSignIn().
                fillLogInForm("linkdevops","April2021").
                logOut();
    }
}

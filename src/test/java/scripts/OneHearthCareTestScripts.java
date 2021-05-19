package scripts;

import base.BaseTests;
import org.testng.annotations.Test;

public class OneHearthCareTestScripts extends BaseTests {

    @Test(priority = 1)
    public void loginToOneHeathCare() throws InterruptedException {
        homePage.
                clickOnSignIn().
                fillLogInForm("linkdevops","April2021"); }

    @Test(priority = 2)
    public void verifyEligibilityBenefits() throws InterruptedException {
        homePage.navigateToUnitedHeathCarePage().
                clickOnEligibilityTab().
                    fillEligibilityBenefitsForm("74971868900","07/20/1987","01/01/2020").
                clickOnEligibility().
                                    eligibilityDetailsShouldVisible();

    }
}

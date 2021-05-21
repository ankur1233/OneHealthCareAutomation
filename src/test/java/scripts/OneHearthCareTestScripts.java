package scripts;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Locale;

public class OneHearthCareTestScripts extends BaseTests {

    String userName ="Bryan Lacouture".toLowerCase().trim();
    String groupId ="1058476".toLowerCase().trim();

    @Test(priority = 1,enabled = true)
    public void loginToOneHeathCare() throws InterruptedException {
        homePage.
                clickOnSignIn().
                fillLogInForm("linkdevops","April2021"); }

    @Test(priority = 2,dependsOnMethods = "loginToOneHeathCare")
    public void verifyEligibilityBenefits() throws InterruptedException {
        homePage.navigateToUnitedHeathCarePage().
                clickOnEligibilityTab().
                    fillEligibilityBenefitsForm("74971868900","07/20/1987","01/01/2020").
                clickOnEligibility().
                                    eligibilityDetailsShouldVisible();
    }


    @Test(priority = 3,dependsOnMethods = "verifyEligibilityBenefits")
    public void verifyUserDetails() throws InterruptedException {
        homePage.clickOnViewIDCard().
                memberCardShouldBeVisible().clickOnClose();

        Assert.assertEquals(homePage.getUerName(),userName);


        Assert.assertEquals(homePage.getGroupID(),groupId);

        Assert.assertTrue(homePage.isBenefitsTabPresent());

    }

    @Test(priority = 4)
    public void verifyCirrusMemberIdName() throws InterruptedException {
        homePage.clickOnPolicesTab().clickOnViewIDCard().
                memberCardShouldBeVisible().clickOnClose();

        Assert.assertEquals(homePage.getUerName(),userName);


        Assert.assertEquals(homePage.getGroupID(),groupId);

        Assert.assertTrue(homePage.isBenefitsTabPresent());

    }

    @Test(priority = 5)
    public void verifyCosmosmeDicaHealthFlorida() throws InterruptedException {
        homePage.clickOnPolicesTab().clickOnViewIDCard().
                memberCardShouldBeVisible().clickOnClose();

        Assert.assertEquals(homePage.getUerName(),userName);


        Assert.assertEquals(homePage.getGroupID(),groupId);

        Assert.assertTrue(homePage.isBenefitsTabPresent());

    }

    @Test(priority = 6)
    public void verifyCosmosMemberSearch() throws InterruptedException {
        homePage.clickOnPolicesTab().clickOnViewIDCard().
                memberCardShouldBeVisible().clickOnClose();

        Assert.assertEquals(homePage.getUerName(),userName);


        Assert.assertEquals(homePage.getGroupID(),groupId);

        Assert.assertTrue(homePage.isBenefitsTabPresent());

    }

    @Test(priority = 7)
    public void verifyCosmosTieredBenefit() throws InterruptedException {
        homePage.clickOnPolicesTab().clickOnViewIDCard().
                memberCardShouldBeVisible().clickOnClose();

        Assert.assertEquals(homePage.getUerName(),userName);


        Assert.assertEquals(homePage.getGroupID(),groupId);

        Assert.assertTrue(homePage.isBenefitsTabPresent());

    }


    @Test(priority = 8)
    public void cosmosDelegateMemberIdDoB() throws InterruptedException {
        homePage.clickOnPolicesTab().clickOnViewIDCard().
                memberCardShouldBeVisible().clickOnClose();

        Assert.assertEquals(homePage.getUerName(),userName);


        Assert.assertEquals(homePage.getGroupID(),groupId);

        Assert.assertTrue(homePage.isBenefitsTabPresent());

    }

    @Test(priority = 9)
    public void verifyCSPFacetsMemberIdDoB() throws InterruptedException {
        homePage.clickOnPolicesTab().clickOnViewIDCard().
                memberCardShouldBeVisible().clickOnClose();

        Assert.assertEquals(homePage.getUerName(),userName);


        Assert.assertEquals(homePage.getGroupID(),groupId);

        Assert.assertTrue(homePage.isBenefitsTabPresent());

    }
    @Test(priority = 10)
    public void verifyNiceMemberIdDob() throws InterruptedException {
        homePage.clickOnPolicesTab().clickOnViewIDCard().
                memberCardShouldBeVisible().clickOnClose();

        Assert.assertEquals(homePage.getUerName(),userName);


        Assert.assertEquals(homePage.getGroupID(),groupId);

        Assert.assertTrue(homePage.isBenefitsTabPresent());

    }

    @Test(priority = 11)
    public void verifyNetMemberSearch() throws InterruptedException {
        homePage.clickOnPolicesTab().clickOnViewIDCard().
                memberCardShouldBeVisible().clickOnClose();

        Assert.assertEquals(homePage.getUerName(),userName);


        Assert.assertEquals(homePage.getGroupID(),groupId);

        Assert.assertTrue(homePage.isBenefitsTabPresent());

    }



}

package pages;

import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Page;

import java.util.List;


import static com.microsoft.playwright.Page.WaitForSelectorOptions.State.ATTACHED;
import static com.microsoft.playwright.Page.WaitForSelectorOptions.State.DETACHED;

public class HomePage {

    private Page page;

    private String logInBtn = "xpath=//span[text()='Sign in with One Healthcare ID']";
    private String userName="id=userNameId_input";
    private  String passwordFiled = "id=passwdId_input";
    private String logInFormBtn = "xpath=//button[text()='Log in']";
    private  String signBtn = "id=SignIn";

    private String menu = "xpath=//a[@title='Menu']";
    private String signOut = "xpath=//span[text()='Sign Out']";

    private String UnitedHeathCareBtn = "id=action-button";
    private  String eligibility = "xpath=//div[text()='Eligibility']";

    private String memberID = "id=eligibility-memberid-input";
    private String dob = "id=eligibility-dateofbirth-input";
    private String elbStartDate = "id=startdate-input";
    private String elbBtn = "id=submit-search-button";

    private String elbDetailsPage = "//h1[text()='Eligibility Details']";



    public HomePage(Page page){
        this.page = page;
    }


    public HomePage eligibilityDetailsShouldVisible() throws InterruptedException {
        page.waitForSelector(elbDetailsPage,new Page.WaitForSelectorOptions().withState(ATTACHED));
        Thread.sleep(2000);
        return this;
    }

    public HomePage clickOnSignIn() throws InterruptedException {
        page.click(logInBtn);
        page.waitForSelector(userName,new Page.WaitForSelectorOptions().withState(ATTACHED));
        //page.wait(5000);
        return this;
    }


    public HomePage navigateToUnitedHeathCarePage() throws InterruptedException {
        Thread.sleep(7000);
        Frame c=  page.frameByUrl("https://apps.linkhealth.com/seamless-digital-tile/index.html");
        Thread.sleep(1000);
        if(c!=null){
            c.click(UnitedHeathCareBtn);
            page.waitForSelector(memberID,new Page.WaitForSelectorOptions().withState(ATTACHED));

        }
        Thread.sleep(2);
        System.out.println("Tets");
           return this;
    }

    public HomePage clickOnEligibilityTab() throws InterruptedException {
        page.waitForSelector(eligibility,new Page.WaitForSelectorOptions().withState(ATTACHED));
        page.click(eligibility);
        return this;
    }

    public HomePage fillEligibilityBenefitsForm(String a, String b, String c) throws InterruptedException {

        //page.waitForSelector(elbDate,new Page.WaitForSelectorOptions().withState(ATTACHED));
        Thread.sleep(2000);
        page.fill(memberID, a);
        Thread.sleep(1000);
        page.fill(dob,b);
        Thread.sleep(1000);
        page.fill(elbStartDate,c);
        Thread.sleep(1000);


        return this;
    }

    public HomePage clickOnEligibility() throws InterruptedException {
        //Thread.sleep(2000);
        page.click(elbBtn);
        page.waitForSelector(elbDetailsPage,new Page.WaitForSelectorOptions().withState(ATTACHED));
        return this;
    }



    public HomePage fillLogInForm(String a, String b) throws InterruptedException {

        page.fill(userName, a);
        page.fill(passwordFiled,b);
        page.click(signBtn);
        Thread.sleep(8000);
        page.waitForSelector(menu,new Page.WaitForSelectorOptions().withState(ATTACHED));
        return this;
    }


    public HomePage logOut() throws InterruptedException {
        page.click(menu);
        page.waitForSelector(signOut,new Page.WaitForSelectorOptions().withState(ATTACHED));
        page.click(signOut);
        Thread.sleep(2000);
        return this;

    }


}
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
    private String cardDetails = "//strong[text()='View ID Card']";
    private String benifitCard = "//button[@data-testid='benefits-accordion-header']";
    //private String benefitsTab = "//button[text()='Detailed Benefits']";
    private String patientDemographics = "//strong[text()='Patient Demographics']";
    private String getPatientDemographicsTab = "//li[@data-testid='patient-demographics']";
    private String patientName = "//h4[text()='Name']/following-sibling::b";
    private String groupID = "//h4[text()='Group']/following-sibling::p";
    private String  policies = "//button[@data-testid='policies-accordion-header']";
    private String policiesTab = "//li[@data-testid='policies']";
    private String  close  = "//button[@id='modal-close-button']";
    private String cardIDPopUp = "//div[text()='Member ID Cards']";
    private String benefitsTab = "//li[@data-testid='benefits']";



    public HomePage(Page page){
        this.page = page;
    }

    public HomePage clickOnPolicesTab() throws InterruptedException {
        Thread.sleep(2000);
        page.click(policiesTab);
        page.click(policies);
        return this;
    }

    public HomePage clickOnViewIDCard() throws InterruptedException {

        page.click(cardDetails);
        page.waitForSelector(cardIDPopUp,new Page.WaitForSelectorOptions().withState(ATTACHED));

        Thread.sleep(2000);
        return this;
    }

    public HomePage clickOnClose() throws InterruptedException {

        page.click(close);
        return this;
    }

    public boolean isBenefitsTabPresent(){
        page.click(benefitsTab);
        return page.isVisible(benifitCard);
    }


    public String  getUerName(){
        page.click(getPatientDemographicsTab);
        page.click(patientDemographics);
        return  page.textContent(patientName).toLowerCase().trim();

    }

    public String  getGroupID(){
        page.click(policies);
        page.click(policiesTab);
        return  page.textContent(groupID).toLowerCase().trim();

    }

    public HomePage memberCardShouldBeVisible() throws InterruptedException {
        page.waitForSelector(cardIDPopUp,new Page.WaitForSelectorOptions().withState(ATTACHED));
        page.isVisible(cardIDPopUp);
        //page.click(close);
        return this;
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
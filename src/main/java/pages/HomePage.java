package pages;

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



    public HomePage(Page page){
        this.page = page;
    }

    public HomePage clickOnSignIn() throws InterruptedException {
        page.click(logInBtn);
        page.waitForSelector(userName,new Page.WaitForSelectorOptions().withState(ATTACHED));
        //page.wait(5000);
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
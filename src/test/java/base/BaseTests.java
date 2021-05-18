package base;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.HomePage;

public class BaseTests {

    private Browser browser;
    protected HomePage homePage;

    @BeforeClass
    @Parameters({"URL"})
    public void setUp(String url){
        //Open a browser (supports Chromium (Chrome, Edge), Firefox, and Webkit (Safari))
        browser = Playwright
                .create()
                .chromium()
                .launch(new BrowserType.LaunchOptions().withHeadless(false));

        //A single browser tab
        Page page = browser.newPage();
        page.navigate(url);
        homePage = new HomePage(page);
    }

    @AfterClass
    public void tearDown(){
        browser.close();
    }
}
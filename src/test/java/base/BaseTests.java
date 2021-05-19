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
        //browser.newPage().viewportSize();

        //A single browser tab

        Page page = browser.newPage();
        //page.viewportSize(1920,1080);
        //page.setViewportSize(1920,1080);
        page.navigate(url);
        homePage = new HomePage(page);
    }

    @AfterClass
    public void tearDown(){
        browser.close();
    }
}
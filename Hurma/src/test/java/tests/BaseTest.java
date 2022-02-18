package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Before;
import pages.LoginPage;
import utils.ResourcesUtils;

public class BaseTest {

    public LoginPage loginPage = new LoginPage();

    @Before
    public void setUp() throws Exception {
        Selenide.open(ResourcesUtils.getResources("configs","mainUrl"));
        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadStrategy = "none";
        Configuration.timeout = Long.parseLong(ResourcesUtils.getResources("configs","timeout"));
        loginPage
                .enterEmail(ResourcesUtils.getResources("configs","email"))
                .enterPassword(ResourcesUtils.getResources("configs","password"))
                .clickSubmit();

    }

    //@After
    //public void tearDown(){
    //    Selenide.closeWebDriver();
    //}
}

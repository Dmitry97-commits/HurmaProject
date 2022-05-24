package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.testng.ScreenShooter;
import org.testng.annotations.*;
import pages.LoginPage;
import utils.ResourcesUtils;

public class BaseTest {

    public LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void setUp() throws Exception {
        Selenide.open(ResourcesUtils.getResources("configs","mainUrl"));
        Configuration.timeout = Long.parseLong(ResourcesUtils.getResources("configs","timeout"));
        Configuration.holdBrowserOpen = true;
        loginPage
                .enterEmail(ResourcesUtils.getResources("configs","email"))
                .enterPassword(ResourcesUtils.getResources("configs","password"))
                .clickSubmit();
    }

    @AfterMethod
    public void tearDown(){
        Selenide.closeWebDriver();
    }
}

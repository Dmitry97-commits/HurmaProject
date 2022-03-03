package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeClass;
import pages.LoginPage;
import pages.MainPage;
import resources.TestData;
import utils.RandomUtils;
import utils.ResourcesUtils;

public class EmailBaseTest {

    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();
    String randomStr = RandomUtils.RandomString(10);

    @BeforeClass
    public void setUp() throws Exception {
        Configuration.holdBrowserOpen = true;
        Selenide.open(ResourcesUtils.getResources("configs","mainUrl"));
        Configuration.timeout = Long.parseLong(ResourcesUtils.getResources("configs","timeoutForEmail"));
        loginPage
                .enterEmail(ResourcesUtils.getResources("configs","email"))
                .enterPassword(ResourcesUtils.getResources("configs","password"))
                .clickSubmit();
            mainPage
                    .clickToTheCompanyTab()
                    .clickCreateButton()
                    .clickToTheRespHr()
                    .selectRole(TestData.admin)
                    .enterName(String.format("TestEmail %s", RandomUtils.RandomInt(10)))
                    .enterEmail(String.format("hurmatest4+%s@gmail.com",RandomUtils.RandomString(3)))
                    .enterResponsible(randomStr)
                    .selectDateForTrainee()
                    .clickSubmitButton()
                    .clickEllipsis()
                    .clickSendAccess()
                    .clickOk();

    }

}

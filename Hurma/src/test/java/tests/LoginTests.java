package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import listener.ListenerAllure;
import org.jsoup.Jsoup;
import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import resources.TestData;
import utils.ParseUtils;
import utils.RandomUtils;
import utils.ResourcesUtils;
import java.util.List;

import static utils.EmailUtils.waitForMail;

@Listeners({ListenerAllure.class})
public class LoginTests {

    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();
    String randomStr = RandomUtils.RandomString(10);

    @AllureId("39")
    @Test
    @Description("Login Test")
    public void LoginTest() throws Exception {

        String email = String.format("testhurmageaorgia+%s@gmail.com",RandomUtils.RandomInt(100));
        String name = String.format("Test Email %s+%s", RandomUtils.RandomInt(10),RandomUtils.RandomString(1));

        System.out.println(email);
        System.out.println(name);
        //Configuration.holdBrowserOpen = true;
        Configuration.timeout = 10000;

        Selenide.open(ResourcesUtils.getResources("configs","mainUrl"));

        loginPage
                .enterEmail(ResourcesUtils.getResources("configs","email"))
                .enterPassword(ResourcesUtils.getResources("configs","password"))
                .clickSubmit();
            mainPage
                    .clickToTheCompanyTab()
                    .clickCreateButton()
                    .clickToTheRespHr()
                    .selectRole(TestData.admin)
                    .enterName(name)
                    .enterEmail(email)
                    .enterResponsible(randomStr)
                    .selectDateForTrainee()
                    .clickSubmitButton()
                    .clickEllipsis()
                    .clickSendAccess()
                    .clickOk();

        Selenide.closeWebDriver();

        List<String> message= waitForMail(ResourcesUtils.getResources("configs","emailLoginTest"), ResourcesUtils.getResources("configs","passwordForLoginTest"), name, Integer.parseInt(ResourcesUtils.getResources("configs","timeForWaitingMail")));

        Assert.assertTrue("Message not found",message.size()>0);

        String text = Jsoup.parse(message.get(0)).text();
        var password = ParseUtils.getCredFromText(text, "Пароль:").get(1);

        Selenide.open(ResourcesUtils.getResources("configs","mainUrl"));

        loginPage
                .enterEmail(email)
                .enterPassword(password)
                .clickSubmit();


    }
}

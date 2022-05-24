package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.devtools.v85.log.Log;
import static io.qameta.allure.Allure.step;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {


    @Step("Enter Email")
    public LoginPage enterEmail(String emailUser){
        $(By.name("email")).sendKeys(emailUser);
        return this;
    }

    @Step("Enter Password")
    public LoginPage enterPassword(String password){
        $(By.name("password")).sendKeys(password);
        return this;
    }

    @Step("Click submit")
    public void clickSubmit(){
        $(By.xpath("//input[@type ='submit']")).click();
    }
}

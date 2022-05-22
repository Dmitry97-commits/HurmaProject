package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.devtools.v85.log.Log;
import static io.qameta.allure.Allure.step;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {


    public LoginPage enterEmail(String emailUser){
        step("Enter Email",()-> $(By.name("email")).sendKeys(emailUser));
        return this;
    }

    public LoginPage enterPassword(String password){
        step("Enter Password",()->$(By.name("password")).sendKeys(password));
        return this;
    }

    public void clickSubmit(){
        step("Click Submit",()-> $(By.xpath("//input[@type ='submit']")).click());
    }
}

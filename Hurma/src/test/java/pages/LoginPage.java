package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.devtools.v85.log.Log;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    public LoginPage enterEmail(String emailUser){
        $(By.name("email")).sendKeys(emailUser);
        return this;
    }

    public LoginPage enterPassword(String password){
        $(By.name("password")).sendKeys(password);
        return this;
    }

    public void clickSubmit(){
        $(By.xpath("//input[@type ='submit']")).click();
    }
}

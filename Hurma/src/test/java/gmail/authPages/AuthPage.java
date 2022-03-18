package gmail.authPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class AuthPage {

    public PasswordPage EnterEmail(String email){
        $(By.xpath("//input[@type = 'email']")).sendKeys(email, Keys.ENTER);
        return new PasswordPage();
    }
}

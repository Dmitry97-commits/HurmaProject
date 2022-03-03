package gmail.jsonObjects.authPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class PasswordPage {

    public SettingsPage enterPassword(String password){
        $(By.xpath("//input[@type = 'password']")).sendKeys(password, Keys.ENTER);
        return new SettingsPage();
    }
}

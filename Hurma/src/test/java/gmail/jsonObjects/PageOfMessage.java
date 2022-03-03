package gmail.jsonObjects;

import org.openqa.selenium.By;
import pages.LoginPage;

import javax.swing.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PageOfMessage {

    public static String getText(){
        return $$(By.xpath("//p[@style]")).get(2).getText();
    }

    public static LoginPage clickByLink(){
        $(By.xpath("//a[contains(@href,'hurma-mail')]")).click();
        return new LoginPage();
    }
}

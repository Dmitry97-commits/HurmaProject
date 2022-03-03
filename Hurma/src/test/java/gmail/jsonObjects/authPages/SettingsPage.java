package gmail.jsonObjects.authPages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SettingsPage {

    public RootAppPage clickToTheSettings(){
        $(By.xpath("//child::body//a[contains(@href,'#')]")).click();
        $(By.xpath("//child::body//p/a[contains(@href,'#')]")).shouldBe(Condition.visible).click();
        return new RootAppPage();
    }
}

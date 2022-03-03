package gmail.jsonObjects.authPages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class GetAuthPage {

    public static String getAuthCode(){
        return $(By.xpath("//textarea[@class]")).getText();
    }
}

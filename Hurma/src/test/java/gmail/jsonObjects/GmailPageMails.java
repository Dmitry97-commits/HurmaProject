package gmail.jsonObjects;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.refresh;

public class GmailPageMails {

    public PageOfMessage getMessageByTitle(String title){
        refresh();
        $(By.xpath(String.format("//table[@id=':2a']//td[@role='gridcell']//div[@class='yW']//span[@name='%s']",title))).shouldBe(Condition.visible).click();
        return new PageOfMessage();
    }
}

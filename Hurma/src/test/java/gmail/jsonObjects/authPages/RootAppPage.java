package gmail.jsonObjects.authPages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class RootAppPage {

    public void clickGoButton(){
        $(By.xpath("//*[@id='submit_approve_access']//div//button")).click();;
    }

}

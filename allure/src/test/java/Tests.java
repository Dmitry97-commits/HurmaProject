import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Tests {

    @Test
    public void allureTest(){
        Selenide.open("https://stackoverflow.com/questions/47341559/allure-testng-maven-org-testng-itestnglistener-provider-io-qameta-allure-testn");
        $(By.name("q")).click();
        $(By.name("q")).sendKeys("dsfsd");
        $(By.name("q")).submit();

    }
}

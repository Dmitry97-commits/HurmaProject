package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class CreateEmployeePage {

    public static String checkCreatedByName(){

        return $(By.xpath("//h1[contains(@class,'mr-6')]")).shouldHave(Condition.enabled, Condition.visible).getText();
    }
    public CreateEmployeePage clickToTheRespHr(){
        executeJavaScript("window.scrollBy(0,document.body.scrollHeight)");
        $(By.xpath("//div[@aria-owns='list-68']")).click();
        return this;
    }

    public CreateEmployeePage selectRole(String response){
        $(By.xpath(String.format("//div[@role ='listbox']//div[contains(text(),'%s')]",response))).
                shouldBe(Condition.enabled, Condition.visible).click();
        return this;
    }

    public CreateEmployeePage enterName(String name){
        executeJavaScript("window.scrollBy(0,-250)");
        $(By.id("input-23")).scrollTo().sendKeys(name);
        return this;
    }

    public CreateEmployeePage enterEmail(String name){
        $(By.id("input-39")).sendKeys(name);
        return this;
    }

    public CreateEmployeePage enterResponsible(String responsible){
        $(By.id("input-46")).sendKeys(responsible);
        return this;
    }

    public CreateEmployeePage selectDateForTrainee(){
        executeJavaScript("window.scrollBy(0,document.body.scrollHeight)");
        $(By.id("input-88")).click();
        var selectedDate = $(By.xpath("//table//button[@type='button' and contains(@class, 'outlined')]"));
        selectedDate.click();
        $(By.id("input-93")).click();
        selectedDate.click();
        return this;
    }

    public CreateEmployeePage clickSubmitButton(){
        $(By.xpath("//div[contains(@class,'footer')]//button[@data-mdja]")).click();
        return this;
    }

    public CreateEmployeePage clickEllipsis(){
        $(By.xpath("//button[@data-mdja='01-06']")).click();
        return this;
    }

    public CreateEmployeePage clickRemove(){
        $(By.id("list-item-180")).click();
        return this;
    }

    public CreateEmployeePage removeEmployee(){
        $(By.id("input-189")).click();
        var enabledDates = $$(By.xpath("//button[@class='v-btn v-btn--text v-btn--rounded theme--light']"));
        enabledDates.get(enabledDates.size()-1).click();
        $(By.xpath("//div[@class='content-select']")).click();
        var variousForRemove = $$(By.xpath("//div//p[@class='name']"));
        variousForRemove.get(variousForRemove.size()-1).click();
        $(By.xpath("//button//span[contains(text(),'Уволить')]")).click();
        return this;
    }


}

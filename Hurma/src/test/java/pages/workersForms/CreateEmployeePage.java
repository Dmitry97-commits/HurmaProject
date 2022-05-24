
package pages.workersForms;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class CreateEmployeePage {

    @Step("Getting a name from a string")
    public static String checkCreatedByName(){
        return $(By.xpath("//h1[contains(@class,'mr-6')]")).shouldHave(Condition.enabled, Condition.visible).getText();
    }

    public CreateEmployeePage clickToTheRespHr(){
        step("Click To HR Responsible",()->{
        executeJavaScript("window.scrollBy(0,document.body.scrollHeight)");
        $(By.xpath("//div[@aria-owns='list-68']")).click();
        });
        return this;
    }

    public CreateEmployeePage selectRole(String response){
        step("Select Role",()->
        $(By.xpath(String.format("//div[@role ='listbox']//div[contains(text(),'%s')]",response))).
                shouldBe(Condition.enabled, Condition.visible).click());
        return this;
    }

    public CreateEmployeePage enterName(String name){
        step("Enter Name",()-> {
            executeJavaScript("window.scrollBy(0,-250)");
            $(By.id("input-23")).scrollTo().sendKeys(name);
        });
        return this;
    }

    public CreateEmployeePage enterEmail(String name){
        step("Enter Email",()->
        $(By.id("input-39")).sendKeys(name));
        return this;
    }

    public CreateEmployeePage enterResponsible(String responsible){
        step("Enter Responsible",()->
        $(By.id("input-46")).sendKeys(responsible));
        return this;
    }

    public CreateEmployeePage selectDateForTrainee(){
        step("Select Date For Trainee",()-> {
            executeJavaScript("window.scrollBy(0,document.body.scrollHeight)");
            $(By.id("input-88")).click();
            var selectedDate = $(By.xpath("//table//button[@type='button' and contains(@class, 'outlined')]"));
            selectedDate.click();
            $(By.id("input-93")).click();
            selectedDate.click();
        });
        return this;
    }

    public AnyWorkerForm clickSubmitButton(){
        step("Click To Submit Button",()->
        $(By.xpath("//div[contains(@class,'footer')]//button[@data-mdja]")).click());
        return new AnyWorkerForm();
    }

    public CreateEmployeePage clickByTeam(){
        actions().moveToElement($$(By.xpath("//div[@class='item-desc']")).get(5)).click();
        return this;
    }

    public  CreateEmployeePage selectTeam(){
        $(By.id("input-144")).click();
        return this;
    }

}

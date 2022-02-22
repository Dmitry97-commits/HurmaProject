package pages.workersForms;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AnyWorkerForm {

    private SelenideElement getFieldFromForm(String nameOfField){
        return $(By.xpath(String.format("//h3[contains(@class,'expansion-panel')]//div[contains(text(),'%s')]",nameOfField)));
    }

    public AnyWorkerForm clickByCompanyField(){
        getFieldFromForm("Компания").click();
        return this;
    }

    public AnyWorkerForm clickByPlaceOfLifeField(){
        getFieldFromForm("Место проживания").click();
        return this;
    }

    public AnyWorkerForm clickBySkillsAndAwards(){
        getFieldFromForm("Награды и навыки").click();
        return this;
    }

    public AnyWorkerForm clickByLanguagesAndEducation(){
        getFieldFromForm("Образование и языки").click();
        return this;
    }

    public AnyWorkerForm clickByAgeAndSex(){
        getFieldFromForm("Возраст и пол").click();
        return this;
    }

    public static Boolean checkTextFromFieldByInformationField(String expectedValue){
        return $(By.xpath(String.format("//li[@class='user-info__item']//span[contains(text(),'%s')]",expectedValue))).isDisplayed();
    }

    public static Boolean checkTextFromFieldByInformationFieldIsEmpty(String expectedValue){
        return $(By.xpath(String.format("//li[@class='user-info__item']//span[contains(text(),'%s')]",expectedValue))).shouldBe(Condition.not(Condition.visible)).isDisplayed();
    }

    public AnyWorkerForm clickEllipsis(){
        $(By.xpath("//button[@data-mdja='01-06']")).click();
        return this;
    }

    public AnyWorkerForm clickRemove(){
        $(By.id("list-item-180")).click();
        return this;
    }

    public AnyWorkerForm removeEmployee(){
        $(By.id("input-189")).click();
        var enabledDates = $$(By.xpath("//button[@class='v-btn v-btn--text v-btn--rounded theme--light']"));
        enabledDates.get(enabledDates.size()-1).click();
        $(By.xpath("//div[@class='content-select']")).click();
        var variousForRemove = $$(By.xpath("//div//p[@class='name']"));
        variousForRemove.get(variousForRemove.size()-1).click();
        $(By.xpath("//button//span[contains(text(),'Уволить')]")).click();
        return this;
    }

    public static Boolean isDisplayedLabelSoonRemove(){
        return $(By.xpath("//span[@class='v-chip__content']")).shouldBe(Condition.visible).isDisplayed();
    }

    public static Boolean checkTags(String tag){
        return $(By.xpath(String.format("//span[@title='%s']//span",tag))).shouldBe(Condition.visible).isDisplayed();
    }

    public static Boolean checkExEmployeeLabel(){
        return $(By.id("removedBlockLabel")).isDisplayed();
    }

}

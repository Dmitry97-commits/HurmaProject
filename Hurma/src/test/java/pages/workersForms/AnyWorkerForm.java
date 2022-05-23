package pages.workersForms;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.apache.commons.lang3.Range;
import org.openqa.selenium.By;
import utils.ParseUtils;
import utils.RandomUtils;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class AnyWorkerForm {

    private SelenideElement getFieldFromForm(String nameOfField){
        return $(By.xpath(String.format("//h3[contains(@class,'expansion-panel')]//div[contains(text(),'%s')]",nameOfField)));
    }

    public AnyWorkerForm clickByCompanyField(){
        step("Click To 'Компания' Field",()->
        getFieldFromForm("Компания").click());
        return this;
    }

    public AnyWorkerForm clickByPlaceOfLifeField(){
        step("Click To 'Место проживания' Field",()->
        getFieldFromForm("Место проживания").click());
        return this;
    }

    public AnyWorkerForm clickBySkillsAndAwards(){
        step("Click To 'Награды и навыки' Field",()->
        getFieldFromForm("Награды и навыки").click());
        return this;
    }

    public AnyWorkerForm clickByLanguagesAndEducation(){
        step("Click To 'Образование и языки' Field",()->
        getFieldFromForm("Образование и языки").click());
        return this;
    }

    public AnyWorkerForm clickByAgeAndSex(){
        step("Click To 'Возраст и пол' Field",()->
        getFieldFromForm("Возраст и пол").click());
        return this;
    }

    public static Boolean checkTextFromFieldByInformationField(String expectedValue){
        step("Check Information In Field'");
        return $(By.xpath(String.format("//li[@class='user-info__item']//span[contains(text(),'%s')]",expectedValue))).shouldBe(Condition.visible).isDisplayed();
    }

    public static Boolean checkTextFromFieldByInformationFieldIsEmpty(String expectedValue){
        step("Check Information In Field Empty'");
        return $(By.xpath(String.format("//li[@class='user-info__item']//span[contains(text(),'%s')]",expectedValue))).shouldNotBe(Condition.visible).isDisplayed();
    }

    public static boolean checkOfAge(){
        step("Check Age");
            String dateOfBirth = $$(By.xpath("//li[@class='user-info__item']//span")).get(1).getText();
            Range<Integer> test = Range.between(0, 53);
            int age = ParseUtils.getAgeFromText(dateOfBirth);
        return test.contains(age);
    }

    public AnyWorkerForm clickEllipsis(){
        step("Click To Ellipsis ",()->
        $(By.xpath("//button[@data-mdja='01-06']")).shouldBe(Condition.visible).click());
        return this;
    }

    public AnyWorkerForm clickSendAccess(){
        step("Click To 'Отправить доступ' ",()->
        $(By.xpath("//div[@class='v-list-item__title' and contains(text(),'Отправить доступ')]")).click());
        return new AnyWorkerForm();
    }

    public void clickOk(){
        step("Click To 'Отправить'",()->
        $(By.xpath("//button//span[@class='v-btn__content' and contains(text(),'Отправить')]")).click());
    }

    public AnyWorkerForm clickRemove(){
        step("Click To Remove",()->
        $(By.xpath("//div[contains(@class,'v-list-item__title') and contains(text(),'Уволить')]")).click());
        return this;
    }

    public AnyWorkerForm removeEmployee(){
        step("Click To 'Уволить' Field",()-> {
            $(By.xpath("//div[@class='v-text-field__slot']//input")).click();
            var enabledDates = $$(By.xpath("//button[@class='v-btn v-btn--text v-btn--rounded theme--light']"));
            enabledDates.get(enabledDates.size() - 1).click();
            $(By.xpath("//div[@class='content-select']")).click();
            var variousForRemove = $$(By.xpath("//div//p[@class='name']"));
            variousForRemove.get(variousForRemove.size() - 1).click();
            $(By.xpath("//button//span[contains(text(),'Уволить')]")).click();
        });
        return this;
    }

    public static Boolean isDisplayedLabelSoonRemove(){
        step("Check Label Soon Remove Is Displayed");
        return $(By.xpath("//span[@class='v-chip__content']")).shouldBe(Condition.visible).isDisplayed();
    }

    public static Boolean checkTags(String tag){
        step("Check Having Expected Tag");
        return $(By.xpath(String.format("//span[@title='%s']//span",tag))).shouldBe(Condition.visible).isDisplayed();
    }

    public static Boolean checkExEmployeeLabel(){
        return $(By.id("removedBlockLabel")).isDisplayed();
    }

    public AnyWorkerForm clickByPersonalInfoTab(){
        step("Click To The Personal Info Tab",()-> $(By.xpath("//a[@href='#personal-info']")).click());
        return this;
    }

    public AnyWorkerForm clickByRequestTab(){
        step("Click To 'Запросы' ",()->
        $(By.xpath("//a[@href='#request']")).click());
        return this;
    }

    public AnyWorkerForm clickByPlus(){
        step("Click To Plus",()->
        $(By.xpath("//div[@data-mdja='01-26']")).click());
        return this;
    }

    public AnyWorkerForm clickByPatterns(){
        step("Click To Patterns Field",()->
        $(By.xpath("//div[@placeholder='Без шаблонов']")).click());
        return this;
    }

    public AnyWorkerForm selectPerfReview(){
        step("Select 'Performance review'",()->
        $(By.xpath("//p[contains(text(),'Performance review')]")).click());
        return this;
    }

    public AnyWorkerForm selectTypePerfReview(){
        step("Select Type Of 'Performance Review'",()->
        $(By.xpath("//div[@class='v-input__icon v-input__icon--append']")).click());
        return this;
    }

    public AnyWorkerForm clickByTypeOfPerfReview(){
        step("Select 'Performance review' In Type Of Performance Reviews",()->
        $(By.xpath("//div[contains(text(),'Performance Review')]")).click());
        return this;
    }

    public AnyWorkerForm clickSave(){
        step("Click To 'Сохранить'",()->
        $(By.xpath("//button[@type='button']//span[contains(text(),'Сохранить')]")).click());
        return this;
    }

    public AnyWorkerForm clickByComment(){
        step("Write Comment",()->
        $(By.xpath("//p[@class='ck-placeholder']")).sendKeys(RandomUtils.RandomString(5)));
        return this;
    }

    public AnyWorkerForm clickBySend(){
        step("Click To 'Отправить'",()->
        $(By.xpath("//button[@type='button']//span[contains(text(),'Отправить')]")).click());
        return this;
    }

    public AnyWorkerForm closeForm(){
        step("Close Form",()->
        $(By.xpath("//a[@class='close-icon']")).click());
        return this;

    }

    public AnyWorkerForm outOfForm(){
        step("Go Out From Form",()->
        $(By.xpath("//a[contains(text(),'Сотрудники')]")).click());
        return this;
    }
    public static Boolean checkHavingChildren(){
        step("Check Having Children");
        return $$(By.xpath("//div[@class='v-expansion-panel-content']//li[@class='user-info__item']")).size()<=2;
    }

    public static Boolean requestIsDisplayed(){
        step("Check Request Is Displayed");
        return $(By.xpath("//tr//span[contains(text(),'Отпуск')]")).shouldBe(Condition.visible).isDisplayed();
    }

    public static Boolean checkMaritalStatus(){
        step("Check Marital Status");
        return $(By.xpath("//li[@class='user-info__item']")).shouldBe(Condition.visible).isDisplayed();
    }
}
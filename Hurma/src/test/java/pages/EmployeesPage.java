package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pages.workersForms.AnyWorkerForm;
import pages.workersForms.CreateEmployeePage;
import utils.RandomUtils;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class EmployeesPage {

    private final ElementsCollection listOfEmployees = $$(By.xpath("//a[@class='name']"));
    private final ElementsCollection listOfTestEmployees = $$(By.xpath("//a[contains(@class,'name') and contains(text(),'Тест')]"));
    private final ElementsCollection listOfFilterParams= $$(By.xpath("//div[@class='filter-title-block__activator']"));
    private final SelenideElement labelOfLoading = $(By.xpath("//div[@class='v-overlay__scrim']"));
    private final ElementsCollection listOfCheckBoxes = $$(By.xpath("//input[@role='checkbox']"));

    private SelenideElement selectParamFromDropDownContainer(String name){
        step("Select Params From Dropdown Container");
            return $(By.xpath(String.format("//div[@class='filter-options__item']//p[contains(text(),'%s')]", name)));
    }

    public CreateEmployeePage clickCreateButton(){
        step("Click Create Button",()-> $(By.xpath("//a[contains(@href,'create')]")).click());
        return new CreateEmployeePage();
    }

    public EmployeesPage selectPage(int numOfPage){
        step("Select Page",()->$(By.xpath(String.format("//nav[@role='navigation']//li[%s]//button",numOfPage))).click());
        labelOfLoading.shouldBe(Condition.visible);
        return this;
    }

    public AnyWorkerForm selectEmployee(){
        step("Select Employee",()->listOfEmployees.shouldBe(CollectionCondition.sizeGreaterThan(0)).get(RandomUtils.RandomInt(listOfEmployees.size()-1)).click());
        return new AnyWorkerForm();
    }

    public AnyWorkerForm selectTestEmployee(){
        step("Select Test Employee",()->listOfTestEmployees.shouldBe(CollectionCondition.sizeGreaterThan(0)).first().click());
        return new AnyWorkerForm();
    }

    public EmployeesPage clickToFilter(){
        step("Click To The Filter",()->$(By.xpath("//ul[@class='sorting-btn-list']//li")).hover().click());
        return this;
    }

    public EmployeesPage selectProbation(){
        step("Select Probation",()->{
        actions().moveToElement($(By.xpath("//label[contains(text(),'Испытательный период')]"))).click();
        labelOfLoading.shouldBe(Condition.visible);
        $(By.xpath("//div//span[@class='filter-block__reset-btn']")).shouldBe(Condition.visible);
        });
        return this;
    }

    public EmployeesPage selectCooperation(){
        step("Select Cooperation",()->{
            actions().moveToElement($(By.xpath("//label[contains(text(),'Сотрудничество')]"))).click();
            labelOfLoading.shouldBe(Condition.visible);
        });
        return this;
    }

    public EmployeesPage selectFinishOfCooperation(){
        step("Select Finish Cooperation",()->{$(By.xpath("//label[contains(text(),'Завершение сотрудничества')]")).click();
        labelOfLoading.shouldBe(Condition.visible);
        });
        return this;
    }

    public EmployeesPage selectByTeam(){
        step("Select Team",()->listOfFilterParams.get(12).click());
        return this;
    }

    public EmployeesPage selectByDateOfBirthday(){
        step("Select By Date Of Birthday",()->listOfFilterParams.first().scrollIntoView(false).click());
        return this;
    }

    public EmployeesPage selectMonthOfDateOfBirthday(){
        step("Select Birthday Month",()-> {
            selectParamFromDropDownContainer("Март").click();
            labelOfLoading.shouldBe(Condition.visible);
        });
        return this;
    }

    public EmployeesPage selectByAbsenceFromWork(){
        step("Select Absence From Work",()->listOfFilterParams.get(1).scrollIntoView(false).click());
        return this;
    }

    public EmployeesPage selectAbsence(){
        step("Select Param 'Отпуск'",()->{
        selectParamFromDropDownContainer("Отпуск").click();
        labelOfLoading.shouldBe(Condition.visible);
        listOfEmployees.shouldBe(CollectionCondition.sizeGreaterThan(0));
        });
        return this;
    }

    public EmployeesPage selectByRoleInSystem(){
        step("Select Role in System",()->listOfFilterParams.get(2).scrollIntoView(false).click());
        return this;
    }

    public EmployeesPage selectRole(){
        step("Select Param 'Администратор'",()->{
        selectParamFromDropDownContainer("Администратор").click();
        labelOfLoading.shouldBe(Condition.visible);
        });
        return this;
    }

    public EmployeesPage selectByMaritalStatus(){
        step("Select Marital Status",()->listOfFilterParams.get(4).scrollIntoView(false).click());
        return this;
    }

    public EmployeesPage selectMaritalStatus(){
        step("Select Param 'Вдовец'",()-> {
            selectParamFromDropDownContainer("Вдовец").click();
            labelOfLoading.shouldBe(Condition.visible);
        });
        return this;
    }

    public EmployeesPage selectByExperience(){
        step("Select By Experience",()->listOfFilterParams.get(5).scrollIntoView(false).click());
        return this;
    }

    public EmployeesPage selectExperience(){
        step("Select Param '10+ лет'",()-> {
            selectParamFromDropDownContainer("10+ лет").click();
            labelOfLoading.shouldBe(Condition.visible);
        });
        return this;
    }

    public String selectTeam(){
        step("Select Team");
        var listOfTeams = $$(By.xpath("//div[@class='filter-options__item']")).shouldBe(CollectionCondition.sizeGreaterThan(0));
        var team = listOfTeams.get(listOfTeams.size() - 1);
        String teamStr = team.getText();
        team.click();
        return teamStr;
    }

    public EmployeesPage selectByPlace(){
        step("Select By Place",()->listOfFilterParams.get(6).scrollIntoView(false).click());
        return this;
    }

    public EmployeesPage selectCountry(){
        step("Select Param 'Великобритания'",()-> {
            selectParamFromDropDownContainer("Великобритания").click();
            labelOfLoading.shouldBe(Condition.visible);
        });
        return this;
    }

    public EmployeesPage selectByTag(){
        step("Select By Tag",()->listOfFilterParams.get(13).scrollIntoView(false).click());
        return this;
    }

    public EmployeesPage selectTag(){
        step("Select Param '.NET Core'",()-> {
            selectParamFromDropDownContainer(".NET Core").click();
            labelOfLoading.shouldBe(Condition.visible);
        });
        return this;
    }

    public EmployeesPage selectByEvent(){
        step("Select By Event",()->listOfFilterParams.get(9).scrollIntoView(false).click());
        return this;
    }

    public EmployeesPage selectEvent(){
        step("Select Param 'Performance review'",()->{
        selectParamFromDropDownContainer("Performance review").click();
        labelOfLoading.shouldBe(Condition.visible);
        });
        return this;
    }

    public static Boolean checkEvent(String event){
        return $(By.xpath("//div[@class='add-actions']//span[@class='badge badge-blue']")).shouldBe(Condition.visible).getText().equals(event);
    }

    public EmployeesPage selectByLevel(){
        step("Select By Level",()->listOfFilterParams.get(7).scrollIntoView(false).click());
        return this;
    }

    public EmployeesPage selectLevel(){
        step("Select Param 'Junior'",()->{
        selectParamFromDropDownContainer("Junior").click();
        labelOfLoading.shouldBe(Condition.visible);
        });
        return this;
    }

    public EmployeesPage selectByResponsible(){
        step("Select By Responsible",()->listOfFilterParams.get(11).scrollIntoView(false).click());
        return this;
    }

    public EmployeesPage selectResponsible(){
        step("Select Param 'тест'",()-> {
            selectParamFromDropDownContainer("тест").click();
            labelOfLoading.shouldBe(Condition.visible);
        });
        return this;
    }

    public EmployeesPage selectBySkills(){
        step("Select By Skills",()->listOfFilterParams.get(8).scrollIntoView(false).click());
        return this;
    }

    public EmployeesPage selectSkill(){
        step("Select Param 'UI/UX'",()-> {
            selectParamFromDropDownContainer("UI/UX").click();
            labelOfLoading.shouldBe(Condition.visible);
        });
        return this;
    }

    public EmployeesPage clickCheckBoxEmployee(){
        step("Click To Checkbox 'Сотрудники'",()-> {
            $$(By.xpath("//label[contains(text(),'Сотрудники')]")).last().scrollIntoView(false).click();
            labelOfLoading.shouldBe(Condition.visible);
        });
        return this;
    }

    public EmployeesPage clickCheckBoxExEmployee(){
        step("Click To Checkbox 'Бывшие сотрудники'",()-> {
            $(By.xpath("//label[contains(text(),'Бывшие сотрудники')]")).scrollIntoView(false).click();
            labelOfLoading.shouldBe(Condition.visible);
        });
        return this;
    }

    public EmployeesPage clickCheckBoxEmployeeFormOfWork(){
        step("Click To Checkbox 'Сотрудник' In Form Of Work",()-> {
            $(By.xpath("//label[contains(text(),'Сотрудник')]")).click();
            labelOfLoading.shouldBe(Condition.visible);
        });
        return this;
    }

    public EmployeesPage clickCheckBoxWithoutFormOfWork(){
        step("Click To Checkbox 'Внештатный' In Form Of Work",()-> {
            $(By.xpath("//label[contains(text(),'Внештатный')]")).scrollIntoView(false).click();
            labelOfLoading.shouldBe(Condition.visible);
        });
        return this;
    }

    public EmployeesPage clickCheckBoxFlpFormOfWork(){
        step("Click To Checkbox 'ФЛП' In Form Of Work",()-> {
            $(By.xpath("//label[contains(text(),'ФЛП')]")).scrollIntoView(false).click();
            labelOfLoading.shouldBe(Condition.visible);
        });
        return this;
    }

    public static Boolean checkExEmployee(){
        return $(By.xpath("//div[@class='add-actions']//span[@class='badge badge-red']")).shouldBe(Condition.visible).getText().equals("Бывший сотрудник");
    }

    public EmployeesPage selectByLanguageSkills(){
        step("Select By Language",()-> actions().moveToElement(listOfFilterParams.get(10)).click().perform());
        return this;
    }

    public EmployeesPage selectLanguage(){
        step("Select Param 'Английский'",()->selectParamFromDropDownContainer("Английский").click());
        return this;
    }

    public EmployeesPage selectLevelOfLanguage(){
        step("Select Level Of Language 'Beginner' ",()->{
        selectParamFromDropDownContainer("Beginner").click();
        labelOfLoading.shouldBe(Condition.visible);
        });
        return this;
    }

    public EmployeesPage clickCheckBoxWithoutAge(){
        step("Click Checkbox 'Возраст не указан' ",()-> {
            actions().moveToElement($(By.xpath("//label[contains(text(),'Возраст не указан')]"))).click().perform();
            labelOfLoading.shouldBe(Condition.visible);
        });
        return this;
    }

    public EmployeesPage clickCheckBoxAge(){
        step("Click Checkbox 'Задать значение' ",()-> {
            actions().moveToElement($(By.xpath("//label[contains(text(),'Задать значение')]"))).click().perform();
            labelOfLoading.shouldBe(Condition.visible);
        });
        return this;
    }

    public EmployeesPage enterAgeLowBorder(String age){
        var selectedAge = $(By.xpath("//input[@type='number']"));
        selectedAge.click();
        selectedAge.clear();
        //selectedAge.sendKeys(age);
        //selectedAge.sendKeys(Keys.DELETE,Keys.DELETE,age);
        return this;
    }

    public EmployeesPage enterAgeHighBorder(String age){
        var selectedAge = $(By.id("input-291"));
        selectedAge.clear();
        selectedAge.sendKeys(age);
        return this;
    }

    public EmployeesPage clickByDateStartedWork(){
        step("Click To 'Выберите дату или период' ",()-> {
            actions().moveToElement($(By.xpath("//p[contains(text(),'Выберите дату или период')]"))).click();
        });
        return this;
    }

    public EmployeesPage selectPeriodLastYear(){
        step("Select Period 'Прошедший год'",()-> {
            $(By.xpath("//div[contains(@class,'datepicker-options')]//p[contains(text(),'Прошедший год')]")).click();
            labelOfLoading.shouldBe(Condition.visible);
        });
        return this;
    }

    public EmployeesPage selectPeriod(){
        step("Click to 'Выбрать период' ",()-> $(By.xpath("//div[contains(@class,'datepicker-options')]//p[contains(text(),'Выбрать период')]")).click());
        return this;
    }

    public EmployeesPage enterTodayDay(){
        step("Choose A Today ",()-> {
            $(By.xpath("//table//button[@type='button' and contains(@class, 'outlined')]")).click();
            actions().sendKeys(Keys.ENTER).perform();
            labelOfLoading.shouldBe(Condition.visible);
        });
        return this;
    }

    public EmployeesPage selectChildrenYes(){
        step("Select Param 'Есть дети' ",()-> {
            actions().moveToElement($(By.xpath("//label[contains(text(),'Есть дети')]"))).click().perform();
            labelOfLoading.shouldBe(Condition.visible);
        });
        return this;
    }

    public EmployeesPage selectChildrenNo(){
        step("Select Param 'Нет детей'",()-> {
            actions().moveToElement($(By.xpath("//label[contains(text(),'Нет детей')]"))).click().perform();
            labelOfLoading.shouldBe(Condition.visible);
        });
        return this;
    }

    public EmployeesPage clickResetButton(){
        step("Click To Reset Button ",()-> {
            listOfCheckBoxes.get(RandomUtils.RandomInt(listOfCheckBoxes.size() - 1)).click();
            labelOfLoading.shouldBe(Condition.visible);
            $(By.xpath("//div//span[@class='filter-block__reset-btn']")).click();
            labelOfLoading.shouldBe(Condition.visible);
        });
        return this;
    }

    public EmployeesPage clickCheckBoxWithoutSex(){
        step("Select Checkbox 'Не выбран' ",()->{
        actions().moveToElement($(By.xpath("//label[contains(text(),'Не выбран')]"))).click().perform();
        labelOfLoading.shouldBe(Condition.visible);
        });
        return this;
    }

    public EmployeesPage clickCheckBoxMaleSex(){
        step("Select Checkbox 'Мужской' ",()-> {
            actions().moveToElement($(By.xpath("//label[contains(text(),'Мужской')]"))).click().perform();
            labelOfLoading.shouldBe(Condition.visible);
        });
        return this;
    }

    public EmployeesPage clickCheckBoxFemaleSex(){
        step("Select Checkbox 'Женский' ",()-> {
            actions().moveToElement($(By.xpath("//label[contains(text(),'Женский')]"))).click().perform();
            labelOfLoading.shouldBe(Condition.visible);
        });
        return this;
    }

}

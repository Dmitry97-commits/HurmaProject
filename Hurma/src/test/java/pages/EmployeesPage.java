package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pages.workersForms.AnyWorkerForm;
import pages.workersForms.CreateEmployeePage;
import utils.RandomUtils;

import static com.codeborne.selenide.Selenide.*;

public class EmployeesPage {

    private final ElementsCollection listOfEmployees = $$(By.xpath("//a[@class='name']"));
    private final ElementsCollection listOfTestEmployees = $$(By.xpath("//a[contains(@class,'name') and contains(text(),'Тест')]"));
    private final ElementsCollection listOfFilterParams= $$(By.xpath("//div[@class='filter-title-block__activator']"));
    private final SelenideElement labelOfLoading = $(By.xpath("//div[@class='v-overlay__scrim']"));
    private final ElementsCollection listOfCheckBoxes = $$(By.xpath("//input[@role='checkbox']"));

    private SelenideElement selectParamFromDropDownContainer(String name){
        return $(By.xpath(String.format("//div[@class='filter-options__item']//p[contains(text(),'%s')]",name)));
    }

    public CreateEmployeePage clickCreateButton(){
        $(By.xpath("//a[contains(@href,'create')]")).click();
        return new CreateEmployeePage();
    }

    public EmployeesPage selectPage(int numOfPage){
        $(By.xpath(String.format("//nav[@role='navigation']//li[%s]//button",numOfPage))).click();
        return this;
    }

    public AnyWorkerForm selectEmployee(){
        listOfEmployees.shouldBe(CollectionCondition.sizeGreaterThan(0)).get(RandomUtils.RandomInt(listOfEmployees.size()-1)).click();
        return new AnyWorkerForm();
    }

    public AnyWorkerForm selectTestEmployee(){
        listOfTestEmployees.shouldBe(CollectionCondition.sizeGreaterThan(0)).first().click();
        return new AnyWorkerForm();
    }

    public EmployeesPage clickToFilter(){
        $(By.xpath("//ul[@class='sorting-btn-list']//li")).hover().click();
        return this;
    }

    public EmployeesPage selectProbation(){
        $(By.xpath("//label[contains(text(),'Испытательный период')]")).click();
        labelOfLoading.shouldBe(Condition.visible);
        return this;
    }

    public EmployeesPage selectCooperation(){
        $(By.xpath("//label[contains(text(),'Сотрудничество')]")).click();
        labelOfLoading.shouldBe(Condition.visible);
        return this;
    }

    public EmployeesPage selectFinishOfCooperation(){
        $(By.xpath("//label[contains(text(),'Завершение сотрудничества')]")).click();
        labelOfLoading.shouldBe(Condition.visible);
        return this;
    }

    public EmployeesPage selectByTeam(){
        listOfFilterParams.get(10).click();
        return this;
    }

    public EmployeesPage selectByDateOfBirthday(){
        listOfFilterParams.get(3).click();
        return this;
    }

    public EmployeesPage selectMonthOfDateOfBirthday(){
        selectParamFromDropDownContainer("Март").click();
        labelOfLoading.shouldBe(Condition.visible);
        return this;
    }

    public EmployeesPage selectByAbsenceFromWork(){
        listOfFilterParams.get(4).click();
        return this;
    }

    public EmployeesPage selectAbsence(){
        selectParamFromDropDownContainer("Ночная смена").click();
        listOfEmployees.shouldBe(CollectionCondition.size(1));
        return this;
    }

    public EmployeesPage selectByRoleInSystem(){
        listOfFilterParams.get(5).click();
        return this;
    }

    public EmployeesPage selectRole(){
        selectParamFromDropDownContainer("Администратор").click();
        labelOfLoading.shouldBe(Condition.visible);
        return this;
    }

    public EmployeesPage selectByMaritalStatus(){
        listOfFilterParams.get(7).click();
        return this;
    }

    public EmployeesPage selectMaritalStatus(){
        selectParamFromDropDownContainer("Вдовец").click();
        labelOfLoading.shouldBe(Condition.visible);
        return this;
    }

    public EmployeesPage selectByExperience(){
        listOfFilterParams.get(8).click();
        return this;
    }

    public EmployeesPage selectExperience(){
        selectParamFromDropDownContainer("10+ лет").click();
        labelOfLoading.shouldBe(Condition.visible);
        return this;
    }

    public String selectTeam(){
        var listOfTeams = $$(By.xpath("//div[@class='filter-options__item']")).shouldBe(CollectionCondition.sizeGreaterThan(0));
        var team = listOfTeams.get(listOfTeams.size()-1);
        String teamStr = team.getText();
        team.click();
        return teamStr;
    }

    public EmployeesPage selectByPlace(){
        listOfFilterParams.get(9).click();
        return this;
    }

    public EmployeesPage selectCountry(){
        selectParamFromDropDownContainer("Великобритания").click();
        labelOfLoading.shouldBe(Condition.visible);
        return this;
    }

    public EmployeesPage selectByTag(){
        listOfFilterParams.get(12).click();
        return this;
    }

    public EmployeesPage selectTag(){
        selectParamFromDropDownContainer(".NET Core").click();
        labelOfLoading.shouldBe(Condition.visible);
        return this;
    }

    public EmployeesPage selectByEvent(){
        actions().moveToElement(listOfFilterParams.first()).click().perform();
        return this;
    }

    public EmployeesPage selectEvent(){
        selectParamFromDropDownContainer("1:1").click();
        labelOfLoading.shouldBe(Condition.visible);
        return this;
    }

    public static Boolean checkEvent(String event){
        return $(By.xpath("//div[@class='add-actions']//span[@class='badge badge-blue']")).shouldBe(Condition.visible).getText().equals(event);
    }

    public EmployeesPage selectByLevel(){
        listOfFilterParams.get(11).click();
        return this;
    }

    public EmployeesPage selectLevel(){
        selectParamFromDropDownContainer("Junior").click();
        labelOfLoading.shouldBe(Condition.visible);
        return this;
    }

    public EmployeesPage selectByResponsible(){
        listOfFilterParams.last().click();
        return this;
    }

    public EmployeesPage selectResponsible(){
        selectParamFromDropDownContainer("тест").click();
        labelOfLoading.shouldBe(Condition.visible);
        return this;
    }

    public EmployeesPage selectBySkills(){
        actions().moveToElement(listOfFilterParams.get(1)).click().perform();
        return this;
    }

    public EmployeesPage selectSkill(){
        selectParamFromDropDownContainer("UI/UX").click();
        labelOfLoading.shouldBe(Condition.visible);
        return this;
    }

    public EmployeesPage clickCheckBoxEmployee(){
        $(By.id("input-41")).click();
        labelOfLoading.shouldBe(Condition.visible);
        return this;
    }

    public EmployeesPage clickCheckBoxExEmployee(){
        actions().moveToElement($(By.xpath("//label[contains(text(),'Бывшие сотрудники')]"))).click().perform();
        labelOfLoading.shouldBe(Condition.visible);
        return this;
    }

    public EmployeesPage clickCheckBoxEmployeeFormOfWork(){
        $(By.id("input-127")).click();
        labelOfLoading.shouldBe(Condition.visible);
        return this;
    }

    public EmployeesPage clickCheckBoxWithoutFormOfWork(){
        $(By.id("input-122")).click();
        labelOfLoading.shouldBe(Condition.visible);
        return this;
    }

    public EmployeesPage clickCheckBoxFlptFormOfWork(){
        $(By.id("input-132")).click();
        labelOfLoading.shouldBe(Condition.visible);
        return this;
    }

    public static Boolean checkExEmployee(){
        return $(By.xpath("//div[@class='add-actions']//span[@class='badge badge-red']")).shouldBe(Condition.visible).getText().equals("Бывший сотрудник");
    }

    public EmployeesPage selectByLanguageSkills(){
        actions().moveToElement(listOfFilterParams.get(2)).click().perform();
        return this;
    }

    public EmployeesPage selectLanguage(){
        selectParamFromDropDownContainer("Английский").click();
        return this;
    }

    public EmployeesPage selectLevelOfLanguage(){
        selectParamFromDropDownContainer("Beginner").click();
        labelOfLoading.shouldBe(Condition.visible);
        return this;
    }

    public EmployeesPage clickCheckBoxWithoutAge(){
        actions().moveToElement($(By.xpath("//label[contains(text(),'Возраст не указан')]"))).click().perform();
        labelOfLoading.shouldBe(Condition.visible);
        return this;
    }

    public EmployeesPage clickCheckBoxAge(){
        actions().moveToElement($(By.xpath("//label[contains(text(),'Задать значение')]"))).click().perform();
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
        $(By.xpath("//p[contains(text(),'Выберите дату или период')]")).click();
        return this;
    }

    public EmployeesPage selectPeriodLastYear(){
        $(By.xpath("//div[contains(@class,'datepicker-options')]//p[contains(text(),'Прошедший год')]")).click();
        labelOfLoading.shouldBe(Condition.visible);
        return this;
    }

    public EmployeesPage selectPeriod(){
        $(By.xpath("//div[contains(@class,'datepicker-options')]//p[contains(text(),'Выбрать период')]")).click();
        return this;
    }

    public EmployeesPage enterTodayDay(){
        $(By.xpath("//table//button[@type='button' and contains(@class, 'outlined')]")).click();
        actions().sendKeys(Keys.ENTER).perform();
        labelOfLoading.shouldBe(Condition.visible);
        return this;
    }

    public EmployeesPage selectChildrenYes(){
        actions().moveToElement($(By.xpath("//label[contains(text(),'Есть дети')]"))).click().perform();
        labelOfLoading.shouldBe(Condition.visible);
        return this;
    }

    public EmployeesPage selectChildrenNo(){
        actions().moveToElement($(By.xpath("//label[contains(text(),'Нет детей')]"))).click().perform();
        labelOfLoading.shouldBe(Condition.visible);
        return this;
    }

    public EmployeesPage clickResetButton(){
        listOfCheckBoxes.get(RandomUtils.RandomInt(listOfCheckBoxes.size()-1)).click();
        labelOfLoading.shouldBe(Condition.visible);
        $(By.xpath("//div//span[@class='filter-block__reset-btn']")).click();
        labelOfLoading.shouldBe(Condition.visible);
        return this;
    }

    public EmployeesPage clickCheckBoxWithoutSex(){
        actions().moveToElement($(By.xpath("//label[contains(text(),'Не выбран')]"))).click().perform();
        labelOfLoading.shouldBe(Condition.visible);
        return this;
    }

    public EmployeesPage clickCheckBoxMaleSex(){
        actions().moveToElement($(By.xpath("//label[contains(text(),'Мужской')]"))).click().perform();
        labelOfLoading.shouldBe(Condition.visible);
        return this;
    }

    public EmployeesPage clickCheckBoxFemaleSex(){
        actions().moveToElement($(By.xpath("//label[contains(text(),'Женский')]"))).click().perform();
        labelOfLoading.shouldBe(Condition.visible);
        return this;
    }

}

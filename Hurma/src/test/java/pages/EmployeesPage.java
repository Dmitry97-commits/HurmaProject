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
        listOfTestEmployees.shouldBe(CollectionCondition.sizeGreaterThan(0)).get(RandomUtils.RandomInt(listOfTestEmployees.size()-1)).click();
        return new AnyWorkerForm();
    }

    public EmployeesPage clickToFilter(){
        $(By.xpath("//ul[@class='sorting-btn-list']//li")).hover().click();
        return this;
    }

    public EmployeesPage selectProbation(){
        $(By.id("input-193")).click();
        return this;
    }

    public EmployeesPage selectCooperation(){
        $(By.xpath("//label[@for='input-198']")).click();
        return this;
    }

    public EmployeesPage selectFinishOfCooperation(){
        $(By.xpath("//label[@for='input-203']")).click();
        return this;
    }

    public EmployeesPage selectByTeam(){
        listOfFilterParams.get(10).click();
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
        return this;
    }

    public EmployeesPage selectByTag(){
        listOfFilterParams.get(12).click();
        return this;
    }

    public EmployeesPage selectTag(){
       selectParamFromDropDownContainer(".NET Core").click();
        return this;
    }

    public EmployeesPage selectByEvent(){
        listOfFilterParams.first().click();
        return this;
    }

    public EmployeesPage selectEvent(){
        selectParamFromDropDownContainer("1:1").click();
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
        return this;
    }

    public EmployeesPage selectByResponsible(){
        listOfFilterParams.last().click();
        return this;
    }

    public EmployeesPage selectResponsible(){
        selectParamFromDropDownContainer("тест").click();
        return this;
    }

    public EmployeesPage selectBySkills(){
        listOfFilterParams.get(1).click();
        return this;
    }

    public EmployeesPage selectSkill(){
        selectParamFromDropDownContainer("UI/UX").click();
        return this;
    }

    public EmployeesPage clickCheckBoxEmployee(){
        $(By.id("input-41")).click();
        return this;
    }

    public EmployeesPage clickCheckBoxExEmployee(){
        $(By.id("input-46")).click();
        return this;
    }

    public static Boolean checkExEmployee(){
        return $(By.xpath("//div[@class='add-actions']//span[@class='badge badge-red']")).shouldBe(Condition.visible).getText().equals("Бывший сотрудник");
    }

    public EmployeesPage selectByLanguageSkills(){
        listOfFilterParams.get(2).click();
        return this;
    }

    public EmployeesPage selectLanguage(){
        selectParamFromDropDownContainer("Английский").click();
        return this;
    }

    public EmployeesPage selectLevelOfLanguage(){
        selectParamFromDropDownContainer("Beginner").click();
        return this;
    }

    public EmployeesPage clickCheckBoxWithoutAge(){
        $(By.id("input-60")).click();
        return this;
    }

    public EmployeesPage clickCheckBoxAge(){
        $(By.xpath("//label[contains(text(),'Задать значение')]")).click();

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

    public EmployeesPage selectPeriod(){
        $(By.xpath("//div[contains(@class,'datepicker-options')]//p[contains(text(),'Прошедший год')]")).click();
        return this;
    }
}

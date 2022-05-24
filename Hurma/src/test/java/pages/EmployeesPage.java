package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
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

    @Step("Select Param From Dropdown Container")
    private SelenideElement selectParamFromDropDownContainer(String name){
            return $(By.xpath(String.format("//div[@class='filter-options__item']//p[contains(text(),'%s')]", name)));
    }

    @Step("Click Create Button")
    public CreateEmployeePage clickCreateButton(){
        $(By.xpath("//a[contains(@href,'create')]")).click();
        return new CreateEmployeePage();
    }

    @Step("Select Page")
    public EmployeesPage selectPage(int numOfPage){
       $(By.xpath(String.format("//nav[@role='navigation']//li[%s]//button",numOfPage))).click();
        labelOfLoading.shouldBe(Condition.visible);
        return this;
    }

    @Step("Select Employee")
    public AnyWorkerForm selectEmployee(){
        listOfEmployees.shouldBe(CollectionCondition.sizeGreaterThan(0)).get(RandomUtils.RandomInt(listOfEmployees.size()-1)).click();
        return new AnyWorkerForm();
    }

    @Step("Select Test Employee")
    public AnyWorkerForm selectTestEmployee(){
        listOfTestEmployees.shouldBe(CollectionCondition.sizeGreaterThan(0)).first().click();
        return new AnyWorkerForm();
    }

    @Step("Click To The Filter")
    public EmployeesPage clickToFilter(){
        $(By.xpath("//ul[@class='sorting-btn-list']//li")).hover().click();
        return this;
    }

    @Step("Select Probation")
    public EmployeesPage selectProbation(){
        $(By.xpath("//label[contains(text(),'Испытательный период')]")).scrollIntoView(false).click();
        labelOfLoading.shouldBe(Condition.visible);
        $(By.xpath("//div//span[@class='filter-block__reset-btn']")).shouldBe(Condition.visible);
        return this;
    }

    @Step("Select Cooperation")
    public EmployeesPage selectCooperation(){
        actions().moveToElement($(By.xpath("//label[contains(text(),'Сотрудничество')]"))).click();
        labelOfLoading.shouldBe(Condition.visible);
        return this;
    }

    @Step("Select Finish Cooperation")
    public EmployeesPage selectFinishOfCooperation(){
        $(By.xpath("//label[contains(text(),'Завершение сотрудничества')]")).click();
        labelOfLoading.shouldBe(Condition.visible);
        return this;
    }

    @Step("Select Team")
    public EmployeesPage selectByTeam(){
        listOfFilterParams.get(12).click();
        return this;
    }

    @Step("Select By Date Of Birthday")
    public EmployeesPage selectByDateOfBirthday(){
        listOfFilterParams.first().scrollIntoView(false).click();
        return this;
    }

    @Step("Select Birthday Month")
    public EmployeesPage selectMonthOfDateOfBirthday(){
        selectParamFromDropDownContainer("Март").click();
        labelOfLoading.shouldBe(Condition.visible);
        return this;
    }

    @Step("Select Absence From Work")
    public EmployeesPage selectByAbsenceFromWork(){
        listOfFilterParams.get(1).scrollIntoView(false).click();
        return this;
    }

    @Step("Select Param 'Отпуск")
    public EmployeesPage selectAbsence(){
        selectParamFromDropDownContainer("Отпуск").click();
        labelOfLoading.shouldBe(Condition.visible);
        listOfEmployees.shouldBe(CollectionCondition.sizeGreaterThan(0));
        return this;
    }

    @Step("Select Role in System")
    public EmployeesPage selectByRoleInSystem(){
        listOfFilterParams.get(2).scrollIntoView(false).click();
        return this;
    }

    @Step("Select Param 'Администратор'")
    public EmployeesPage selectRole(){
        selectParamFromDropDownContainer("Администратор").click();
        labelOfLoading.shouldBe(Condition.visible);
        return this;
    }

    @Step("Select Marital Status")
    public EmployeesPage selectByMaritalStatus(){
        listOfFilterParams.get(4).scrollIntoView(false).click();
        return this;
    }

    @Step("Select Param 'Вдовец'")
    public EmployeesPage selectMaritalStatus(){
        selectParamFromDropDownContainer("Вдовец").click();
        labelOfLoading.shouldBe(Condition.visible);
        return this;
    }

    @Step("Select By Experience")
    public EmployeesPage selectByExperience(){
        listOfFilterParams.get(5).scrollIntoView(false).click();
        return this;
    }

    @Step("Select Param '10+ лет'")
    public EmployeesPage selectExperience(){
        selectParamFromDropDownContainer("10+ лет").click();
        labelOfLoading.shouldBe(Condition.visible);
        return this;
    }

    @Step("Select Team")
    public String selectTeam(){
        var listOfTeams = $$(By.xpath("//div[@class='filter-options__item']")).shouldBe(CollectionCondition.sizeGreaterThan(0));
        var team = listOfTeams.get(listOfTeams.size() - 1);
        String teamStr = team.getText();
        team.click();
        return teamStr;
    }

    @Step("Select By Place")
    public EmployeesPage selectByPlace(){
        listOfFilterParams.get(6).scrollIntoView(false).click();
        return this;
    }

    @Step("Select Param 'Великобритания'")
    public EmployeesPage selectCountry(){
        selectParamFromDropDownContainer("Великобритания").click();
        labelOfLoading.shouldBe(Condition.visible);
        return this;
    }

    @Step("Select By Tag")
    public EmployeesPage selectByTag(){
        listOfFilterParams.get(13).scrollIntoView(false).click();
        return this;
    }

    @Step("Select Param '.NET Core'")
    public EmployeesPage selectTag(){
        selectParamFromDropDownContainer(".NET Core").click();
        labelOfLoading.shouldBe(Condition.visible);
        return this;
    }

    @Step("Select By Event")
    public EmployeesPage selectByEvent(){
        listOfFilterParams.get(9).scrollIntoView(false).click();
        return this;
    }

    @Step("Select Param 'Performance review'")
    public EmployeesPage selectEvent(){
        selectParamFromDropDownContainer("Performance review").click();
        labelOfLoading.shouldBe(Condition.visible);
        return this;
    }

    @Step("Check Event")
    public static Boolean checkEvent(String event){
        return $(By.xpath("//div[@class='add-actions']//span[@class='badge badge-blue']")).shouldBe(Condition.visible).getText().equals(event);
    }

    @Step("Select By Level")
    public EmployeesPage selectByLevel(){
        listOfFilterParams.get(7).scrollIntoView(false).click();
        return this;
    }

    @Step("Select Param 'Junior'")
    public EmployeesPage selectLevel(){
        selectParamFromDropDownContainer("Junior").click();
        labelOfLoading.shouldBe(Condition.visible);
        return this;
    }

    @Step("Select By Responsible")
    public EmployeesPage selectByResponsible(){
        listOfFilterParams.get(11).scrollIntoView(false).click();
        return this;
    }

    @Step("Select Param 'тест'")
    public EmployeesPage selectResponsible(){
        selectParamFromDropDownContainer("тест").click();
        labelOfLoading.shouldBe(Condition.visible);
        return this;
    }

    @Step("Select By Skills")
    public EmployeesPage selectBySkills(){
       listOfFilterParams.get(8).scrollIntoView(false).click();
        return this;
    }

    @Step("Select Param 'UI/UX'")
    public EmployeesPage selectSkill(){
        selectParamFromDropDownContainer("UI/UX").click();
        labelOfLoading.shouldBe(Condition.visible);
        return this;
    }

    @Step("Click To Checkbox 'Сотрудники'")
    public EmployeesPage clickCheckBoxEmployee(){
        $$(By.xpath("//label[contains(text(),'Сотрудники')]")).last().scrollIntoView(false).click();
        labelOfLoading.shouldBe(Condition.visible);
        return this;
    }

    @Step("Click To Checkbox 'Бывшие сотрудники'")
    public EmployeesPage clickCheckBoxExEmployee(){
        $(By.xpath("//label[contains(text(),'Бывшие сотрудники')]")).scrollIntoView(false).click();
        labelOfLoading.shouldBe(Condition.visible);
        return this;
    }

    @Step("Click To Checkbox 'Сотрудник' In Form Of Work")
    public EmployeesPage clickCheckBoxEmployeeFormOfWork(){
        $(By.xpath("//label[contains(text(),'Сотрудник')]")).click();
        labelOfLoading.shouldBe(Condition.visible);
        return this;
    }

    @Step("Click To Checkbox 'Внештатный' In Form Of Work")
    public EmployeesPage clickCheckBoxWithoutFormOfWork(){
        $(By.xpath("//label[contains(text(),'Внештатный')]")).scrollIntoView(false).click();
        labelOfLoading.shouldBe(Condition.visible);
        return this;
    }

    @Step("Click To Checkbox 'ФЛП' In Form Of Work")
    public EmployeesPage clickCheckBoxFlpFormOfWork(){
        $(By.xpath("//label[contains(text(),'ФЛП')]")).scrollIntoView(false).click();
        labelOfLoading.shouldBe(Condition.visible);
        return this;
    }

    @Step("Check Ex Employee")
    public static Boolean checkExEmployee(){
        return $(By.xpath("//div[@class='add-actions']//span[@class='badge badge-red']")).shouldBe(Condition.visible).getText().equals("Бывший сотрудник");
    }

    @Step("Select By Language")
    public EmployeesPage selectByLanguageSkills(){
        actions().moveToElement(listOfFilterParams.get(10)).click().perform();
        return this;
    }

    @Step("Select Param 'Английский'")
    public EmployeesPage selectLanguage(){
        selectParamFromDropDownContainer("Английский").click();
        return this;
    }

    @Step("Select Level Of Language 'Beginner'")
    public EmployeesPage selectLevelOfLanguage(){
        selectParamFromDropDownContainer("Beginner").click();
        labelOfLoading.shouldBe(Condition.visible);
        return this;
    }

    @Step("Click Checkbox 'Возраст не указан'")
    public EmployeesPage clickCheckBoxWithoutAge(){
        actions().moveToElement($(By.xpath("//label[contains(text(),'Возраст не указан')]"))).click().perform();
        labelOfLoading.shouldBe(Condition.visible);
        return this;
    }

    @Step("Click Checkbox 'Задать значение'")
    public EmployeesPage clickCheckBoxAge(){
        actions().moveToElement($(By.xpath("//label[contains(text(),'Задать значение')]"))).click().perform();
        labelOfLoading.shouldBe(Condition.visible);
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

    @Step("Click To 'Выберите дату или период'")
    public EmployeesPage clickByDateStartedWork(){
        $(By.xpath("//div[@class='cus-select-filter-datepicker']//p[contains(text(),'Выберите дату или период')]")).scrollIntoView(false).click();
        return this;
    }

    @Step("Select Period 'Прошедший год'")
    public EmployeesPage selectPeriodLastYear(){
        $(By.xpath("//div[contains(@class,'datepicker-options')]//p[contains(text(),'Прошедший год')]")).click();
        labelOfLoading.shouldBe(Condition.visible);
        return this;
    }

    @Step("Click to 'Выбрать период'")
    public EmployeesPage selectPeriod(){
        $(By.xpath("//div[contains(@class,'datepicker-options')]//p[contains(text(),'Выбрать период')]")).click();
        return this;
    }

    @Step("Choose A Today")
    public EmployeesPage enterTodayDay(){
        $(By.xpath("//table//button[@type='button' and contains(@class, 'outlined')]")).click();
        actions().sendKeys(Keys.ENTER).perform();
        labelOfLoading.shouldBe(Condition.visible);
        return this;
    }

    @Step("Select Param 'Есть дети' ")
    public EmployeesPage selectChildrenYes(){
        actions().moveToElement($(By.xpath("//label[contains(text(),'Есть дети')]"))).click().perform();
        labelOfLoading.shouldBe(Condition.visible);
        return this;
    }

    @Step("Select Param 'Нет детей'")
    public EmployeesPage selectChildrenNo(){
        actions().moveToElement($(By.xpath("//label[contains(text(),'Нет детей')]"))).click().perform();
        labelOfLoading.shouldBe(Condition.visible);
        return this;
    }

    @Step("Click To Reset Button ")
    public EmployeesPage clickResetButton(){
        listOfCheckBoxes.get(RandomUtils.RandomInt(listOfCheckBoxes.size() - 1)).click();
        labelOfLoading.shouldBe(Condition.visible);
        $(By.xpath("//div//span[@class='filter-block__reset-btn']")).click();
        labelOfLoading.shouldBe(Condition.visible);
        return this;
    }

    @Step("Select Checkbox 'Не выбран' ")
    public EmployeesPage clickCheckBoxWithoutSex(){
        actions().moveToElement($(By.xpath("//label[contains(text(),'Не выбран')]"))).click().perform();
        labelOfLoading.shouldBe(Condition.visible);
        return this;
    }

    @Step("Select Checkbox 'Мужской' ")
    public EmployeesPage clickCheckBoxMaleSex(){
        actions().moveToElement($(By.xpath("//label[contains(text(),'Мужской')]"))).click().perform();
        labelOfLoading.shouldBe(Condition.visible);
        return this;
    }

    @Step("Select Checkbox 'Женский' ")
    public EmployeesPage clickCheckBoxFemaleSex(){
        actions().moveToElement($(By.xpath("//label[contains(text(),'Женский')]"))).click().perform();
        labelOfLoading.shouldBe(Condition.visible);
        return this;
    }

}

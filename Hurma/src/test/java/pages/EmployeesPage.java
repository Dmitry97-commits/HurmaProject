package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import pages.workersForms.AnyWorkerForm;
import pages.workersForms.CreateEmployeePage;
import utils.RandomUtils;

import static com.codeborne.selenide.Selenide.*;

public class EmployeesPage {
    private final ElementsCollection listOfEmployees = $$(By.xpath("//a[@class='name']"));
    private final ElementsCollection listOfTestEmployees = $$(By.xpath("//a[contains(@class,'name') and contains(text(),'Тест')]"));

    public CreateEmployeePage clickCreateButton(){
        $(By.xpath("//a[contains(@href,'create')]")).click();
        return new CreateEmployeePage();
    }

    public EmployeesPage selectPage(int numOfPage){
        $(By.xpath(String.format("//nav[@role='navigation']//li[%s]//button",numOfPage))).click();
        return this;
    }

    public AnyWorkerForm selectEmployee(){
        listOfEmployees.get(RandomUtils.RandomInt(listOfEmployees.size()-1)).click();
        return new AnyWorkerForm();
    }

    public AnyWorkerForm selectTestEmployee(){
        listOfTestEmployees.get(RandomUtils.RandomInt(listOfTestEmployees.size()-1)).click();
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
        $(By.xpath("//div[@class='filter-title-block__activator']")).click();
        return this;
    }

    public void selectTeam(){
        var listOfTeams = $$(By.xpath("//div[@class='filter-options__item']")).shouldBe(CollectionCondition.sizeGreaterThan(0));
        var team = listOfTeams.get(listOfTeams.size()-1);
        team.click();
    }

    public EmployeesPage selectByPlace(){
        $$(By.xpath("//div[@class='filter-title-block__activator']")).get(10).click();
        return this;
    }

    public EmployeesPage selectCountry(){
        $(By.xpath("//div[@class='filter-options__item']//p[contains(text(),'Великобритания')]")).click();
        return this;
    }

}

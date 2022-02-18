package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class EmployeesPage {
    public CreateEmployeePage clickCreateButton(){
        $(By.xpath("//a[contains(@href,'create')]")).click();
        return new CreateEmployeePage();
    }

    public EmployeesPage selectPage(int numOfPage){
        $(By.xpath(String.format("//nav[@role='navigation']//li[%s]//button",numOfPage))).click();
        return this;
    }

    public CreateEmployeePage selectEmployee(){
        $(By.xpath("//div[@class='user-info']//a")).click();
        return new CreateEmployeePage();
    }

    public EmployeesPage clickToFilter(){
        $(By.xpath("//ul[@class='sorting-btn-list']//li")).hover().click();
        return this;
    }

    public EmployeesPage selectProbation(){
        $(By.id("input-193")).click();
        return this;
    }
}

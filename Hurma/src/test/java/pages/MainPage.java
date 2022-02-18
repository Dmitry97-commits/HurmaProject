package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    public EmployeesPage clickToTheCompanyTab(){
        $(By.xpath("//li//a[contains(@href,'employees') and contains(@class,'navigation')]")).click();
        return new EmployeesPage();
    }

    public CandidatesListPage clickToTheCandidatesTab(){
        $(By.xpath("//li//a[contains(@href,'vacancies') and contains(@class,'navigation')]")).hover();
        $(By.xpath("//li//a[contains(@href,'candidates')]")).click();
        return new CandidatesListPage();
    }
}

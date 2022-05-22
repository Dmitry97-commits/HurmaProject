package pages;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utils.ScreenshotUtils;

import static io.qameta.allure.Allure.step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {


    public EmployeesPage clickToTheCompanyTab(){
        step("Open Company Tab",()->{
        $(By.xpath("//li//a[contains(@href,'employees') and contains(@class,'navigation')]")).click();
        });
        return new EmployeesPage();
    };

    public CandidatesListPage clickToTheCandidatesTab(){
        step("Open The Candidates Tab",()->{
        $(By.xpath("//li//a[contains(@href,'vacancies') and contains(@class,'navigation')]")).hover();
        $(By.xpath("//li//a[contains(@href,'candidates')]")).click();
        });
        return new CandidatesListPage();
    }

    public void clickToTheProfile(){
        var tab = $$(By.xpath("//li//a[@class='navigation__img ']")).get(8);
        tab.click();
    }
}
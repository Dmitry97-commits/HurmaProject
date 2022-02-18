package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CandidatesListPage {
    public CandidatesListPage clickToFilter(){
        $(By.xpath("//ul[@class='sorting-btn']//li")).hover().click();
        return this;
    }

    public CandidatesListPage clickSortedBy(){
        $(By.id("ex_employees_select_plaseholder")).click();
        return this;
    }

    public CandidatesListPage selectOnlyExEmployee(){
        $(By.xpath("//p[contains(@data-value,'only')]")).click();
        return this;
    }

    public CandidatePage selectCandidate(){
        $(By.xpath("//div[@class='user-info']//a")).click();
        return new CandidatePage();
    }
}

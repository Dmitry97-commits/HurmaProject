package pages;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import pages.workersForms.CandidatePage;
import utils.RandomUtils;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CandidatesListPage {

    private final ElementsCollection listOfTestEmployee = $$(By.xpath("//a[contains(@class,'name') and contains(text(),'Тест')]"));

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
        listOfTestEmployee.get(RandomUtils.RandomInt(listOfTestEmployee.size()-1)).click();
        return new CandidatePage();
    }
}

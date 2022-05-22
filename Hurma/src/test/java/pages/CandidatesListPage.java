package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.workersForms.CandidatePage;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class CandidatesListPage {

    private final ElementsCollection listOfTestEmployee = $$(By.xpath("//a[contains(@class,'name') and contains(text(),'Тест')]"));
    private final SelenideElement labelOfLoading = $(By.xpath("//div[@class='v-overlay__scrim']"));

    public CandidatesListPage clickToFilter(){
        step("Click To The Filter ",()->
        $(By.xpath("//ul[@class='sorting-btn']//li")).hover().click());
        return this;
    }

    public CandidatesListPage clickSortedBy(){
        step("Click To Sorting By",()->
        $(By.id("ex_employees_select_plaseholder")).click());
        return this;
    }

    public CandidatesListPage selectOnlyExEmployee(){
        step("Select Only Ex Employee ",()->
        $(By.xpath("//p[contains(@data-value,'only')]")).click());
        return this;
    }

    public CandidatePage selectCandidate(){
        step("Select Candidate",()->
        listOfTestEmployee.last().shouldBe(Condition.visible).click());
        return new CandidatePage();
    }

    public CandidatesListPage selectPage(){
        step("Select Page",()->
        $(By.xpath("//ul[@role='navigation']//li//a")).click());
        return this;
    }
}

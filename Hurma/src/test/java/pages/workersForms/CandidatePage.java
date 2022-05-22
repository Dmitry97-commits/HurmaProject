package pages.workersForms;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static io.qameta.allure.Allure.step;

public class CandidatePage {

    public CandidatePage clickToTheThreeDots(){
        step("Click To Three Dots",()-> {
            switchTo().window(1);
            $(By.xpath("//div[@class='blue-hover']")).hover();
        });
        return this;
    }

    public CandidatePage deletedFromRemoved(){
        step("Delete From Removed",()->
        $(By.id("candidateSoftDeleteActions")).click());
        return this;
    }

    public CandidatePage asseptDeleting(){
        step("Assert Deleting From Removed",()->
        $(By.id("soft-remove-candidate")).click());
        return this;
    }

    public static Boolean isCandidateRemoved(){
        step("Check Candidate Is Removed");
        return $(By.id("removedBlockLabel")).shouldBe(Condition.visible).isDisplayed();
    }
}

package pages.workersForms;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class CandidatePage {

    public CandidatePage clickToTheThreeDots(){
        switchTo().window(1);
        $(By.xpath("//div[@class='blue-hover']")).hover();
        return this;
    }

    public CandidatePage deletedFromRemoved(){
        $(By.id("candidateSoftDeleteActions")).click();
        return this;
    }

    public CandidatePage asseptDeleting(){
        $(By.id("soft-remove-candidate")).click();
        return this;
    }

    public static Boolean isCandidateRemoved(){
        return $(By.id("removedBlockLabel")).shouldBe(Condition.visible).isDisplayed();
    }
}

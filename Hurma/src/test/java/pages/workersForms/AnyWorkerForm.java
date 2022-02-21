package pages.workersForms;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AnyWorkerForm {

    public AnyWorkerForm clickByCompanyField(){
        $(By.xpath("//h3[contains(@class,'expansion-panel')]//div[contains(text(),'Компания')]")).click();
        return this;
    }

    public static Boolean checkTextFromFieldByInformationField(String expectedValue){
        var x = $(By.xpath(String.format("//li[@class='user-info__item']//span[contains(text(),'%s')]",expectedValue)));
        System.out.println(x.getText());
        return x.isDisplayed();
    }

    public AnyWorkerForm clickEllipsis(){
        $(By.xpath("//button[@data-mdja='01-06']")).click();
        return this;
    }

    public AnyWorkerForm clickRemove(){
        $(By.id("list-item-180")).click();
        return this;
    }

    public AnyWorkerForm removeEmployee(){
        $(By.id("input-189")).click();
        var enabledDates = $$(By.xpath("//button[@class='v-btn v-btn--text v-btn--rounded theme--light']"));
        enabledDates.get(enabledDates.size()-1).click();
        $(By.xpath("//div[@class='content-select']")).click();
        var variousForRemove = $$(By.xpath("//div//p[@class='name']"));
        variousForRemove.get(variousForRemove.size()-1).click();
        $(By.xpath("//button//span[contains(text(),'Уволить')]")).click();
        return this;
    }

    public static Boolean isDisplayedLabelSoonRemove(){
        return $(By.xpath("//span[@class='v-chip__content']")).shouldBe(Condition.visible).isDisplayed();
    }
}

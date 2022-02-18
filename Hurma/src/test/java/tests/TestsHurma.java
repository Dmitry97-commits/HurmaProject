package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.CreateEmployeePage;
import pages.MainPage;
import utils.RandomUtils;

public class TestsHurma extends BaseTest{

    public MainPage mainPage = new MainPage();
    String randomStr = RandomUtils.RandomString(10);
    String emailRnd = String.format("%s@gmail.com",RandomUtils.RandomString(5));
    String nameWithNum = String.format("Тестовый Сотрудник %s",RandomUtils.RandomInt(10));

    @Test
    public void CreatedEmployeeTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickCreateButton()
                .clickToTheRespHr()
                .selectRole("Сотрудник")
                .enterName(nameWithNum)
                .enterEmail(emailRnd)
                .enterResponsible(randomStr)
                .selectDateForTrainee()
                .clickSubmitButton();

        Assert.assertEquals("Employee doesn't created",nameWithNum,CreateEmployeePage.checkCreatedByName());
    }

    @Test
    public void CreatedRecruiterTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickCreateButton()
                .clickToTheRespHr()
                .selectRole("Рекрутер")
                .enterName(nameWithNum)
                .enterEmail(emailRnd)
                .enterResponsible(randomStr)
                .selectDateForTrainee()
                .clickSubmitButton();

        Assert.assertEquals("Recruiter doesn't created",nameWithNum,CreateEmployeePage.checkCreatedByName());
    }

    @Test
    public void CreatedManagerOfTeamTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickCreateButton()
                .clickToTheRespHr()
                .selectRole("Менеджер команды")
                .enterName(nameWithNum)
                .enterEmail(emailRnd)
                .enterResponsible(randomStr)
                .selectDateForTrainee()
                .clickSubmitButton();

        Assert.assertEquals("Manager of team doesn't created",nameWithNum,CreateEmployeePage.checkCreatedByName());
    }

    @Test
    public void CreatedManagerOfCompanyTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickCreateButton()
                .clickToTheRespHr()
                .selectRole("Менеджер компании")
                .enterName(nameWithNum)
                .enterEmail(emailRnd)
                .enterResponsible(randomStr)
                .selectDateForTrainee()
                .clickSubmitButton();

        Assert.assertEquals("Manager of company doesn't created",nameWithNum,CreateEmployeePage.checkCreatedByName());
    }

    @Test
    public void CreatedHRTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickCreateButton()
                .clickToTheRespHr()
                .selectRole("HR")
                .enterName(nameWithNum)
                .enterEmail(emailRnd)
                .enterResponsible(randomStr)
                .selectDateForTrainee()
                .clickSubmitButton();

        Assert.assertEquals("HR doesn't created",nameWithNum,CreateEmployeePage.checkCreatedByName());
    }

    @Test
    public void CreatedAdminTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickCreateButton()
                .clickToTheRespHr()
                .selectRole("Администратор")
                .enterName(nameWithNum)
                .enterEmail(emailRnd)
                .enterResponsible(randomStr)
                .selectDateForTrainee()
                .clickSubmitButton();

        Assert.assertEquals("Admin doesn't created",nameWithNum,CreateEmployeePage.checkCreatedByName());
    }

    @Test
    public void RemoveEmployeeTest(){
        mainPage
                .clickToTheCompanyTab()
                .selectPage(9)
                .selectEmployee()
                .clickEllipsis()
                .clickRemove()
                .removeEmployee();
        //кандидат появляется на след день ?????
    }

    @Test
    public void DeletingFromRemovedTest(){
        mainPage
                .clickToTheCandidatesTab()
                .clickToFilter()
                .clickSortedBy()
                .selectOnlyExEmployee()
                .selectCandidate()
                .clickToTheThreeDots()
                .deletedFromRemoved()
                .asseptDeleting();
        //добавить ассерт
    }

    @Test
    public void SortedByProbationTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .selectProbation();
        //добавить ассерт
    }
}

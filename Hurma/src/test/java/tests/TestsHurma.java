package tests;

import org.junit.Assert;
import org.testng.annotations.Test;
import pages.EmployeesPage;
import pages.workersForms.AnyWorkerForm;
import pages.workersForms.CandidatePage;
import pages.workersForms.CreateEmployeePage;
import pages.MainPage;
import resources.TestData;
import utils.RandomUtils;

public class TestsHurma extends BaseTest{

    public MainPage mainPage = new MainPage();
    String randomStr = RandomUtils.RandomString(10);
    EmployeesPage employeesPage = new EmployeesPage();


    @Test
    public void CreatedEmployeeTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickCreateButton()
                .clickToTheRespHr()
                .selectRole(TestData.employee)
                .enterName(String.format("Тестовый Сотрудник %s",RandomUtils.RandomInt(10)))
                .enterEmail(String.format("%s@gmail.com",RandomUtils.RandomString(5)))
                .enterResponsible(randomStr)
                .selectDateForTrainee()
                .clickSubmitButton()
                .clickByCompanyField();

        Assert.assertTrue("Employee doesn't created",AnyWorkerForm.checkTextFromFieldByInformationField(TestData.employee));
    }

    @Test
    public void CreatedRecruiterTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickCreateButton()
                .clickToTheRespHr()
                .selectRole(TestData.recruiter)
                .enterName(String.format("Тестовый Рекрутер %s",RandomUtils.RandomInt(10)))
                .enterEmail(String.format("%s@gmail.com",RandomUtils.RandomString(5)))
                .enterResponsible(randomStr)
                .selectDateForTrainee()
                .clickSubmitButton()
                .clickByCompanyField();

        Assert.assertTrue("Recruiter doesn't created",AnyWorkerForm.checkTextFromFieldByInformationField(TestData.recruiter));
    }

    @Test
    public void CreatedManagerOfTeamTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickCreateButton()
                .clickToTheRespHr()
                .selectRole(TestData.managerOfTeam)
                .enterName(String.format("Тестовый Менеджер команды %s",RandomUtils.RandomInt(10)))
                .enterEmail(String.format("%s@gmail.com",RandomUtils.RandomString(5)))
                .enterResponsible(randomStr)
                .selectDateForTrainee()
                .clickSubmitButton()
                .clickByCompanyField();

        Assert.assertTrue("Manager of team doesn't created",AnyWorkerForm.checkTextFromFieldByInformationField(TestData.managerOfTeam));
    }

    @Test
    public void CreatedManagerOfCompanyTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickCreateButton()
                .clickToTheRespHr()
                .selectRole(TestData.managerOfCompany)
                .enterName(String.format("Тестовый Менеджер компании %s",RandomUtils.RandomInt(10)))
                .enterEmail(String.format("%s@gmail.com",RandomUtils.RandomString(5)))
                .enterResponsible(randomStr)
                .selectDateForTrainee()
                .clickSubmitButton()
                .clickByCompanyField();

        Assert.assertTrue("Manager of company doesn't created",AnyWorkerForm.checkTextFromFieldByInformationField(TestData.managerOfCompany));
    }

    @Test
    public void CreatedHRTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickCreateButton()
                .clickToTheRespHr()
                .selectRole(TestData.hr)
                .enterName(String.format("Тестовый Менеджер компании %s",RandomUtils.RandomInt(10)))
                .enterEmail(String.format("%s@gmail.com",RandomUtils.RandomString(5)))
                .enterResponsible(randomStr)
                .selectDateForTrainee()
                .clickSubmitButton()
                .clickByCompanyField();

        Assert.assertTrue("HR doesn't created",AnyWorkerForm.checkTextFromFieldByInformationField(TestData.hr));
    }

    @Test
    public void CreatedAdminTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickCreateButton()
                .clickToTheRespHr()
                .selectRole(TestData.admin)
                .enterName(String.format("Тестовый Менеджер компании %s",RandomUtils.RandomInt(10)))
                .enterEmail(String.format("%s@gmail.com",RandomUtils.RandomString(5)))
                .enterResponsible(randomStr)
                .selectDateForTrainee()
                .clickSubmitButton()
                .clickByCompanyField();

        Assert.assertTrue("Admin doesn't created",AnyWorkerForm.checkTextFromFieldByInformationField(TestData.admin));
    }

    @Test
    public void EMAIL(){

    }

    @Test
    public void LOGEMAIL(){

    }

    @Test
    public void RemoveEmployeeTest(){
        mainPage
                .clickToTheCompanyTab()
                .selectPage(9)
                .selectTestEmployee()
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
        Assert.assertTrue("Candidate wasnt removed",CandidatePage.isCandidateRemoved());
    }

    @Test
    public void SortedByProbationTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .selectProbation()
                .selectEmployee()
                .clickByCompanyField();
        Assert.assertTrue("Doesn't sorted by probation",AnyWorkerForm.checkTextFromFieldByInformationField("Исп. период"));
    }

    @Test
    public void SortedByCooperationTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .selectCooperation()
                .selectEmployee()
                .clickByCompanyField();

        Assert.assertTrue("Doesn't sorted by cooperation",AnyWorkerForm.checkTextFromFieldByInformationField("Сотрудник"));

    }

    @Test
    public void SortedByFinishCooperationTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .selectFinishOfCooperation()
                .selectEmployee();

        Assert.assertTrue("Doesn't sorted by cooperation",AnyWorkerForm.isDisplayedLabelSoonRemove());
    }

    @Test
    public void SortedByTeamTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .selectByTeam()
                .selectTeam();
                //.selectEmployee();

        //Assert.assertTrue("Doesn't sorted by cooperation",AnyWorkerForm.checkTextFromFieldByInformationField(team));
    }

    @Test
    public void SortedByPlaceTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .selectByPlace()
                .selectCountry()
                .selectEmployee()
                .clickByCompanyField();

        Assert.assertTrue("Doesn't sorted by cooperation",AnyWorkerForm.checkTextFromFieldByInformationField("sasdas"));
    }
}

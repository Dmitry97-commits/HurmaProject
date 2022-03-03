package tests;

import org.junit.Assert;
import org.testng.annotations.Test;
import pages.EmployeesPage;
import pages.MainPage;
import pages.workersForms.AnyWorkerForm;
import resources.TestData;
import utils.RandomUtils;

public class CreateEmployeeTests extends BaseTest {

    public MainPage mainPage = new MainPage();
    String randomStr = RandomUtils.RandomString(10);

    @Test(priority = 1)
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

        Assert.assertTrue("Employee doesn't created", AnyWorkerForm.checkTextFromFieldByInformationField(TestData.employee));
    }

    @Test(priority = 2)
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

    @Test(priority = 3)
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

    @Test(priority = 4)
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

    @Test(priority = 5)
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

    @Test(priority = 6)
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
}

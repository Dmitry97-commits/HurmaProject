package tests;

import org.junit.Assert;
import org.testng.annotations.Test;
import pages.EmployeesPage;
import pages.workersForms.AnyWorkerForm;
import pages.workersForms.CandidatePage;
import pages.MainPage;
import resources.TestData;
import utils.DateUtils;
import utils.RandomUtils;

public class TestsHurma extends BaseTest{

    public MainPage mainPage = new MainPage();
    String randomStr = RandomUtils.RandomString(10);
    EmployeesPage employeesPage = new EmployeesPage();


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

        Assert.assertTrue("Employee doesn't created",AnyWorkerForm.checkTextFromFieldByInformationField(TestData.employee));
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

    @Test(priority = 7)
    public void EMAIL(){

    }

    @Test(priority = 8)
    public void LOGEMAIL(){

    }

    @Test(priority = 9)
    public void RemoveEmployeeTest(){
        mainPage
                .clickToTheCompanyTab();
                //.selectPage(9);
               // .selectTestEmployee()
                //.clickEllipsis()
                //.clickRemove()
                //.removeEmployee();
        //кандидат появляется на след день ?????
    }

    @Test(priority = 10)
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

    @Test(priority = 11)
    public void SortedByProbationTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .selectProbation()
                .selectEmployee()
                .clickByCompanyField();

        Assert.assertTrue("Doesn't sorted by probation",AnyWorkerForm.checkTextFromFieldByInformationField("Исп. период"));
    }

    @Test(priority = 12)
    public void SortedByCooperationTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .selectCooperation()
                .selectEmployee()
                .clickByCompanyField();

        Assert.assertTrue("Doesn't sorted by cooperation",AnyWorkerForm.checkTextFromFieldByInformationField("Сотрудник"));

    }

    @Test(priority = 13)
    public void SortedByFinishCooperationTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .selectFinishOfCooperation()
                .selectEmployee();

        Assert.assertTrue("Doesn't sorted by cooperation",AnyWorkerForm.isDisplayedLabelSoonRemove());
    }

    @Test(priority = 14)
    public void SortedByTeamTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .selectByTeam();
                String team = employeesPage.selectTeam();
                employeesPage.selectTestEmployee()
                        .clickByCompanyField();

        Assert.assertTrue("Doesn't sorted by team",AnyWorkerForm.checkTextFromFieldByInformationField(team));
    }

    @Test(priority = 15)
    public void SortedByPlaceTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .selectByPlace()
                .selectCountry()
                .selectTestEmployee()
                .clickByPlaceOfLifeField();

        Assert.assertTrue("Doesn't sorted by place",AnyWorkerForm.checkTextFromFieldByInformationField("Великобритания, Лондон"));
    }

    @Test(priority = 16)
    public void SortedByTagTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .selectByTag()
                .selectTag()
                .selectTestEmployee();

        Assert.assertTrue("Doesn't sorted by tag",AnyWorkerForm.checkTags(".NET Core"));
    }

    @Test(priority = 17)
    public void SortedByEventTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .selectByEvent()
                .selectEvent();

        Assert.assertTrue("Doesn't sorted by event",EmployeesPage.checkEvent("1:1"));
    }

    @Test(priority = 18)
    public void SortedByLevelTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .selectByLevel()
                .selectLevel()
                .selectTestEmployee()
                .clickByCompanyField();

       Assert.assertTrue("Doesn't sorted by level",AnyWorkerForm.checkTextFromFieldByInformationField("Junior"));
    }

    @Test(priority = 19)
    public void SortedByResponsibleTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .selectByResponsible()
                .selectResponsible()
                .selectTestEmployee()
                .clickByCompanyField();

        Assert.assertTrue("Doesn't sorted by responsible",AnyWorkerForm.checkTextFromFieldByInformationField("тест"));
    }

    @Test(priority = 20)
    public void SortedBySkillsTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .selectBySkills()
                .selectSkill()
                .selectTestEmployee()
                .clickBySkillsAndAwards();

        Assert.assertTrue("Doesn't sorted by skills",AnyWorkerForm.checkTextFromFieldByInformationField("UI/UX"));
    }

    @Test(priority = 21)
    public void SortedByExEmployessTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .clickCheckBoxEmployee()
                .selectEmployee()
                .clickByCompanyField();

        Assert.assertTrue("Doesn't sorted by employee",AnyWorkerForm.checkTextFromFieldByInformationField(TestData.employee));
    }

    @Test(priority = 22)
    public void SortedExByExEmployeesTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .clickCheckBoxExEmployee();

        Assert.assertTrue("Doesn't sorted by ex employee",EmployeesPage.checkExEmployee());

    }

    @Test(priority = 23)
    public void SortedLanguageSkillsTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .selectByLanguageSkills()
                .selectLanguage()
                .selectLevelOfLanguage()
                .selectTestEmployee()
                .clickByLanguagesAndEducation();

        Assert.assertTrue("Doesn't sorted by ex employee",AnyWorkerForm.checkTextFromFieldByInformationField("Английский - Beginner"));

    }

    @Test(priority = 24)
    public void SortedByWithoutAgeTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .clickCheckBoxWithoutAge()
                .selectTestEmployee()
                .clickByAgeAndSex();

        Assert.assertTrue("Doesn't sorted by ex employee",AnyWorkerForm.checkTextFromFieldByInformationFieldIsEmpty("dasda"));

    }

    @Test(priority = 25)
    public void SortedByWithAgeTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .clickCheckBoxAge()
                .enterAgeLowBorder("32");
                //enterAgeHighBorder("33")
                //.selectTestEmployee()
                //.clickByAgeAndSex();

        //Assert.assertTrue("Doesn't sorted by ex employee",AnyWorkerForm.checkTextFromFieldByInformationFieldIsEmpty("dasda"));

    }

    @Test(priority = 26)
    public void SortedByStartWorkDateTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .clickByDateStartedWork()
                .selectPeriodLastYear()
                .selectTestEmployee()
                .clickByCompanyField();


        Assert.assertTrue("Doesn't sorted by ex employee",AnyWorkerForm.checkTextFromFieldByInformationField("2021"));
    }

    @Test(priority = 27)
    public void SortedByStartWorkDateWithAnotherParamTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .clickByDateStartedWork()
                .selectPeriod()
                .enterTodayDay()
                .selectTestEmployee()
                .clickByCompanyField();

        Assert.assertTrue("Doesn't sorted by ex employee",AnyWorkerForm.checkTextFromFieldByInformationField(DateUtils.getTodayDate()));
    }

    @Test(priority = 28)
    public void SortedByHavingChildrenTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .selectChildrenYes()
                .selectTestEmployee()
                .clickByPersonalInfoTab();

        Assert.assertTrue("Doesn't sorted by having children",AnyWorkerForm.checkHavingChildren());
    }

    @Test(priority = 29)
    public void SortedByNotHavingChildrenTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .selectChildrenNo()
                .selectEmployee()
                .clickByPersonalInfoTab();

        Assert.assertFalse("Doesn't sorted by not a having children",AnyWorkerForm.checkHavingChildren());
    }

    @Test(priority = 30)
    public void SortedByDateOfBirthDayTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .selectByDateOfBirthday()
                .selectMonthOfDateOfBirthday()
                .selectEmployee()
                .clickByAgeAndSex();

        Assert.assertTrue("Doesn't sorted by date of birthday ",AnyWorkerForm.checkTextFromFieldByInformationField("мар"));
    }

    @Test(priority = 31)
    public void SortedByAbsenceFromWorkTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .selectByAbsenceFromWork()
                .selectAbsence()
                .selectEmployee()
                .clickByRequestTab();


        Assert.assertTrue("Doesn't sorted by date of absence",AnyWorkerForm.requestIsDisplayed());
    }

    @Test(priority = 32)
    public void SortedByRoleInSystemTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .selectByRoleInSystem()
                .selectRole()
                .selectTestEmployee()
                .clickByCompanyField();

        Assert.assertTrue("Doesn't sorted by role",AnyWorkerForm.checkTextFromFieldByInformationField(TestData.admin));
    }

    @Test(priority = 33)
    public void SortedByMaritalStatusTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .selectByMaritalStatus()
                .selectMaritalStatus()
                .selectTestEmployee()
                .clickByPersonalInfoTab();

        Assert.assertTrue("Doesn't sorted by marital status",AnyWorkerForm.checkMaritalStatus());
    }

    @Test(priority = 34)
    public void SortedByExperienceTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .selectByExperience()
                .selectExperience()
                .selectTestEmployee()
                .clickByCompanyField();

        Assert.assertTrue("Doesn't sorted by marital status",AnyWorkerForm.checkTextFromFieldByInformationField("2010"));
    }

    @Test(priority = 35)
    public void SortedByFormOfCooperationEmpTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .clickCheckBoxEmployeeFormOfWork()
                .selectEmployee()
                .clickByCompanyField();

        Assert.assertTrue("Doesn't sorted by marital status",AnyWorkerForm.checkTextFromFieldByInformationField(TestData.employee));
    }

    @Test(priority = 36)
    public void SortedByFormOfCooperationWithoutTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .clickCheckBoxWithoutFormOfWork()
                .selectTestEmployee()
                .clickByCompanyField();

        Assert.assertTrue("Doesn't sorted by marital status",AnyWorkerForm.checkTextFromFieldByInformationField("Внештатный"));
    }

    @Test(priority = 37)
    public void SortedByFormOfCooperationFlpTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .clickCheckBoxFlptFormOfWork()
                .selectEmployee()
                .clickByCompanyField();

        Assert.assertTrue("Doesn't sorted by marital status",AnyWorkerForm.checkTextFromFieldByInformationField("ФЛП"));
    }
}

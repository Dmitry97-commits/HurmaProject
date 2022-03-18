package tests;

import org.junit.Assert;
import org.junit.Ignore;
import org.testng.annotations.Test;
import pages.EmployeesPage;
import pages.MainPage;
import pages.workersForms.AnyWorkerForm;
import resources.TestData;
import utils.DateUtils;

public class SortingTests extends BaseTest{

    public MainPage mainPage = new MainPage();
    EmployeesPage employeesPage = new EmployeesPage();

    @Test(priority = 1)
    public void SortedByProbationTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .clickResetButton()
                .selectProbation()
                .selectEmployee()
                .clickByCompanyField();

        Assert.assertTrue("Doesn't sorted by probation", AnyWorkerForm.checkTextFromFieldByInformationField("Исп. период"));
    }

    @Test(priority = 2)
    public void SortedByCooperationTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .clickResetButton()
                .selectCooperation()
                .selectEmployee()
                .clickByCompanyField();

        Assert.assertTrue("Doesn't sorted by cooperation",AnyWorkerForm.checkTextFromFieldByInformationField("Сотрудник"));

    }

    @Test(priority = 3)
    public void SortedByFinishCooperationTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .clickResetButton()
                .selectFinishOfCooperation()
                .selectTestEmployee();

        Assert.assertTrue("Doesn't sorted by cooperation",AnyWorkerForm.isDisplayedLabelSoonRemove());
    }

    @Test(priority = 4)
    public void SortedByTeamTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .clickResetButton()
                .selectByTeam();
        String team = employeesPage.selectTeam();
        employeesPage.selectTestEmployee()
                .clickByCompanyField();

        Assert.assertTrue("Doesn't sorted by team",AnyWorkerForm.checkTextFromFieldByInformationField(team));
    }

    @Test(priority = 5)
    public void SortedByPlaceTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .clickResetButton()
                .selectByPlace()
                .selectCountry()
                .selectTestEmployee()
                .clickByPlaceOfLifeField();

        Assert.assertTrue("Doesn't sorted by place",AnyWorkerForm.checkTextFromFieldByInformationField("Великобритания, Лондон"));
    }

    @Test(priority = 6)
    public void SortedByTagTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .clickResetButton()
                .selectByTag()
                .selectTag()
                .selectTestEmployee();

        Assert.assertTrue("Doesn't sorted by tag",AnyWorkerForm.checkTags(".NET Core"));
    }

    @Test(priority = 7)
    public void SortedByEventTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .clickResetButton()
                .selectByEvent()
                .selectEvent();

        Assert.assertTrue("Doesn't sorted by event", EmployeesPage.checkEvent("Performance review"));
    }

    @Test(priority = 8)
    public void SortedByLevelTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .clickResetButton()
                .selectByLevel()
                .selectLevel()
                .selectTestEmployee()
                .clickByCompanyField();

        Assert.assertTrue("Doesn't sorted by level",AnyWorkerForm.checkTextFromFieldByInformationField("Junior"));
    }

    @Test(priority = 9)
    public void SortedByResponsibleTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .clickResetButton()
                .selectByResponsible()
                .selectResponsible()
                .selectTestEmployee()
                .clickByCompanyField();

        Assert.assertTrue("Doesn't sorted by responsible",AnyWorkerForm.checkTextFromFieldByInformationField("тест"));
    }

    @Test(priority = 10)
    public void SortedBySkillsTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .clickResetButton()
                .selectBySkills()
                .selectSkill()
                .selectTestEmployee()
                .clickBySkillsAndAwards();

        Assert.assertTrue("Doesn't sorted by skills",AnyWorkerForm.checkTextFromFieldByInformationField("UI/UX"));
    }

    @Test(priority = 11)
    public void SortedByExEmployessTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .clickResetButton()
                .clickCheckBoxEmployee()
                .selectEmployee()
                .clickByCompanyField();

        Assert.assertTrue("Doesn't sorted by employee",AnyWorkerForm.checkTextFromFieldByInformationField(TestData.employee));
    }

    @Test(priority = 12)
    public void SortedExByExEmployeesTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .clickResetButton()
                .clickCheckBoxExEmployee();

        Assert.assertTrue("Doesn't sorted by ex employee",EmployeesPage.checkExEmployee());

    }

    @Test(priority = 13)
    public void SortedLanguageSkillsTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .clickResetButton()
                .selectByLanguageSkills()
                .selectLanguage()
                .selectLevelOfLanguage()
                .selectTestEmployee()
                .clickByLanguagesAndEducation();

        Assert.assertTrue("Doesn't sorted by ex employee",AnyWorkerForm.checkTextFromFieldByInformationField("Английский - Beginner"));

    }

    @Test(priority = 14)
    public void SortedByWithoutAgeTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .clickResetButton()
                .clickCheckBoxWithoutAge()
                .selectEmployee()
                .clickByAgeAndSex();

        Assert.assertFalse("Doesn't sorted by ex employee",AnyWorkerForm.checkTextFromFieldByInformationFieldIsEmpty("Возраст"));

    }

    @Ignore
    @Test(priority = 15)
    public void SortedByWithAgeTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .clickResetButton()
                .clickCheckBoxAge()
                //.enterAgeLowBorder("32")
                //.enterAgeHighBorder("33")
                //.clickOk()
                .selectEmployee()
                .clickByAgeAndSex();

        Assert.assertFalse("Doesn't sorted by age employee",AnyWorkerForm.checkTextFromFieldByInformationFieldIsEmpty(""));

    }

    @Test(priority = 16)
    public void SortedByStartWorkDateTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .clickResetButton()
                .clickByDateStartedWork()
                .selectPeriodLastYear()
                .selectTestEmployee()
                .clickByCompanyField();


        Assert.assertTrue("Doesn't sorted by start of work",AnyWorkerForm.checkTextFromFieldByInformationField("2021"));
    }

    @Test(priority = 17)
    public void SortedByStartWorkDateWithAnotherParamTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .clickResetButton()
                .clickByDateStartedWork()
                .selectPeriod()
                .enterTodayDay()
                .selectTestEmployee()
                .clickByCompanyField();

        Assert.assertTrue("Doesn't sorted by ex employee",AnyWorkerForm.checkTextFromFieldByInformationField(DateUtils.getTodayDate()));
    }

    @Test(priority = 18)
    public void SortedByHavingChildrenTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .clickResetButton()
                .selectChildrenYes()
                .selectTestEmployee()
                .clickByPersonalInfoTab();

        Assert.assertTrue("Doesn't sorted by having children",AnyWorkerForm.checkHavingChildren());
    }

    @Test(priority = 19)
    public void SortedByNotHavingChildrenTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .clickResetButton()
                .selectChildrenNo()
                .selectEmployee()
                .clickByPersonalInfoTab();

        Assert.assertTrue("Doesn't sorted by not a having children",AnyWorkerForm.checkHavingChildren());
    }

    @Test(priority = 20)
    public void SortedByDateOfBirthDayTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .clickResetButton()
                .selectByDateOfBirthday()
                .selectMonthOfDateOfBirthday()
                .selectTestEmployee()
                .clickByAgeAndSex();

        Assert.assertTrue("Doesn't sorted by date of birthday ",AnyWorkerForm.checkTextFromFieldByInformationField("мар"));
    }

    @Test(priority = 21)
    public void SortedByAbsenceFromWorkTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .clickResetButton()
                .selectByAbsenceFromWork()
                .selectAbsence()
                .selectEmployee()
                .clickByRequestTab();

        Assert.assertTrue("Doesn't sorted by date of absence",AnyWorkerForm.requestIsDisplayed());
    }

    @Test(priority = 22)
    public void SortedByRoleInSystemTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .clickResetButton()
                .selectByRoleInSystem()
                .selectRole()
                .selectEmployee()
                .clickByCompanyField();

        Assert.assertTrue("Doesn't sorted by role",AnyWorkerForm.checkTextFromFieldByInformationField(TestData.admin));
    }

    @Test(priority = 23)
    public void SortedByMaritalStatusTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .clickResetButton()
                .selectByMaritalStatus()
                .selectMaritalStatus()
                .selectTestEmployee()
                .clickByPersonalInfoTab();

        Assert.assertTrue("Doesn't sorted by marital status",AnyWorkerForm.checkMaritalStatus());
    }

    @Test(priority = 24)
    public void SortedByExperienceTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .clickResetButton()
                .selectByExperience()
                .selectExperience()
                .selectTestEmployee()
                .clickByCompanyField();

        Assert.assertTrue("Doesn't sorted by experience",AnyWorkerForm.checkTextFromFieldByInformationField("2010"));
    }

    @Test(priority = 25)
    public void SortedByFormOfCooperationEmpTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .clickResetButton()
                .clickCheckBoxEmployeeFormOfWork()
                .selectEmployee()
                .clickByCompanyField();

        Assert.assertTrue("Doesn't sorted by form of cooperation",AnyWorkerForm.checkTextFromFieldByInformationField(TestData.employee));
    }

    @Test(priority = 26)
    public void SortedByFormOfCooperationWithoutTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .clickResetButton()
                .clickCheckBoxWithoutFormOfWork()
                .selectTestEmployee()
                .clickByCompanyField();

        Assert.assertTrue("Doesn't sorted by form of cooperation",AnyWorkerForm.checkTextFromFieldByInformationField("Внештатный"));
    }

    @Test(priority = 27)
    public void SortedByFormOfCooperationFlpTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .clickResetButton()
                .clickCheckBoxFlpFormOfWork()
                .selectEmployee()
                .clickByCompanyField();

        Assert.assertTrue("Doesn't sorted by FLP",AnyWorkerForm.checkTextFromFieldByInformationField("ФЛП"));
    }

    @Test(priority = 28)
    public void SortedBySexTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .clickResetButton()
                .clickCheckBoxWithoutSex()
                .selectEmployee()
                .clickByAgeAndSex();

        Assert.assertTrue("Doesn't sorted by sex",AnyWorkerForm.checkTextFromFieldByInformationField("Не выбран"));
    }

    @Test(priority = 29)
    public void SortedByMaleTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .clickResetButton()
                .clickCheckBoxMaleSex()
                .selectEmployee()
                .clickByAgeAndSex();

        Assert.assertTrue("Doesn't sorted by sex",AnyWorkerForm.checkTextFromFieldByInformationField("Мужской"));
    }

    @Test(priority = 30)
    public void SortedByFemaleTest(){
        mainPage
                .clickToTheCompanyTab()
                .clickToFilter()
                .clickResetButton()
                .clickCheckBoxFemaleSex()
                .selectEmployee()
                .clickByAgeAndSex();

        Assert.assertTrue("Doesn't sorted by sex",AnyWorkerForm.checkTextFromFieldByInformationField("Женский"));
    }
}

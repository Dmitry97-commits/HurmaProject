package listener;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.ITestContext;
import org.testng.ITestListener;

import org.testng.ITestResult;
import tests.BaseTest;

import java.io.IOException;

public class ListenerAllure extends BaseTest implements ITestListener {


    @Override
    public void onTestStart(ITestResult iTestResult) {
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        try {
            Allure.addAttachment("screenshot", FileUtils.openInputStream(Selenide.screenshot(OutputType.FILE)));
        } catch (IOException e) {
            e.printStackTrace();
        }    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}

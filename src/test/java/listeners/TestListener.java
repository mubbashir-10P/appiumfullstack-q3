package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.Utilities;

public class TestListener implements ITestListener {
    private static Utilities utilities = new Utilities();
    @Override
    public void onTestStart(ITestResult result){
        String testStartMessage = String.format("Test Execution Started");
        utilities.log().info("-------------------------------------------");
        utilities.log().info(testStartMessage);

    }

    @Override
    public void onTestSuccess(ITestResult result){
        String testStartMessage = String.format("Testcase: '%s' passed successfully",result.getMethod().getMethodName());
        utilities.log().info(testStartMessage);
    }

    @Override
    public void onFinish(ITestContext context){
        utilities.log().info("Test Finished");
        utilities.log().info("-------------------------------------------");
    }

    @Override
    public void onTestSkipped(ITestResult result){
        utilities.log().info("Test Skipped");
    }

    @Override
    public void onTestFailure(ITestResult result){
        String testStartMessage = String.format("Testcase: '%s' failed!",result.getMethod().getMethodName());
        utilities.log().info(testStartMessage);
    }
}

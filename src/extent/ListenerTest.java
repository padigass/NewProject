package extent;

import com.relevantcodes.extentreports.*;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.internal.IResultListener;
public class ListenerTest extends MainTest implements IResultListener {
	ExtentTest testReporter;
	
	/*ExtentReports reporter = new ExtentReports("build/" + getClass() + "Report.html", true, DisplayOrder.NEWEST_FIRST,
			NetworkMode.ONLINE, Locale.ENGLISH);*/

	@Override
	public void onTestStart(ITestResult result) {
		on(className,result.getTestClass().getName());
		testReporter = reporter.startTest(result.getMethod().getMethodName(), "Some description");
		testCommon.log(LogStatus.INFO, "Starting test " + result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		testCommon.log(LogStatus.PASS, "Test PASSED");
		String screenShotPath;
		try {
			screenShotPath = GetScreenShot.takeScreenShot(driver, "screenShotName");
			testCommon.log(LogStatus.PASS, "Snapshot elow: " + testReporter.addScreenCapture(screenShotPath));
			System.out.println(result.getMethod().getMethodName() + "Passed");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String screenShotPath;
		try {
			screenShotPath = GetScreenShot.takeScreenShot(driver, "screenShotName");
			testCommon.log(LogStatus.FAIL, "Snapshot below: " + testReporter.addScreenCapture(screenShotPath));
			System.out.println(result.getMethod().getMethodName() + "Failed");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onConfigurationSuccess(ITestResult itr) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onConfigurationFailure(ITestResult itr) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onConfigurationSkip(ITestResult itr) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		reporter.flush();
		//
		// reporter.close();
		reporter.endTest(testReporter);
	}



	// Other interface methods
}
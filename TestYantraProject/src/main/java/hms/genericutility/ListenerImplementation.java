package hms.genericutility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener {
	
	
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
	test = report.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName());
		test.log(Status.PASS, result.getThrowable());
	}

	@Override
	public void onTestFailure(ITestResult result) {

		test.log(Status.FAIL, result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getThrowable());
		
		WebActionUtility.takeScreenShot(result.getMethod().getMethodName(), BaceClass.listenerDriver);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
	}

//	@Override
//	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//		
//	}
//
//	@Override
//	public void onTestFailedWithTimeout(ITestResult result) {
//		
//	}

	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport/report.html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("ExtentReport");
		spark.config().setReportName("Pranab");
		
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("platform", "windows11");
		report.setSystemInfo("Executed by", "Pranab");
		report.setSystemInfo("reviewed by", "Sanjay sir");
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

}

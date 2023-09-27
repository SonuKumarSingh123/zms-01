package com.ZMS.genericUtiliti;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImpClass implements ITestListener {

	ExtentReports report;
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		
		//actual test_script execution starts from here
		String MethodName = result.getMethod().getMethodName();
		test =report.createTest(MethodName);
		Reporter.log(MethodName+"-------> Execution starts");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.PASS, MethodName+"-------->Passed");
		Reporter.log(MethodName+"----------->TestScript executed Successfully");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		/*
		 * TakesScreenshot ts =(TakesScreenshot) BaseClass.sdriver; File src =
		 * ts.getScreenshotAs(OutputType.FILE); File desc =new
		 * File("./screenshots/failedTC.png"); try { FileUtils.copyFile(src, desc); }
		 * catch (IOException e) {
		 * 
		 * e.printStackTrace(); }
		 */
		String MethodName = result.getMethod().getMethodName();
	
		String FailedScript = WebdriverUtility.takeScreenShot(BaseClass.sdriver, MethodName);
		test.addScreenCaptureFromPath(FailedScript);
		
		test.log(Status.FAIL, result.getThrowable());
		test.log(Status.FAIL, MethodName+"----------->Failed");
		Reporter.log(MethodName+"------->TestScript Failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, result.getThrowable());
		test.log(Status.SKIP, MethodName+"------->Skipped");
		Reporter.log(MethodName+"---------->skipped");
	}

	@Override
	public void onStart(ITestContext context) {
		
		// create report
		ExtentSparkReporter htmlreport =new ExtentSparkReporter("./Extentreport/report.html");
		
		htmlreport.config().setDocumentTitle("SDET-51");
		htmlreport.config().setTheme(Theme.STANDARD);
		htmlreport.config().setReportName("ZMS-Application");
		
		report =new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("OS","Window-10");
		report.setSystemInfo("Browser", "chrome");
		report.setSystemInfo("URL", "http://rmgtestingserver/domain/Zoo_Management_System/admin/index.php");
		report.setSystemInfo("Reporter-Name", "Sonu kumar");
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		report.flush();
			}

	
}

package com.ui.listeners;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

import com.utility.LoggerUtility;

public class TestListener implements ITestListener {
	Logger logger = LoggerUtility.getLogger(this.getClass());

	public void onTestStart(ITestResult result) {
		logger.info(result.getMethod().getMethodName());
		logger.info(result.getMethod().getDescription());
		logger.info(Arrays.toString(result.getMethod().getGroups()));
	}

	public void onTestSuccess(ITestResult result) {
		logger.info(result.getMethod().getMethodName() + "" +"PASSED");

	}

	public void onTestFailure(ITestResult result) {
		logger.error(result.getMethod().getMethodName() + "" +"FAILED");
		logger.error(result.getThrowable().getMessage());
	}

	public void onTestSkipped(ITestResult result) {
		logger.warn(result.getMethod().getMethodName() + "" +"SKIPPED");
	}
	
	public void onStart(ITestContext context) {
		logger.info("Test Suite Started");	
	}
	
	public void onFinish(ITestContext context) {
		logger.info("Test Suite Completed");		
	}
	
}

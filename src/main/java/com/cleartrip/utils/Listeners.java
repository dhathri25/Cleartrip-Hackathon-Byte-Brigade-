package com.cleartrip.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners implements ITestListener {
    private ExtentReports extent = ExtentManager.getReportObject();
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        // Automatically creates a test log block when any test starts
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
        extentTest.get().log(Status.INFO, "Test Execution Started: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS, "Test Passed Successfully.");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Logs the exact exception error message and stack trace automatically on failure
        extentTest.get().log(Status.FAIL, "Test Failed!");
        extentTest.get().fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.get().log(Status.SKIP, "Test Skipped.");
    }

    @Override
    public void onFinish(ITestContext context) {
        // CRITICAL STEP: Forces the Extent engine to write the HTML data file to disk
        if (extent != null) {
            extent.flush();
            // UPDATED: Print statement now reflects your new /reports path
            System.out.println("SUCCESS: Extent Report successfully flushed and generated in the /reports folder.");
        }
    }

    // Static helper method to allow your Page Objects or Test Classes to log custom steps
    public static ExtentTest getTest() {
        return extentTest.get();
    }
}
package com.cleartrip.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    public static ExtentReports extent;

    public static ExtentReports getReportObject() {
        if (extent == null) {
            // UPDATED: Points the reporting engine folder tree path strictly to /reports
            String path = System.getProperty("user.dir") + "/reports/ExtentReport.html";
            ExtentSparkReporter reporter = new ExtentSparkReporter(path);
            
            // High-grade UI Report Visual Customizations
            reporter.config().setTheme(Theme.STANDARD);
            reporter.config().setReportName("ClearTrip E2E Automation Results");
            reporter.config().setDocumentTitle("HCLtech Hackathon Framework Metrics Report");

            extent = new ExtentReports();
            extent.attachReporter(reporter);
            
            // Injects environment metadata directly to the report dashboard panel
            extent.setSystemInfo("Testing Environment", "Production Live Grid");
            extent.setSystemInfo("Automation Engineer", "Hema");
            extent.setSystemInfo("Operating System Architecture", System.getProperty("os.name"));
            extent.setSystemInfo("Java Runtime Environment Engine", System.getProperty("java.version"));
        }
        return extent;
    }
}
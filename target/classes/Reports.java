package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {
    static ExtentReports extent;
    public static ExtentReports getReportObject(){
        String path = System.getProperty("user.dir")+"/target/report.html";
        ExtentSparkReporter reporter =  new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("OrangeHRMDemoAtomationResults");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Nikhitha");

        return extent;
    }
}

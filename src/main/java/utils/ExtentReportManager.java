package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager {

    private static ExtentReports extent;
    private static ExtentTest test;

    public static ExtentReports getReportInstance() {

        if (extent == null) {
            String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

            String reportPath = "reports/ExtentReports_"+timeStamp+".html";
            ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);

            reporter.config().setDocumentTitle("Test Report");
            reporter.config().setReportName("ReportName");


            extent =new ExtentReports();
            extent.attachReporter(reporter);

        }

        return extent;
    }

    public static ExtentTest createTest(String testName) {
        test = getReportInstance().createTest(testName);

        return test;
    }

}

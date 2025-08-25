package test;


import base.basetest;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;
import utils.ConfigManager;
import utils.ExcelUtilis;
import utils.ExtentReportManager;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

public class LoginTests extends basetest {


    @DataProvider(name="LoginData")
    public Object [][] getLoginData() throws IOException {

        String filePath = System.getProperty("user.dir")+"/testdata/testdata.xlsx";
        ExcelUtilis.loadExcel(filePath,"Sheet1");
        int rowCount = ExcelUtilis.getRowCount();


        Object[][] loginData = new Object[rowCount-1][2];

        for (int i = 1; i < rowCount-1; i++) {

            loginData[i-1][0] = ExcelUtilis.getCellData(i,0);
            loginData[i-1][1] = ExcelUtilis.getCellData(i,1);
        }
         ExcelUtilis.closeExcel();

        return loginData;

                   }






    @Test(dataProvider = "LoginData")
    //@Parameters({"username","password"})
    public void testLogin(String excelUsername, String excelPassword) throws InterruptedException, IOException {

    test = ExtentReportManager.createTest("My Second Report");

        ConfigManager.loadProperties();
        String username = ConfigManager.getProperties("username");
        String password = ConfigManager.getProperties("password");












    Loginpage loginpage = new Loginpage(driver);
    AdminPage adminpage = new AdminPage(driver);
    AddNewUser addnewuser = new AddNewUser(driver);
    Logout logout = new Logout(driver);
    ClaimPage claimpage = new ClaimPage(driver);

    String adminusername = "admin";
    String adminpassword = "admin123";
    String newusername = "NewUserName3";
    String newpassword = "P@ssword1";



Thread.sleep(5000);
        logAction(test, "Login with admin credentials", () -> {

        waitimplicit();

            loginpage.loginCredentials(adminusername, adminpassword);  // excelUsername & excelPassword instead of those inputs if we have an excel sheet in the testdata folder
            loginpage.clickLoginButton();


        });
        Thread.sleep(5000);
        
        logAction(test, "Navigate to Admin tab", () -> adminpage.clickonAdminTab());
        Thread.sleep(5000);

        logAction(test, "Fill new user data", () -> {
            try {
                addnewuser.FillDataRequired(newusername, newpassword);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread.sleep(5000);

        logAction(test, "Logout", () -> logout.logout());
        Thread.sleep(5000);

      /*  logAction(test, "Login with new user credentials", () -> {
            loginpage.loginCredentials(newusername, newpassword);
            loginpage.clickLoginButton();
        });
        Thread.sleep(5000);

        logAction(test, "Fill claim data", () -> {
            try {
                claimpage.FillClaimData();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });*/

        ConfigManager.setProperties("the output of the test", String.valueOf(LocalDateTime.now()));
    }

    public void logAction(ExtentTest test, String actionDescription, Runnable action) {
        try {
            test.info("Starting: " + actionDescription);
            action.run();
            test.pass("Success: " + actionDescription);
        } catch (Exception e) {
            test.fail("Failed: " + actionDescription + " - " + e.getMessage());
            takeScreenshot(test);
            e.printStackTrace();
        }
    }

    public void takeScreenshot(ExtentTest test) {
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            String folderPath = "screenshots";
            File folder = new File(folderPath);

            // Create folder if it doesn't exist
            if (!folder.exists()) {
                folder.mkdirs();
            }


            String path = folderPath + File.separator + "failure_" +  + System.currentTimeMillis() + ".png";
            FileHandler.copy(screenshot, new File(path));
            test.addScreenCaptureFromPath(path);
        } catch (Exception e) {
            test.warning("Screenshot failed: " + e.getMessage());
        }
    }
}




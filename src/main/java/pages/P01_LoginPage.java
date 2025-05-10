package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class P01_LoginPage {
    SHAFT.GUI.WebDriver driver;
    SHAFT.TestData.JSON testData;
    //constructor
    public P01_LoginPage(SHAFT.GUI.WebDriver driver){this.driver=driver;}


    // Locators
    By pass = By.id("password");
    By loginbtn = By.xpath("//button[@type='submit']");
    By emailIn = By.id("email");



    //Methods
    public P02_AddNewUser Loginsteps(String email, String password) throws InterruptedException {

        driver.element().type(emailIn,email).
                and().type(pass,password).
                and().click(loginbtn);

        Thread.sleep(3000);
         return new P02_AddNewUser(driver);

    }



}

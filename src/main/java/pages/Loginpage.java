package pages;

import base.basetest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Loginpage extends basetest {
    private WebDriver driver;

    public Loginpage(WebDriver driver) {this.driver = driver;}

    // Locators
    By pass = By.xpath("//input[@type='password']");
    By loginbtn = By.xpath("//button[@type='submit']");
    By username = By.xpath("//input[@name='username']");

   // private By passwordTrial = RelativeLocator.with(By.tagName("input")).below(By.id("Email"))

    public void loginCredentials(String user,String password) {

        driver.findElement(username).sendKeys(user);
        driver.findElement(pass).sendKeys(password);
    }


    public void clickLoginButton() {
        driver.findElement(loginbtn).click();
    }

}

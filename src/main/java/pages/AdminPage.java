package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPage {

    private WebDriver driver;

    public AdminPage(WebDriver driver) {this.driver = driver;}


    // Locators

    By admin_cat = By.xpath("//a[@href='/web/index.php/admin/viewAdminModule']");


    //Methods
    public void  clickonAdminTab(){driver.findElement(admin_cat).click();}


}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Logout {

By ProfileIconSelect = By.xpath("//span[@class='oxd-userdropdown-tab']//i");

By LogoutButton = By.xpath("//a[contains(.,'Logout')]");



public WebDriver driver;
public Logout(WebDriver driver) {this.driver = driver;}

    public void logout() {
    driver.findElement(ProfileIconSelect).click();
    driver.findElement(LogoutButton).click();
    }
}

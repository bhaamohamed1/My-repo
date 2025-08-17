package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddNewUser {

    private WebDriver driver;

    public AddNewUser(WebDriver driver) {this.driver = driver;}

    By addBtn = By.xpath("//button[contains(.,'Add')]");

    By employeeNameinput = By.xpath("//label[contains(.,'Employee Name')]//following::input[1]");
    By employeeNameElement = By.xpath("//span[@class='oxd-userdropdown-tab']//p");
    By employeeNameSelect = By.xpath("//div[@class='oxd-autocomplete-option']");

    /*/By selectEmployee = By.xpath("//div[@class=\"oxd-autocomplete-option\"][1]");/*/

    By dropDownUserRole = By.xpath("//label[contains(.,'User Role')]/../following-sibling::div");
    By Role = By.xpath("//div[@class='oxd-select-option'] [contains(.,'Admin')]");

    By dropDownStatus = By.xpath("//label[contains(.,'Status')]/../following-sibling::div");
    By Status = By.xpath("//div[@class='oxd-select-option'] [contains(.,'Enabled')]");

    By UserName = By.xpath("//label[contains(.,'Username')]/../following::input[1]");

    By passwordInput = By.xpath("(//label[contains(.,'Password')]//following::input)[1]");
    By passwordConfirmInput = By.xpath("(//label[contains(.,'Confirm Password')]//following::input)[1]");

    By saveBtn = By.xpath("//button[contains(.,'Save')]");


    //Methods

    public  void FillDataRequired(String newUserName, String newPassword) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(addBtn).click();
        Thread.sleep(2000);
        driver.findElement(dropDownUserRole).click();
        driver.findElement(Role).click();
        driver.findElement(dropDownStatus).click();
        driver.findElement(Status).click();
        driver.findElement(employeeNameinput).sendKeys(getEmployeeName());
        Thread.sleep(3000);
        driver.findElement(employeeNameSelect).click();
        //WebDriverWait wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(10));
        //wait.until(d ->driver.element().waitUntilPresenceOfAllElementsLocatedBy(selectEmployee));
        driver.findElement(UserName).click();
        Thread.sleep(1000);
        driver.findElement(UserName).sendKeys(newUserName);
        Thread.sleep(1000);
        driver.findElement(passwordInput).sendKeys(newPassword);
        Thread.sleep(1000);
        driver.findElement(passwordConfirmInput).sendKeys(newPassword);
        Thread.sleep(1000);
        driver.findElement(saveBtn).click();



//        driver.browser().captureScreenshot(); // to get a screenshot


    }
    public String getEmployeeName(){

        return driver.findElement(employeeNameElement).getText();
    }





}

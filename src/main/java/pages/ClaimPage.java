package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClaimPage {


    private WebDriver driver;

    public ClaimPage(WebDriver driver) {this.driver = driver;}


    // Locators
    By claimBtn = By.xpath("//a[@href='/web/index.php/claim/viewClaimModule']");
    By assignBtn = By.xpath("//button[contains(.,' Assign Claim ')]");
    By employeeNameBox = By.xpath("//label[contains(.,'Employee Name')]//following::input[1]");
    By getEmployeeNameBox = By.xpath("(//div[@class='oxd-autocomplete-option'])[1]");
    By eventDropDownMenuBox = By.xpath("//label[contains(.,'Event')]//following::i");
    By eventDropDownMenuOption = By.xpath("(//div[@class='oxd-select-option'])[contains(.,'Accommodation')]");
    By currencyDropDownMenuBox = By.xpath("//label[contains(.,'Currency')]//following::i");
    By CurrencyDropDownMenuOption = By.xpath("(//div[@class='oxd-select-option'])[contains(.,'Egyptian Pound')]");
    By remarksBox = By.xpath("//label[contains(.,'Remarks')]//following::textarea");
    By submitBtn = By.xpath("//button[@type='submit']");

    public void FillClaimData() throws InterruptedException {

        Thread.sleep(3000);
        driver.findElement(claimBtn).click();
        Thread.sleep(3000);
        driver.findElement(assignBtn).click();
        Thread.sleep(3000);
        driver.findElement(employeeNameBox).sendKeys("a");
        Thread.sleep(3000);
        driver.findElement(getEmployeeNameBox).click();
        Thread.sleep(1000);
        driver.findElement(eventDropDownMenuBox).click();
        Thread.sleep(1000);
        driver.findElement(eventDropDownMenuOption).click();
        Thread.sleep(1000);
        driver.findElement(currencyDropDownMenuBox).click();
        Thread.sleep(1000);
        driver.findElement(CurrencyDropDownMenuOption).click();
        Thread.sleep(1000);
        driver.findElement(remarksBox).sendKeys("this is a remark");
        Thread.sleep(1000);
        driver.findElement(submitBtn).click();
        Thread.sleep(1000);
//        driver.browser().captureScreenshot(); // to get a screenshot


    }
}

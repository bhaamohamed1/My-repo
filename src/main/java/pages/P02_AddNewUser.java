package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P02_AddNewUser {
    SHAFT.GUI.WebDriver driver;


    //constructor
    public P02_AddNewUser(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Locators


    By create_New = By.xpath("//a[@class='btn bg-gray-800 text-white hover:bg-gray-600 active:bg-gray-600 border border-gray-600 px-3 py-1 rounded']");
    By name_Ar = By.xpath("//input[@name='nameAr']");
    By clickEn = By.xpath("//button[@type='button'][contains(.,'English')]");
    By name_En = By.xpath("//input[@name='nameEn']");
    By create_Btn = By.xpath("//button[@type='submit']");
    By delete_Btn = By.xpath("/html[1]/body[1]/div[1]/main[1]/div[1]/div[2]/div[2]/table[1]/tbody[1]/tr[1]/td[4]/div[1]/button[1]");
    By delete_Popup = By.xpath("//button[@class='inline-flex items-center justify-center gap-2 whitespace-nowrap rounded-md text-sm font-medium transition-colors focus-visible:outline-none focus-visible:ring-1 focus-visible:ring-ring disabled:pointer-events-none disabled:opacity-50 [&_svg]:pointer-events-none [&_svg]:size-4 [&_svg]:shrink-0 bg-destructive text-destructive-foreground shadow-sm hover:bg-destructive/90 h-9 px-4 py-2']");


    public P01_LoginPage FillDataRequired(String nameAR, String nameEN) {
        driver.element().click(create_New)
                .and().type(name_Ar, nameAR)
                .and().click(clickEn)
                .and().type(name_En,nameEN)
                .and().click(create_Btn)
                .and().click(delete_Btn);
        WebDriverWait wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(5));
        wait.until(d ->driver.element().waitUntilPresenceOfAllElementsLocatedBy(delete_Popup));
                driver.element().click(delete_Popup);

        return new P01_LoginPage(driver);
    }
}

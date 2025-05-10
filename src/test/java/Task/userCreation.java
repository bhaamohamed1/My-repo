package Task;

import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.P01_LoginPage;
import pages.P02_AddNewUser;

import java.util.*;

class LanguageURLcheck_And_Create_A_User {
    public class FormInput {
        private String name;
        private String type;
        private boolean multiLang;
        private String cardId;
        private boolean required;

        public FormInput(String name, String type, boolean multiLang, String cardId, boolean required) {
            this.name = name;
            this.type = type;
            this.multiLang = multiLang;
            this.cardId = cardId;
            this.required = required;
        }

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }

        public boolean isMultiLang() {
            return multiLang;
        }

        public String getCardId() {
            return cardId;
        }

        public boolean isRequired() {
            return required;
        }

    }

    //
        SHAFT.GUI.WebDriver driver;
        SHAFT.TestData.JSON testData;

        private List<FormInput> formStructure;

        //Test Methods


        @Test
        public void testLanguageInURL() throws InterruptedException {
            // Simulate user input



            Map<String, Object> collectedData = collectInputs(formStructure);

            // Extract expected language from multilingual input
            Map<String, String> nameMap = (Map<String, String>) collectedData.get("name");
            String expectedLang = nameMap.keySet().iterator().hasNext()
                    ? nameMap.keySet().iterator().next()
                    : "en";

            // Navigate to URL based on language
            String baseUrl = "https://ijd-dashboard-frontend.vercel.app";
            String testUrl = baseUrl + "/" + expectedLang + "/dashboard";
            String SectionUrl = baseUrl + "/" + expectedLang + "/section";

            driver = new SHAFT.GUI.WebDriver();
            driver.browser().navigateToURL(testUrl);

            // adding a user in that site
            new P01_LoginPage(driver).Loginsteps(testData.getTestData("Email"),testData.getTestData("Password"));
            driver.browser().navigateToURL(SectionUrl);
            new P02_AddNewUser(driver).FillDataRequired(testData.getTestData("nameArabic"),testData.getTestData("nameEnglish"));


             /* // Validate language code in URL
            String currentUrl = driver.browser().getCurrentURL();
            driver.browser().assertThat().url().contains("/" + expectedLang + "/").perform();
            System.out.println("✅ Language '" + expectedLang + "' validated successfully in URL.");
*/

        }

        // Dummy input collection method (simulate user input)
        private Map<String, Object> collectInputs(List<FormInput> formInputs) {
            Map<String, Object> results = new HashMap<>();

            for (FormInput field : formInputs) {
                if (field.isMultiLang()) {
                    Map<String, String> multiLangValues = new HashMap<>();
                    multiLangValues.put("en", "Welcome back");
                    multiLangValues.put("ar", "مرحبًا بك مرة أخرى");

                    results.put(field.getName(), multiLangValues);
                } else {
                    results.put(field.getName(), "30");
                }
            }

            return results;
        }


    //Before Method
    @BeforeClass
    public void setup() {

        testData = new SHAFT.TestData.JSON("ijd.json");
        formStructure = Arrays.asList(
                new FormInput("name", "text", true, "lang", true)

        );
    }

    //After Method
    @AfterMethod
    public void teardown() {
        driver.browser().closeCurrentWindow();

    }


}

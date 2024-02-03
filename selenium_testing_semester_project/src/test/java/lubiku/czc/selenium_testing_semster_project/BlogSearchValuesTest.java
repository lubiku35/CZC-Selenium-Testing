package lubiku.czc.selenium_testing_semster_project;

import com.codeborne.selenide.Condition;
import lubiku.czc.selenium_testing_semster_project.GlobalMethods.GlobalMethods;
import lubiku.czc.selenium_testing_semster_project.PageElements.PageElements;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

@Execution(ExecutionMode.SAME_THREAD)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BlogSearchValuesTest {
    // Page Elements
    private static final PageElements PAGE_ELEMENTS = new PageElements();

    // GlobalMethod for overall testing
    private static final GlobalMethods GLOBAL_METHODS = new GlobalMethods();

    // Website Url to Test
    private static String PAGE_URL;

    // Storing Wrong and Right Values after search
    protected static List<String> wrongValues = new ArrayList<>();
    protected static List<String> rightValues = new ArrayList<>();

    @BeforeAll
    public static void beforeAll() {
        setPageUrl(GLOBAL_METHODS.getPageUrl());
        GLOBAL_METHODS.globalConfiguration();
        GLOBAL_METHODS.openWebsite(PAGE_URL);

        // Open Website
        GLOBAL_METHODS.openWebsite(PAGE_URL);
        // Accept Cookies
        PAGE_ELEMENTS.acceptCookiesButton.click();
    }
    
    @Order(value = 1)
    @Test
    public void navigateToTheBlogSubpage() {
        $(By.xpath("/html/body/div[2]/header/div[1]/ul[1]/li[6]/a"))
                .shouldBe(Condition.visible)
                .click();
    }

    @Order(value = 2)
    @ParameterizedTest
    @CsvSource(
            {
                    "mouse",
                    "thisisnotsearchebletextobviously",
                    "oooopssomethinggoeswrong",
                    "computer",
                    "?????",
                    "findsomething",
                    "crazy",
                    "clear",
                    "+=-/*/.,;'[p;",
                    "123randomdata123",
                    "X",
                    "..,,..,,..,,..,,..Mouse",
            }
    )
    public void searchValues(String searchedValue) {
        sleep(1000);
        
        $(By.xpath("//*[@id='fulltext']"))
                .shouldBe(Condition.visible)
                .setValue(searchedValue);


        $(By.xpath("//button[contains(@class, 'cancel')]"))
                .shouldBe(Condition.visible)
                .click();

        sleep(1000);

        if ($(By.xpath("//czc-alert")).isDisplayed()) { wrongValues.add(searchedValue); }
        else { rightValues.add(searchedValue); }
    }

    @AfterAll
    public static void afterAll() {
        // Print wrongValues
        System.out.println("\nWrong Values:");
        for (String value : wrongValues) { System.out.println(value); }

        // Print rightValues
        System.out.println("\nRight Values:");
        for (String value : rightValues) { System.out.println(value); }
    }

    // Setter for PAGE_URL
    public static void setPageUrl(String pageUrl) { PAGE_URL = pageUrl; }
}

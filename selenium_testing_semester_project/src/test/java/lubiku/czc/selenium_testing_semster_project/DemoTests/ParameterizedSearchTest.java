package lubiku.czc.selenium_testing_semster_project.DemoTests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import lubiku.czc.selenium_testing_semster_project.GlobalMethods.GlobalMethods;
import lubiku.czc.selenium_testing_semster_project.PageElements.PageElements;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class ParameterizedSearchTest {
    // Page Elements
    private static final PageElements PAGE_ELEMENTS = new PageElements();

    // GlobalMethod for overall testing
    private static final GlobalMethods GLOBAL_METHODS = new GlobalMethods();

    // Website Url to Test
    private static String PAGE_URL;

    @BeforeAll
    public static void beforeAll() {
        setPageUrl(GLOBAL_METHODS.getPageUrl());
        GLOBAL_METHODS.globalConfiguration();
    }

    @BeforeEach
    public void setUp() {
        GLOBAL_METHODS.openWebsite(PAGE_URL);
        PAGE_ELEMENTS.acceptCookiesButton.click();
    }

    @ParameterizedTest
    @CsvSource({"iPhone", "mouse", "notebook", "cable", "mobile"})
    public void searchProducts(String searchedValue) {

        PAGE_ELEMENTS.searchInputText
                .shouldBe(Condition.visible)
                .setValue(searchedValue);

        PAGE_ELEMENTS.searchButton
                .shouldBe(Condition.visible)
                .click();

        Configuration.timeout = 6000;

        PAGE_ELEMENTS.searchHeading
                .shouldBe(Condition.visible)
                .shouldHave(Condition.text(searchedValue));

        List<SelenideElement> firstThreeResults = $$(".search-results div[data-product-code]").first(3);

        for (SelenideElement searchResult : firstThreeResults) { searchResult.$("button[data-label='Přidat zboží do košíku']").shouldBe(Condition.visible); }
    }

    @AfterEach
    public void tearDown() { closeWebDriver(); }


    // Setter for PAGE_URL
    public static void setPageUrl(String pageUrl) { PAGE_URL = pageUrl; }
}

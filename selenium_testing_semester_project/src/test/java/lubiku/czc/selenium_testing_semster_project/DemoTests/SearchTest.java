package lubiku.czc.selenium_testing_semster_project.DemoTests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import lubiku.czc.selenium_testing_semster_project.GlobalMethods.GlobalMethods;
import lubiku.czc.selenium_testing_semster_project.PageElements.PageElements;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.datatype.Duration;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SearchTest {
    // Page Elements
    private static final PageElements PAGE_ELEMENTS = new PageElements();

    // GlobalMethod for overall testing
    private static final GlobalMethods GLOBAL_METHODS = new GlobalMethods();

    // Website Url to Test
    private static String PAGE_URL;

    // Searched Value
    private static final String searchedValue = "Iphone";

    @BeforeAll
    public static void beforeAll() {
        setPageUrl(GLOBAL_METHODS.getPageUrl());
        GLOBAL_METHODS.globalConfiguration();
        GLOBAL_METHODS.openWebsite(PAGE_URL);
    }

    @Test
    public void searchProducts() {
        PAGE_ELEMENTS.acceptCookiesButton
                .click();

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

    // Setter for PAGE_URL
    public static void setPageUrl(String pageUrl) { PAGE_URL = pageUrl; }

}

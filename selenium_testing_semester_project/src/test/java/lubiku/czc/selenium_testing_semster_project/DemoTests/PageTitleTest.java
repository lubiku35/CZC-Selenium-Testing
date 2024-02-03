package lubiku.czc.selenium_testing_semster_project.DemoTests;

import com.codeborne.selenide.Selenide;
import lubiku.czc.selenium_testing_semster_project.GlobalMethods.GlobalMethods;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PageTitleTest {

    // GlobalMethod for overall testing
    private static final GlobalMethods GLOBAL_METHODS = new GlobalMethods();

    // Website Url to Test
    private static String PAGE_URL;

    // Page Title
    private static final String PAGE_TITLE = "CZC.cz - rozumíme vám i elektronice";

    @BeforeAll
    static void beforeAll() {
        setPageUrl(GLOBAL_METHODS.getPageUrl());
        GLOBAL_METHODS.globalConfiguration();
        GLOBAL_METHODS.openWebsite(PAGE_URL);
    }

    @Test
    void getPageTitle() { assertEquals(PAGE_TITLE, Selenide.title()); }

    // Setter for PAGE_URL
    public static void setPageUrl(String pageUrl) { PAGE_URL = pageUrl; }
}

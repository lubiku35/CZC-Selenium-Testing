package lubiku.czc.selenium_testing_semster_project.DemoTests;

import lubiku.czc.selenium_testing_semster_project.GlobalMethods.GlobalMethods;
import lubiku.czc.selenium_testing_semster_project.PageElements.PageElements;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AcceptCookiesTest {

    // Page Elements
    private static final PageElements PAGE_ELEMENTS = new PageElements();

    // GlobalMethod for overall testing
    private static final GlobalMethods GLOBAL_METHODS = new GlobalMethods();

    // Website Url to Test
    private static String PAGE_URL;

    @BeforeAll
    static void beforeAll() {
        setPageUrl(GLOBAL_METHODS.getPageUrl());
        GLOBAL_METHODS.globalConfiguration();
        GLOBAL_METHODS.openWebsite(PAGE_URL);
    }

    @Test
    void acceptCookies() { PAGE_ELEMENTS.acceptCookiesButton.click(); }


    // Setter for PAGE_URL
    public static void setPageUrl(String pageUrl) { PAGE_URL = pageUrl; }
}

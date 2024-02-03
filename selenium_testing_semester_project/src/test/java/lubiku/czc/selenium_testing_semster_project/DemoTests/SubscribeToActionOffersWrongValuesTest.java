package lubiku.czc.selenium_testing_semster_project.DemoTests;

import lubiku.czc.selenium_testing_semster_project.GlobalMethods.GlobalMethods;
import lubiku.czc.selenium_testing_semster_project.PageElements.PageElements;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SubscribeToActionOffersWrongValuesTest {
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
        PAGE_ELEMENTS.acceptCookiesButton.click();
    }

    @ParameterizedTest
    @CsvSource(
            {
                "notanemail",
                "anothernotanemail",
                "1225",
                "something",
                "@.net",
                "sadsadas@s.x",
                "hello@",
                "clear",
                "?@?.com",
                "data222@explain.123456789",
                "me.me.@google.com",
                "\\this\\.com",
            }
    )
    public void subscribeToActionOfferTest(String emailValue) {
        PAGE_ELEMENTS.subscribeInputField.setValue(emailValue);
        PAGE_ELEMENTS.subscribeButton.click();
    }

    @AfterEach
    public void tearDown() { PAGE_ELEMENTS.subscribeInputField.clear(); }

    // Setter for PAGE_URL
    public static void setPageUrl(String pageUrl) { PAGE_URL = pageUrl; }
}

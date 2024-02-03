package lubiku.czc.selenium_testing_semster_project.DemoTests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import lubiku.czc.selenium_testing_semster_project.GlobalMethods.GlobalMethods;
import lubiku.czc.selenium_testing_semster_project.PageElements.PageElements;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class SubscribeToActionOffersTest {
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
    @CsvSource({"hello@hello.sk", "hello@hello.cz", "hello@hello.com", "hello@hello.de", "hello@hello.net"})
    public void subscribeToActionOfferTest(String emailValue) {

        PAGE_ELEMENTS.subscribeInputField
                .setValue(emailValue);

        PAGE_ELEMENTS.subscribeButton.click();
    }

    @AfterEach
    public void tearDown() { PAGE_ELEMENTS.mainPageLink.click(); }

    // Setter for PAGE_URL
    public static void setPageUrl(String pageUrl) { PAGE_URL = pageUrl; }

}

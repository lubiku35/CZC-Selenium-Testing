package lubiku.czc.selenium_testing_semster_project.DemoTests;

import com.codeborne.selenide.SelenideElement;
import lubiku.czc.selenium_testing_semster_project.GlobalMethods.GlobalMethods;
import lubiku.czc.selenium_testing_semster_project.PageElements.PageElements;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


public class BrowseThroughWebsiteTest {
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

    @BeforeEach
    public void setUp() { PAGE_ELEMENTS.mainPageLink.click(); }

    @ParameterizedTest
    @MethodSource("provideElements")
    public void browseElement(SelenideElement element) {
        element.click();
    }

    @AfterEach
    public void tearDown() { PAGE_ELEMENTS.mainPageLink.click(); }


    // Method to provide the test data
    public static Stream<SelenideElement> provideElements() {
        return Stream.of(
                PAGE_ELEMENTS.linkCZCLab,
                PAGE_ELEMENTS.linkElektronika,
                PAGE_ELEMENTS.linkCZCHealth
        );
    }

    // Setter for PAGE_URL
    public static void setPageUrl(String pageUrl) { PAGE_URL = pageUrl; }
}

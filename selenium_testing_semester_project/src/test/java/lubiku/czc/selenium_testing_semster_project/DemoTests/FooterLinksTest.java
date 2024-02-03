package lubiku.czc.selenium_testing_semster_project.DemoTests;

import com.codeborne.selenide.Condition;
import lubiku.czc.selenium_testing_semster_project.GlobalMethods.GlobalMethods;
import lubiku.czc.selenium_testing_semster_project.PageElements.PageElements;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Execution(ExecutionMode.SAME_THREAD)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FooterLinksTest {

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
        GLOBAL_METHODS.openWebsite(PAGE_URL);

        // Open Website
        GLOBAL_METHODS.openWebsite(PAGE_URL);
        // Accept Cookies
        PAGE_ELEMENTS.acceptCookiesButton.click();
    }

    @Order(value = 1)
    @Test
    public void checkAboutUsLink() {

        $(By.xpath("//a[@href='/o-nas/clanek']"))
                .shouldBe(Condition.visible)
                .click();

        $(By.xpath("//h1")).shouldBe(Condition.visible);
    }

    @Order(value = 2)
    @Test
    public void checkAboutMallGroupLink() {

        $(By.xpath("//a[@href='/o-mall-group/clanek']"))
                .shouldBe(Condition.visible)
                .click();

        $(By.xpath("//h1")).shouldBe(Condition.visible);
    }


    @Order(value = 3)
    @Test
    public void checkContactFormLink() {

        $(By.xpath("/html/body/div[2]/div[3]/footer/div[2]/div/div[2]/ul/li[4]/a"))
                .shouldBe(Condition.visible)
                .click();
        
    }

    @Order(value = 4)
    @Test
    public void checkShippingAndPaymentLink() {

        $(By.xpath("/html/body/div[2]/div[3]/footer/div[2]/div/div[3]/ul/li[1]/a"))
                .shouldBe(Condition.visible)
                .click();

        $(By.xpath("//h1")).shouldBe(Condition.visible);
    }

    @Order(value = 5)
    @Test
    public void checkComplaintLink() {

        $(By.xpath("/html/body/div[2]/div[3]/footer/div[2]/div/div[3]/ul/li[2]/a"))
                .shouldBe(Condition.visible)
                .click();

        $(By.xpath("//h1")).shouldBe(Condition.visible);
    }

    @Order(value = 6)
    @Test
    public void checkStoresLink() {

        $(By.xpath("/html/body/div[2]/div[3]/footer/div[2]/div/div[3]/ul/li[3]/a"))
                .shouldBe(Condition.visible)
                .click();

        $(By.xpath("//h1")).shouldBe(Condition.visible);
    }


    @Order(value = 7)
    @Test
    public void checkISICLink() {

        $(By.xpath("//a[contains(@href, 'isic')]"))
                .shouldBe(Condition.visible)
                .click();

    }

    @Order(value = 8)
    @Test
    public void checkServicesLink() {

        $(By.xpath("/html/body/div[2]/div[3]/footer/div[2]/div/div[4]/ul/li[1]/a"))
                .shouldBe(Condition.visible)
                .click();

    }

    @Order(value = 9)
    @Test
    public void checkAffiliateProgramLink() {

        $(By.xpath("//a[@href='/affiliate/clanek']"))
                .shouldBe(Condition.visible)
                .click();

    }

    @Order(value = 10)
    @Test
    public void checkDocumentsForDownloadLink() {

        $(By.xpath("//a[@href='/dokumenty-ke-stazeni/clanek']"))
                .shouldBe(Condition.visible)
                .click();

    }


    @AfterEach
    public void tearDown() { PAGE_ELEMENTS.mainPageLink.shouldBe(Condition.visible).click(); }

    // Setter for PAGE_URL
    public static void setPageUrl(String pageUrl) { PAGE_URL = pageUrl; }
}

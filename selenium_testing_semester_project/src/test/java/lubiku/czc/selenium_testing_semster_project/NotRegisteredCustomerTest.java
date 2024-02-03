package lubiku.czc.selenium_testing_semster_project;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import lubiku.czc.selenium_testing_semster_project.GlobalMethods.GlobalMethods;
import lubiku.czc.selenium_testing_semster_project.PageElements.PageElements;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

@Execution(ExecutionMode.SAME_THREAD)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class NotRegisteredCustomerTest {
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
        clearBrowserCookies();
        clearBrowserLocalStorage();
        closeWebDriver();

        // Open Website
        GLOBAL_METHODS.openWebsite(PAGE_URL);
        // Accept Cookies
        PAGE_ELEMENTS.acceptCookiesButton.click();
    }

    @Order(value = 1)
    @Test
    public void searchRandomChoice() {
        String[] items = {"iPhone", "mouse", "notebook", "cable", "mobile", "watches", "keyboard"};
        for (String searchedValue : items) {
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

            SelenideElement divTiles = $(By.xpath("//*[@id='tiles']"));
            divTiles.shouldBe(Condition.visible);

            List<WebElement> childElements = divTiles.findElements(By.xpath("./*[position() <= 6]"));

            WebElement childElement = childElements.get(0);
            WebElement linkElement = childElement.findElement(By.cssSelector("a"));
            linkElement.click();

            sleep(1000);

            // Add to Favourites
            $(By.xpath("//*[@id='pd-controls-favorite']"))
                    .shouldBe(Condition.visible)
                    .click();

            sleep(1000);

            // Navigate back to product
            $(By.xpath("//button[@title='zavřít']"))
                    .shouldBe(Condition.visible)
                    .click();

            back();

            PAGE_ELEMENTS.mainPageLink.shouldBe(Condition.visible).click();
        }
    }

    // Setter for PAGE_URL
    public static void setPageUrl(String pageUrl) { PAGE_URL = pageUrl; }
}

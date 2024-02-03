package lubiku.czc.selenium_testing_semster_project.DemoTests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lubiku.czc.selenium_testing_semster_project.GlobalMethods.GlobalMethods;
import lubiku.czc.selenium_testing_semster_project.PageElements.PageElements;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ShoppingCartTest {
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
        PAGE_ELEMENTS.acceptCookiesButton.click();
    }

    @Test
    public void shoppingCartTest() {
        PAGE_ELEMENTS.shoppingCartButton
                .shouldBe(Condition.visible)
                .click();

        PAGE_ELEMENTS.emptyShoppingCartHeading.shouldBe(Condition.visible);

        PAGE_ELEMENTS.backToShopFromShoppingCart
                .shouldBe(Condition.visible)
                .click();

        SelenideElement myChoice = PAGE_ELEMENTS.divSelectedForYouCarousel.find("czc-carousel-item");
        myChoice.find("button").click();
        
        PAGE_ELEMENTS.shoppingCartButton
                .shouldBe(Condition.visible)
                .click();

        $(By.xpath("//button[contains(@class, 'btn--md')]")).shouldBe(Condition.visible);
    }


    // Setter for PAGE_URL
    public static void setPageUrl(String pageUrl) { PAGE_URL = pageUrl; }
}

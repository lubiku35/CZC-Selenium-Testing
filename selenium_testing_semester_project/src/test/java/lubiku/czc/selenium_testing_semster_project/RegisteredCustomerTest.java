package lubiku.czc.selenium_testing_semster_project;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import lubiku.czc.selenium_testing_semster_project.GlobalMethods.GlobalMethods;
import lubiku.czc.selenium_testing_semster_project.PageElements.PageElements;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

@Execution(ExecutionMode.SAME_THREAD)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RegisteredCustomerTest {

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
    public void navigateToCreateNewAccount() {

        // Visibility of initLoginButton
        PAGE_ELEMENTS.initLoginButton.shouldBe(Condition.visible).click();

        // Assertion: Verify the registration heading contains specific text
        String expectedRegistrationHeadingText = "Registrujte se";
        PAGE_ELEMENTS
                .initRegistrationHeading
                .shouldBe(Condition.visible)
                .shouldHave(Condition.text(expectedRegistrationHeadingText));

        // Navigate to Registration Form
        String expectedRegistrationButtonText = "Chci se zaregistrovat";

        PAGE_ELEMENTS
                .initRegistrationButtonSpan
                .shouldBe(Condition.visible)
                .shouldHave(Condition.text(expectedRegistrationButtonText));

        PAGE_ELEMENTS
                .initRegistrationButton
                .shouldBe(Condition.visible)
                .click();

        // Check if all necessary components are visible
        PAGE_ELEMENTS.registrationInputEmail.shouldBe(Condition.visible);
        PAGE_ELEMENTS.registrationInputPhoneNumberFormatted.shouldBe(Condition.visible);
        PAGE_ELEMENTS.registrationInputName.shouldBe(Condition.visible);
        PAGE_ELEMENTS.registrationInputSurname.shouldBe(Condition.visible);
        PAGE_ELEMENTS.registrationInputLoginName.shouldBe(Condition.visible);
        PAGE_ELEMENTS.registrationInputPassword.shouldBe(Condition.visible);
        PAGE_ELEMENTS.registrationSelectCountry.shouldBe(Condition.visible);
        PAGE_ELEMENTS.registrationInputStreet.shouldBe(Condition.visible);
        PAGE_ELEMENTS.registrationInputCity.shouldBe(Condition.visible);
        PAGE_ELEMENTS.registrationInputZipCodeFormatted.shouldBe(Condition.visible);
        PAGE_ELEMENTS.registrationInputFullBankAccount.shouldBe(Condition.visible);
        PAGE_ELEMENTS.registrationButtonRegister.shouldBe(Condition.visible);
    }

    @Order(value = 2)
    @ParameterizedTest
    @CsvSource({
            "lubiku@proton.me, +421908326935, Ľuboslav, Motošický, rootlubiku, someRandomPassword321, SNP 1947/365, Považská Bystrica, 01701"
    })
    public void createNewAccount(
            String userEmail,
            String userPhoneNumber,
            String userName,
            String userSurname,
            String userNickname,
            String userPassword,
            String userStreet,
            String userCity,
            String userPostalCode
    ) {
        // Set Values for the necessary elements
        PAGE_ELEMENTS.registrationInputEmail.setValue(userEmail);
        PAGE_ELEMENTS.registrationInputPhoneNumberFormatted.setValue(userPhoneNumber);
        PAGE_ELEMENTS.registrationInputName.setValue(userName);
        PAGE_ELEMENTS.registrationInputSurname.setValue(userSurname);
        PAGE_ELEMENTS.registrationInputLoginName.setValue(userNickname);
        PAGE_ELEMENTS.registrationInputPassword.setValue(userPassword);
        PAGE_ELEMENTS.registrationInputStreet.setValue(userStreet);
        PAGE_ELEMENTS.registrationInputCity.setValue(userCity);
        PAGE_ELEMENTS.registrationInputZipCodeFormatted.setValue(userPostalCode);

        // Make a Registration
        PAGE_ELEMENTS.registrationButtonRegister.click();

        // Navigate to MainPage
        PAGE_ELEMENTS.mainPageLink.click();
    }

    @Order(value = 3)
    @ParameterizedTest
    @CsvSource({
            "rootlubiku, someRandomPassword321"
    })
    public void loginToAlreadyCreatedAccount(String userNickname, String userPassword) {
        // Visibility of initLoginButton
        PAGE_ELEMENTS.initLoginButton.shouldBe(Condition.visible).click();

        // Login Input UserName
        PAGE_ELEMENTS.loginInputName.setValue(userNickname);

        // Login Input UserPassword
        PAGE_ELEMENTS.loginInputPassword.setValue(userPassword);

        PAGE_ELEMENTS.loginButtonAccept.shouldBe(Condition.visible).click();

        // Navigate to MainPage
        PAGE_ELEMENTS.mainPageLink.click();
    }

    @Order(value = 4)
    @Test
    public void previewMyCurrentOrders() {
        // Navigate to my Profile
        PAGE_ELEMENTS.linkLoggedUser.shouldBe(Condition.visible).click();
        PAGE_ELEMENTS.menuLoggedUser.shouldBe(Condition.visible);

        // Move the mouse cursor to the menuLoggedUser element to trigger the menu
        actions().moveToElement(PAGE_ELEMENTS.menuLoggedUser).perform();

        // Find the fourth <a> element in the menu and click it
        SelenideElement myOrdersLink = PAGE_ELEMENTS.menuLoggedUser.$x(".//a[4]");
        myOrdersLink.click();

        // Navigate to MainPage
        PAGE_ELEMENTS.mainPageLink.click();
    }

    @Order(value = 5)
    @Test
    public void previewEmptyShoppingCart() {
        PAGE_ELEMENTS.shoppingCartButton
                .shouldBe(Condition.visible)
                .click();

        PAGE_ELEMENTS.emptyShoppingCartHeading.shouldBe(Condition.visible);

        PAGE_ELEMENTS.backToShopFromShoppingCart
                .shouldBe(Condition.visible)
                .click();
    }

    @Order(value = 6)
    @Test
    public void makeRandomChoiceFromSelectedItemsForMeAndAddItToTheShoppingCart() {
        SelenideElement myChoice = PAGE_ELEMENTS.divSelectedForYouCarousel.find("czc-carousel-item");
        myChoice.find("button").click();

        PAGE_ELEMENTS.shoppingCartButton
                .shouldBe(Condition.visible)
                .click();
    }

    @Order(value = 7)
    @Test
    public void navigateThroughTheShoppingCartMenu() {
        // First Confirm of Order
        $(By.xpath("//button[contains(@class, 'btn--md')]"))
                .shouldBe(Condition.visible)
                .click();
        ;
        
        // Second Confirm of Order
        $(By.xpath("//button[contains(@class, 'btn--md')]"))
                .shouldBe(Condition.visible)
                .click();
        
        // Close the Order and Navigate Back to the Shopping Cart
        $(By.xpath("//a[@href='/kosik']"))
                .shouldBe(Condition.visible)
                .click();
        
        // Remove current Item from ShoppingCart
        $(By.xpath("//a[@class='btn-circle-remove']"))
                .shouldBe(Condition.visible)
                .click();

        // Navigate Back to the shop
        $(By.xpath("//a[@class='btn btn-secondary']"))
                .shouldBe(Condition.visible)
                .click();
    }
    
    @Order(value = 8)
    @Test
    public void makeRandomChoiceFromSelectedItemsForMeAndAddItToTheWishList() {
        SelenideElement myChoice = PAGE_ELEMENTS.divSelectedForYouCarousel.find("czc-carousel-item");
        myChoice.find("a").click();

        $(By.xpath("//*[@id='pd-controls-favorite']"))
                .shouldBe(Condition.visible)
                .click();

        // Navigate to MainPage
        PAGE_ELEMENTS.mainPageLink.click();
    }

    @Order(value = 9)
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

        // Navigate to MainPage
        PAGE_ELEMENTS.mainPageLink.click();
    }
    

    // Setter for PAGE_URL
    public static void setPageUrl(String pageUrl) { PAGE_URL = pageUrl; }
}

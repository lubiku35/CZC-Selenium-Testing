package lubiku.czc.selenium_testing_semster_project.DemoTests;

import com.codeborne.selenide.Condition;
import lubiku.czc.selenium_testing_semster_project.GlobalMethods.GlobalMethods;
import lubiku.czc.selenium_testing_semster_project.PageElements.PageElements;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CreateNewAccountTest {

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
    }

    @Test
    public void navigateToCreateNewAccount() {
        // Accept Cookies if necessary
        PAGE_ELEMENTS.acceptCookiesButton.click();

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

    // Setter for PAGE_URL
    public static void setPageUrl(String pageUrl) { PAGE_URL = pageUrl; }

}

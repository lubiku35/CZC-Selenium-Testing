package lubiku.czc.selenium_testing_semster_project.DemoTests;

import com.codeborne.selenide.Condition;
import lubiku.czc.selenium_testing_semster_project.GlobalMethods.GlobalMethods;
import lubiku.czc.selenium_testing_semster_project.PageElements.PageElements;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginTest {

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
    void navigateToLogin() {
        PAGE_ELEMENTS.acceptCookiesButton.click();

        // Visibility of initLoginButton
        PAGE_ELEMENTS.initLoginButton.shouldBe(Condition.visible).click();

        // Login Input UserName
        PAGE_ELEMENTS.loginInputName.shouldBe(Condition.visible);

        // Check if Label in UserNameInput is Visible
        $(By.xpath("//label[@for='frm-name']")).shouldBe(Condition.visible);

        // Login Input UserPassword
        PAGE_ELEMENTS.loginInputPassword.shouldBe(Condition.visible);

        // Check if Label in PasswordInput is Visible
        $(By.xpath("//label[@for='frm-password']")).shouldBe(Condition.visible);

        
        PAGE_ELEMENTS.loginButtonSpan.shouldBe(Condition.visible);

        PAGE_ELEMENTS.loginButtonAccept.shouldBe(Condition.visible);
    }

    // Setter for PAGE_URL
    public static void setPageUrl(String pageUrl) { PAGE_URL = pageUrl; }
}

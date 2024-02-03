package lubiku.czc.selenium_testing_semster_project.PageElements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

// PAGE_URL = https://www.czc.cz/
public class PageElements {

    // Accept cookies Elements
    public final SelenideElement acceptCookiesButton = $x("//button[contains(@class, 'btn--md')]");

    
    // Navigation To Registration Form Elements
    public final SelenideElement initLoginButton = $x("//*[@id='login']");
    public final SelenideElement initRegistrationButton = $x("//a[contains(@class, 'md:column')]");
    public final SelenideElement initRegistrationHeading = $x("//h2[@class='h-600']");
    public final SelenideElement initRegistrationButtonSpan = $x("/html/body/div[5]/div/div/div[2]/div/a/span");
    
    
    // Login Elements
    public final SelenideElement loginInputName = $x("//input[contains(@data-rules, 'uživatelské')]");
    public final SelenideElement loginInputPassword = $x("//input[@autocomplete='current-password']");
    public final SelenideElement loginButtonSpan = $x("/html/body/div[5]/div/div/div[1]/form/div[4]/button/span");
    public final SelenideElement loginButtonAccept = $x("//button[contains(@class, 'submit')]");
    
    // Logged User Elements
    public final SelenideElement linkLoggedUser = $x("//*[@id='logged-user']");
    public SelenideElement menuLoggedUser = $x("//div[contains(@class, 'preview-menu--user')][.//*[@id='bonus-club-points']]");


    // Search Website Elements
    public final SelenideElement searchInputText = $x("//*[@id='fulltext']");
    public final SelenideElement searchButton = $x("//button[contains(@class, 'cancel')]");


    // After Search Elements
    public final SelenideElement searchHeading = $x("//h1");


    // Registration Form Elements
    public final SelenideElement registrationInputEmail = $x("//input[@autocomplete='email']");
    public final SelenideElement registrationInputPhoneNumberFormatted = $x("//*[@id='frm-phoneNumberFormatted']");
    public final SelenideElement registrationInputName = $x("//*[@id='frm-name']");
    public final SelenideElement registrationInputSurname = $x("//*[@id='frm-surname']");
    public final SelenideElement registrationInputLoginName = $x("//*[@id='loginname']");
    public final SelenideElement registrationInputPassword = $x("//*[@id='frm-password']");
    public final SelenideElement registrationSelectCountry = $x("//*[@id='frm-countryId']");
    public final SelenideElement registrationInputStreet = $x("//*[@id='frm-street']");
    public final SelenideElement registrationInputCity = $x("//*[@id='frm-city']");
    public final SelenideElement registrationInputZipCodeFormatted = $x("//*[@id='frm-zipCodeFormatted']");
    public final SelenideElement registrationInputFullBankAccount = $x("//*[@id='frm-fullBankAccountNo']");
    public final SelenideElement registrationButtonRegister = $x("//button[@class='btn btn-secondary']");


    // Browsing Website Elements
    public final SelenideElement mainPageLink = $x("//a[@title='CZC.cz']");
    public final SelenideElement linkElektronika = $x("//a[.//img[@alt='Elektronika']]");
    public final SelenideElement linkCZCLab = $x("//a[.//img[@alt='CZC.Lab']]");
    public final SelenideElement linkCZCHealth = $x("//a[.//img[@alt='CZC.Health']]");




    // ShoppingCart
    public final SelenideElement shoppingCartButton = $x("//a[contains(@class, 'view-basket')]");
    public final SelenideElement emptyShoppingCartHeading = $x("//h1");
    public final SelenideElement backToShopFromShoppingCart = $x("//a[@class='btn btn-secondary']");

    public final SelenideElement divSelectedForYouCarousel = $x("//*[@id='selected-for-you-carousel']");

    

    // ActionOffers

    public SelenideElement subscribeInputField = $x("//*[@id='frm-email']");
    public SelenideElement subscribeButton = $x("//button[@class='btn btn-primary btn--sm']");







    
}

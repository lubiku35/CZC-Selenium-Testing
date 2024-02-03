package lubiku.czc.selenium_testing_semster_project.GlobalMethods;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;

import static com.codeborne.selenide.Selenide.open;

public class GlobalMethods {
    private static final String PAGE_URL = "https://www.czc.cz/";

    public void globalConfiguration() {
        Configuration.browser = "firefox";
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    public void openWebsite(String websiteUrl) { open(websiteUrl); }

    public String getPageUrl() { return PAGE_URL; }
}

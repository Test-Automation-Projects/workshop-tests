package com.automated.tests.java.ui;

import com.automated.tests.java.api.BaseTest;
import com.automated.tests.java.core.config.Config;
import com.automated.tests.java.core.listeners.AllureSelenide;
import com.automated.tests.java.ui.pages.StepikCatalogPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseUITest extends BaseTest {

    @BeforeSuite
    public void setupUISuite() {
        Configuration.baseUrl = Config.baseUrl;
        SelenideLogger.addListener("Allure", new AllureSelenide());
    }

    @AfterMethod
    public void tearDown() {
        Selenide.clearBrowserLocalStorage();
        Selenide.closeWebDriver();
    }

    @AfterSuite
    public void closeDriver() {
        Selenide.clearBrowserCookies();
    }

    protected void authorizeAsUser() {
        new StepikCatalogPage()
                .open()
                .getMenu()
                .logIn(Config.user)
                .checkAuthorized();
    }
}

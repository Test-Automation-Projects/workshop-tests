package com.automated.tests.java.ui;

import com.automated.tests.java.BaseTest;
import com.automated.tests.java.core.config.Config;
import com.automated.tests.java.core.listeners.AllureSelenide;
import com.automated.tests.java.ui.pages.StepikCatalogPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseUITest extends BaseTest {

    @BeforeClass
    public void setupUISuite() {
        Configuration.baseUrl = Config.baseUrl;
        SelenideLogger.addListener("Allure", new AllureSelenide());
    }

    @AfterClass
    public void tearDown() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        Selenide.closeWebDriver();
    }

    protected void authorizeAsUser() {
        new StepikCatalogPage()
                .open()
                .getMenu()
                .logIn(Config.user)
                .checkAuthorized();
    }
}

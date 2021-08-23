package com.automated.tests.java.api;

import com.automated.tests.java.core.config.Config;
import io.restassured.RestAssured;
import org.assertj.core.api.SoftAssertions;
import org.testng.TestNG;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest extends TestNG {
    protected SoftAssertions softly;

    @BeforeSuite
    public void setupBaseSuite() {
        RestAssured.baseURI = Config.baseUrl;
    }

    @BeforeMethod
    public void setupTest() {
        softly = new SoftAssertions();
    }

    @AfterMethod
    public void closeTest() {
        softly.assertAll();
    }
}

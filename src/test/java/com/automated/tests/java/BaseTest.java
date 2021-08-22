package com.automated.tests.java;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected SoftAssertions softly;

    @BeforeMethod
    public void setupTest() {
        softly = new SoftAssertions();
    }

    @AfterMethod
    public void closeTest() {
        softly.assertAll();
    }
}

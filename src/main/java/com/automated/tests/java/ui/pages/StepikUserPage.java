package com.automated.tests.java.ui.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class StepikUserPage extends Page<StepikUserPage> {
    private final SelenideElement name = $("h1");

    public StepikUserPage(String userId) {
        super("/users/" + userId);
    }

    public SelenideElement getName() {
        return name;
    }
}

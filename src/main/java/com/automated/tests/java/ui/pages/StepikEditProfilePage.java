package com.automated.tests.java.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class StepikEditProfilePage extends Page<StepikEditProfilePage> {
    private final SelenideElement settings = $("#ember44");
    private final SelenideElement firstNameInput = $("#first_name");
    private final SelenideElement lastNameInput = $("#last_name");
    private final SelenideElement supportedLanguagesSelect = $("#supported_languages");
    private final SelenideElement shortBioTextarea = $("#short_bio");
    private final SelenideElement detailsTextarea = $("#details");
    private final SelenideElement saveChanges = $x("//button[text()='Save changes']");
    private final SelenideElement profileSaved = $(byText("Your profile saved."));

    public StepikEditProfilePage(String userId) {
        super("/users/" + userId);
    }

    public StepikEditProfilePage editProfile(String firstName,
                                             String lastName,
                                             String language,
                                             String bio,
                                             String details
    ) {
        settings.shouldBe(Condition.visible).click();
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
        supportedLanguagesSelect.selectOption(language);
        shortBioTextarea.clear();
        shortBioTextarea.sendKeys(bio);
        detailsTextarea.clear();
        detailsTextarea.sendKeys(details);
        saveChanges.click();
        profileSaved.shouldBe(Condition.visible);
        return this;
    }
}
package com.automated.tests.java.ui.elements;

import com.automated.tests.java.ui.models.User;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Menu extends Element<Menu> {
    private final SelenideElement userImage = getElement().$("img[alt~='avatar']");
    private final SelenideElement logInForm = $("#ember192");
    private final SelenideElement loginInput = $("#id_login_email");
    private final SelenideElement passwordInput = $("#id_login_password");
    private final SelenideElement confirmLoginButton = $(".sign-form__btn");

    public Menu() {
        super($("nav"));
    }

    public Menu logIn(User user) {
        logInForm.click();
        loginInput.sendKeys(user.getLogin());
        passwordInput.sendKeys(user.getPassword());
        confirmLoginButton.click();
        return this;
    }

    public Menu checkAuthorized() {
        userImage.shouldBe(Condition.visible);
        return this;
    }
}

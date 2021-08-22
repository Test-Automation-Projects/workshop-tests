package com.automated.tests.java.ui.pages;

import com.automated.tests.java.ui.elements.CourseCard;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class StepikCatalogPage extends Page<StepikCatalogPage> {
    private final SelenideElement searchFormInput = $(".search-form__input ");
    private final SelenideElement loadButton = $(".button_with-loader");
    private final ElementsCollection courseCards = $$(".course-cards__item");

    public StepikCatalogPage() {
        super("/catalog");
    }

    public StepikCatalogPage searchForCourse(String key) {
        searchFormInput.sendKeys(key);
        searchFormInput.pressEnter();
        loadButton.click();
        getFooter().getElement().shouldBe(Condition.visible);
        courseCards.forEach(card -> card.shouldBe(Condition.visible));
        return this;
    }

    public List<CourseCard> getCourses() {
        List<CourseCard> courses = new ArrayList<>();
        courseCards.forEach(card -> courses.add(new CourseCard(card)));
        return courses;
    }

    public CourseCard getCourse(String courseTitle) {
        return getCourses().stream().filter(card ->
                card.getTitle().text().equals(courseTitle)).findFirst().get();
    }
}

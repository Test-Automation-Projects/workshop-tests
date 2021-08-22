package com.automated.tests.java.ui.elements;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

@Getter
public class CourseCard extends Element<CourseCard> {
    public CourseCard(SelenideElement element) {
        super(element);
    }

    private final SelenideElement title = getElement().$(".course-card__title");
    private final SelenideElement authors = getElement().$(".course-card__authors");
    private final SelenideElement cover = getElement().$(".course-card__cover");
    private final String altCover = cover.getAttribute("alt");
    private final SelenideElement price = getElement().$(".course-card__price");
}

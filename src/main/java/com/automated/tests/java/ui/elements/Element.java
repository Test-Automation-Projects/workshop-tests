package com.automated.tests.java.ui.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

class Element<Element> {
    private final SelenideElement element;

    Element(SelenideElement element) {
        this.element = element;
    }

    public SelenideElement getElement() {
        return element;
    }

    public Element checkElementIsVisible() {
        element.shouldBe(Condition.visible);
        return (Element) this;
    }
}

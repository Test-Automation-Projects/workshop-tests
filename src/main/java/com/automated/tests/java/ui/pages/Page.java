package com.automated.tests.java.ui.pages;

import com.automated.tests.java.ui.elements.Footer;
import com.automated.tests.java.ui.elements.Menu;
import com.codeborne.selenide.Selenide;

class Page<Page> {
    private final String url;

    Page(String url) {
        this.url = url;
    }

    public Page open() {
        Selenide.open(url);
        return (Page) this;
    }

    public Menu getMenu() {
        return new Menu();
    }

    public Footer getFooter() {
        return new Footer();
    }
}

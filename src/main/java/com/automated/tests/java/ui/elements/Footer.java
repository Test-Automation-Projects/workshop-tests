package com.automated.tests.java.ui.elements;

import static com.codeborne.selenide.Selenide.$;

public class Footer extends Element<Footer> {
    public Footer() {
        super($("footer"));
    }
}

package com.automated.tests.java.core.config;

import com.automated.tests.java.ui.models.User;

public class Config {
    public static final String baseUrl = "https://stepik.org";

    public static User user = User.builder()
            .login("testuser9876543@gmail.com")
            .password("12345").build();
}

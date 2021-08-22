package com.automated.tests.java.core.config;

import com.automated.tests.java.ui.models.User;

public class Config {
    public static User user = User.builder().login("testuser9876543@gmail.com").password("12345").build();
    public static final String frontUrl = "https://stepik.org";
    public static final String backUrl = "";
}

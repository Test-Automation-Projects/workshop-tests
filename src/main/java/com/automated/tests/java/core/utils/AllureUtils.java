package com.automated.tests.java.core.utils;

import com.automated.tests.java.core.config.Config;
import com.codeborne.selenide.Configuration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Properties;

public class AllureUtils {
    public static void generateAllureEnvironment() {
        try {
            Properties properties = new Properties();
            if (Config.baseUrl != null) properties.setProperty("Base url", Config.baseUrl);
            if (Configuration.browser != null) properties.setProperty("Browser", Configuration.browser);
            if (Configuration.remote != null) properties.setProperty("Remote", Configuration.remote);

            File file = new File("./target/allure-results/environment.properties");
            file.getParentFile().mkdirs();
            Writer inputStream = new FileWriter(file);
            properties.store(inputStream, "Allure Environments");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}

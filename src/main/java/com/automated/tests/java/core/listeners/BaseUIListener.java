package com.automated.tests.java.core.listeners;

import io.qameta.allure.Allure;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.Logs;
import org.testng.ITestResult;

import java.util.List;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseUIListener extends BaseListener {

    @Override
    public void onTestFailure(ITestResult result) {
        super.onTestFailure(result);
        checkLogAndAttachErrors();
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        super.onTestSuccess(result);
        checkLogAndAttachErrors();
    }

    private String getJsErrors() {
        StringBuilder jsErrors = new StringBuilder();
        Logs log = getWebDriver().manage().logs();
        List<LogEntry> logsEntries = log.get("client").getAll();
        for (LogEntry entry : logsEntries) {
            if (entry.getLevel().toString().equals("SEVERE")) {
                jsErrors.append(entry).append("\n");
            }
            if (entry.getMessage().toLowerCase().contains("mixed") &&
                    entry.getMessage().toLowerCase().contains("content")) {
                jsErrors.append(entry).append("\n");
            }
        }
        if (jsErrors.length() == 0) {
            return "";
        }
        return jsErrors.toString();
    }

    private void checkLogAndAttachErrors() {
        String jsErrors = getJsErrors();
        if (!jsErrors.isEmpty()) {
            attachJsErrors(jsErrors);
        }
    }

    private void attachJsErrors(String content) {
        Allure.addAttachment("JavaScript Error", content);
    }
}
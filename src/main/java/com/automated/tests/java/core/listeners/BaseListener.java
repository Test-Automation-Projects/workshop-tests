package com.automated.tests.java.core.listeners;

import com.automated.tests.java.core.utils.AllureUtils;
import com.automated.tests.java.core.utils.LogUtils;
import io.qameta.allure.Allure;
import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.apache.commons.lang3.StringUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

public class BaseListener implements ITestListener {
    private final ByteArrayOutputStream request = new ByteArrayOutputStream();
    private final ByteArrayOutputStream response = new ByteArrayOutputStream();
    private final PrintStream requestVar = new PrintStream(request, true);
    private final PrintStream responseVar = new PrintStream(response, true);


    @Override
    public void onTestStart(ITestResult result) {
        LogUtils.logInfo("[STARTED] " + result.getMethod().getMethodName() +
                " with args: " + Arrays.toString(result.getParameters()));
        setDescription(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        if (request.size() != 0) {
            logRequest(request);
            logResponse(response);
        }
        LogUtils.logInfo("[PASSED] " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        LogUtils.logError("[FAILED] Test failed but it is in defined success ratio " +
                result.getMethod().getMethodName() + " " + Arrays.toString(result.getParameters()) +
                " with Error: " + result.getThrowable().getLocalizedMessage());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        if (request.size() != 0) {
            logRequest(request);
            logResponse(response);
        }
        LogUtils.logError("[FAILED] " + result.getMethod().getMethodName() + " with args: " +
                Arrays.toString(result.getParameters()) + " with error: " +
                result.getThrowable().getLocalizedMessage());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LogUtils.logInfo("[SKIPPED] " + result.getMethod().getMethodName() +
                " " + Arrays.toString(result.getParameters()) + " due to " + result.getThrowable().getMessage());
    }

    @Override
    public void onStart(ITestContext context) {
        RestAssured.filters(new ResponseLoggingFilter(LogDetail.ALL, responseVar),
                new RequestLoggingFilter(LogDetail.ALL, requestVar));
    }

    @Override
    public void onFinish(ITestContext context) {
    }

    public void logRequest(ByteArrayOutputStream stream) {
        Allure.addAttachment("Request", stream.toString());
    }

    public void logResponse(ByteArrayOutputStream stream) {
        Allure.addAttachment("Response", stream.toString());
    }

    private void setDescription(ITestResult result) {
        if (result.getMethod().getDescription() == null || result.getMethod().getDescription().isBlank()) {
            var desc = StringUtils.join(StringUtils.splitByCharacterTypeCamelCase(
                    result.getMethod().getMethodName()), ' ').toLowerCase();
            result.getMethod().setDescription(desc);
        }
    }
}

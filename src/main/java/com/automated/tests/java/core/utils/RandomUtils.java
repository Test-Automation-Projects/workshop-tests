package com.automated.tests.java.core.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomUtils {
    private static final Integer MAX_LENGTH = 10;

    public static String getLetterString() {
        String value = RandomStringUtils.random(MAX_LENGTH, true, false);
        LogUtils.logDebug("Random string generated: " + value);
        return value;
    }

    public static String getMixedString(int length) {
        String value = RandomStringUtils.random(MAX_LENGTH, true, true);
        LogUtils.logDebug("Random string generated: " + value);
        return value;
    }
}

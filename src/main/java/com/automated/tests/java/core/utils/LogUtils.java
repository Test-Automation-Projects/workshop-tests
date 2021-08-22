package com.automated.tests.java.core.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogUtils {
    public static final Logger logger = LogManager.getLogger("main");

    public synchronized static void log(Object msg) {
        logger.info(msg);
    }

    public synchronized static void logInfo(Object msg) {
        String lvl = "[INFO] ";
        logger.info(lvl + msg);
    }

    public synchronized static void logDebug(Object msg) {
        String lvl = "[DEBUG] ";
        logger.debug(lvl + msg);
    }

    public synchronized static void logTrace(Object msg) {
        String lvl = "[TRACE] ";
        logger.trace(lvl + msg);
    }

    public synchronized static void logError(Object msg) {
        String lvl = "[ERROR] ";
        logger.error(lvl + msg);
    }

    public synchronized static void logFatal(Object msg) {
        String lvl = "[FATAL] ";
        logger.fatal(lvl + msg);
    }
}
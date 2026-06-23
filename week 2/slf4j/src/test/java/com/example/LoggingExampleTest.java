package com.example;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import org.slf4j.LoggerFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LoggingExampleTest {

    @Test
    void logsAtTheExpectedLevels() {
        Logger logbackLogger = (Logger) LoggerFactory.getLogger(LoggingExample.class);
        ListAppender<ILoggingEvent> appender = new ListAppender<>();
        appender.start();
        logbackLogger.addAppender(appender);
        new LoggingExample().doaction("tom");
        boolean hasError = false;
        boolean hasWarn = false;
        for (ILoggingEvent event : appender.list) {
            if (event.getLevel() == Level.ERROR) {
                hasError = true;
            }
            if (event.getLevel() == Level.WARN) {
                hasWarn = true;
            }
        }
        assertTrue(hasError);
        assertTrue(hasWarn);
    }
}

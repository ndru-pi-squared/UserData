package com.app.logging;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

public class LogEventTest {

    @Test
    void shouldCreateLogEventWithInfoLevel() {

        LogEvent event =
            new LogEvent(
                LocalDateTime.now(),
                LogLevel.INFO,
                "Application started"
            );

        assertEquals(LogLevel.INFO, event.getLevel());
    }

    @Test
    void shouldCreateLogEventWithEventApplicationStarted() {

        LogEvent event =
            new LogEvent(
                LocalDateTime.now(),
                LogLevel.INFO,
                "Application started"
            );

        assertEquals("Application started", event.getEvent());
    }

    @Test
    void shouldCreateNotNullDateTime() {

        LogEvent event =
            new LogEvent(
                LocalDateTime.now(),
                LogLevel.INFO,
                "Application started"
            );

        assertNotNull(event.getTimestamp());
    }

    @Test
    void shouldCreateValidLogEvent() {

        LogEvent event =
            new LogEvent(
                LocalDateTime.now(),
                LogLevel.INFO,
                "Application started"
            );

        assertEquals(LogLevel.INFO, event.getLevel());
        assertEquals("Application started", event.getEvent());
        assertNotNull(event.getTimestamp());
    }
}
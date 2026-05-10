package com.app.logging;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

public class LogEventTest {
    LocalDateTime fixed = LocalDateTime.of(2024, 1, 1, 12, 0);

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
    void shouldCreateLogWithFixedTimestamp() {

        LogEvent event =
            new LogEvent(
                fixed,
                LogLevel.INFO,
                "Application started"
            );

        assertEquals(fixed, event.getTimestamp());
    }

    @Test
    void shouldCreateLogEventWithFixedTimestamp() {

        LogEvent event =
            new LogEvent(
                fixed,
                LogLevel.INFO,
                "Application started"
            );

        assertEquals(fixed, event.getTimestamp());
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
        assertEquals(
            String.format("[%s] [%s] %s", event.getTimestamp(), event.getLevel(), event.getEvent()),
            event.toString()
        );
    }
}
package com.app.logging;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class LogToFileTest {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS");
    LocalDateTime fixed = LocalDateTime.of(2024, 1, 1, 12, 0);

    @Test //testing if the log file is correctly created
    void shouldCreateLogFile() throws IOException {
        Path path = Path.of("data/log.txt");
        Files.deleteIfExists(path);
        LogToFile logToFile = new LogToFile();
        logToFile.write("This is a test log entry.\n");
        assertTrue(Files.exists(path));

    }
    
    @Test //testing if the log entry is correctly persisted to the file
    void shouldPersistLogEntry() throws IOException {
        Path path = Path.of("data/log.txt");
        LogToFile logToFile = new LogToFile();
        LogEvent event = new LogEvent(fixed, LogLevel.INFO, "This is a test log entry.\n");
        logToFile.write(event.toString());
        
        
        try(BufferedReader reader = Files.newBufferedReader(path)){
            String expected = "[2024-01-01T12:00:00.000000000] [INFO] This is a test log entry.";
            String line = reader.readLine();
            assertEquals(expected, line);
        }
    }

    @Test //testing if the log entry is correctly formatted with the fixed timestamp
    void shouldCreateLogFileWithFixedTimestamp() throws IOException {
        Path path = Path.of("data/log.txt");
        LogToFile logToFile = new LogToFile();
        LogEvent event = new LogEvent(fixed, LogLevel.INFO, "This is a test log entry.\n");
        logToFile.write(event.toString());
        
        
        try(BufferedReader reader = Files.newBufferedReader(path)){
            String line = reader.readLine();
            String expected = String.format("[%s] [%s] %s", fixed.format(formatter), LogLevel.INFO, "This is a test log entry.");
            assertEquals(expected, line);
        }
    
    }

}//class
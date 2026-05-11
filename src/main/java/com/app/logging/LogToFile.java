package com.app.logging;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

//writes LogEvents to a file
public class LogToFile{

    private final Path file = Path.of("data/log.txt");

    public LogToFile() {
        
    }

    public void append(String event){//previous args: Path file, String event
        try {
            Files.writeString(this.file, event, StandardOpenOption.APPEND, StandardOpenOption.CREATE);
        } 
        catch (IOException e) {
            e.printStackTrace(System.out);
        }

    }

    public void write(String event){//previous args: Path file, String event
        try {
            Files.writeString(this.file, event, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } 
        catch (IOException e) {
            e.printStackTrace(System.out);
        }

    }
}
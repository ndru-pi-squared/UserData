package com.app.logging;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

//writes LogEvents to a file
public class LogToFile{

    public void append(Path file, String event){
        try {
            Files.writeString(file, event, StandardOpenOption.APPEND, StandardOpenOption.CREATE);
        } 
        catch (IOException e) {
            e.printStackTrace(System.out);
        }

    }

    public void write(Path file, String event){
        try {
            Files.writeString(file, event, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } 
        catch (IOException e) {
            e.printStackTrace(System.out);
        }

    }
}
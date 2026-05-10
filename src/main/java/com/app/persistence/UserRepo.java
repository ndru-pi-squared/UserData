package com.app.persistence;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

//service class to handle user related operations
class UserRepo {

    public static void writeAccountToFile(Path file, String accountData, boolean append){
        try {
            Files.writeString(file, accountData, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } 
        catch (IOException e) {
            e.printStackTrace(System.out);
        }

    }
}
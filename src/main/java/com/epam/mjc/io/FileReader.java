package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;


public class FileReader {
    FileReader() {
    }
    public  Profile getDataFromFile(File file) {

        Map<String, String> dataMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] keyValue = line.split(": ");
                dataMap.put(keyValue[0].trim(), keyValue[1].trim());
            }

        } catch (FileNotFoundException e) {
            Logger.getLogger("File not found : " + Arrays.toString(e.getStackTrace()));
        } catch (IOException e) {
            Logger.getLogger("IOException : "+ Arrays.toString(e.getStackTrace()));
        }

        return new Profile(dataMap.get("Name"),Integer.parseInt(dataMap.get("Age")),dataMap.get("Email"),Long.parseLong(dataMap.get("Phone")));
    }

}

package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class FileReader {

    public static Profile getDataFromFile(File file) {

        Map<String, String> dataMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] keyValue = line.split(": ");
                dataMap.put(keyValue[0].trim(), keyValue[1].trim());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new Profile(dataMap.get("Name"),Integer.parseInt(dataMap.get("Age")),dataMap.get("Email"),Long.parseLong(dataMap.get("Phone")));
    }

    /*public static void main(String[] args) {
        String directory ="resources";
        String fileName = "Profile.txt";
        String absolutePath = directory + File.separator + fileName;
        File file = new File(absolutePath);
        Profile profile = getDataFromFile(file);
        System.out.println(profile);
    }*/
}

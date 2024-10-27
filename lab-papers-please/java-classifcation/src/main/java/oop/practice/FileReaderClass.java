package oop.practice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileReaderClass {

    // Method to read and map the JSON file to AlienSpecies class
    public List<AlienSpecies> readAndMapJson(String filePath) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            // Map the JSON file directly to a List of AlienSpecies objects
            List<AlienSpecies> alienSpeciesList = mapper.readValue(new File(filePath), new TypeReference<List<AlienSpecies>>(){});

            return alienSpeciesList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

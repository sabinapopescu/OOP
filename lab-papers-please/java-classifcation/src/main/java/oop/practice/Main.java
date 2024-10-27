package oop.practice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File inputFile = new File("./lab-papers-please/java-classifcation/src/main/resources/input.json");
        JsonNode data = mapper.readTree(inputFile).get("data");

        Map<String, List<AlienSpecies>> aliensByPlanet = new HashMap<>();

        for (JsonNode entry : data) {
            int id = entry.has("id") ? entry.get("id").asInt() : -1;
            boolean isHumanoid = entry.has("isHumanoid") && entry.get("isHumanoid").asBoolean();
            String planet = entry.has("planet") ? entry.get("planet").asText().trim() : "intergalactic";
            int age = entry.has("age") ? entry.get("age").asInt() : -1;

            List<String> traits = new ArrayList<>();
            if (entry.has("traits")) {
                for (JsonNode trait : entry.get("traits")) {
                    traits.add(trait.asText());
                }
            }

            AlienSpecies alien = new AlienSpecies(id, isHumanoid, planet, age, traits);
            String planetKey = alien.getPlanet();
            aliensByPlanet.computeIfAbsent(planetKey, k -> new ArrayList<>()).add(alien);
        }

        // Directory setup
        File outputDir = new File("./lab-papers-please/java-classifcation/src/main/resources/output").getAbsoluteFile();
        if (!outputDir.exists()) outputDir.mkdirs();
        File planetOutputDir = new File(outputDir, "planet");
        if (!planetOutputDir.exists()) planetOutputDir.mkdirs();

        // Write planet files
        View.writeAliensByPlanetToFile(aliensByPlanet, planetOutputDir);

        System.out.println("Files saved to: " + outputDir.getAbsolutePath());
    }
}

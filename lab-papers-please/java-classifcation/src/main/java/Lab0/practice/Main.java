package Lab0.practice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File inputFile = new File("./lab-papers-please/java-classifcation/src/main/resources/input.json");

        JsonNode root = mapper.readTree(inputFile);

        // Dynamically check for the top-level key
        JsonNode data = root.get("data");  // Check "data" first
        if (data == null) {
            data = root.get("input");  // Try "input" if "data" is missing
        }

        if (data == null || !data.isArray()) {
            System.out.println("Error: The data field is missing or not an array in the JSON file.");
            return;
        }

        // Initialize Universe objects
        Universe marvel = new Universe("marvel", new ArrayList<>(), "marvel.json");
        Universe starWars = new Universe("starWars", new ArrayList<>(), "starwars.json");
        Universe hitchhikers = new Universe("hitchHiker", new ArrayList<>(), "hitchhikers.json");
        Universe rings = new Universe("rings", new ArrayList<>(), "rings.json");

        // Classify each alien and add it to the appropriate universe
        for (JsonNode entry : data) {
            AlienSpecies alien = mapToAlien(entry);
            Universe universe = classifyAlien(alien, marvel, starWars, hitchhikers, rings);
            universe.getIndividuals().add(alien);
        }

        // Output directory setup
        File outputDir = new File("./lab-papers-please/java-classifcation/src/main/resources/output").getAbsoluteFile();
        if (!outputDir.exists()) outputDir.mkdirs();

        // Save each universe to its respective file
        marvel.saveToFile(outputDir);
        starWars.saveToFile(outputDir);
        hitchhikers.saveToFile(outputDir);
        rings.saveToFile(outputDir);

        System.out.println("Files saved to: " + outputDir.getAbsolutePath());
    }

    private static AlienSpecies mapToAlien(JsonNode entry) {
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

        return new AlienSpecies(id, isHumanoid, planet, age, traits);
    }

    // Method to classify each alien based on the criteria and return the appropriate universe
    private static Universe classifyAlien(AlienSpecies alien, Universe marvel, Universe starWars, Universe hitchhikers, Universe rings) {
        String planet = alien.getPlanet();
        if ("Asgard".equals(planet)) {
            return marvel;
        } else if ("Endor".equals(planet) || "Kashyyyk".equals(planet)) {
            return starWars;
        } else if ("Betelgeuse".equals(planet)) {
            return hitchhikers;
        } else if ("Earth".equals(planet)) {
            return rings;
        }

        for (String trait : alien.getTraits()) {
            switch (trait) {
                case "BLONDE":
                case "TALL":
                    return marvel;
                case "HAIRY":
                case "GREEN":
                    return starWars;
                case "EXTRA_HEAD":
                case "EXTRA_ARMS":
                    return hitchhikers;
                case "BULKY":
                    return rings;
            }
        }

        int age = alien.getAge();
        if (alien.isHumanoid() && age > 1000) {
            return marvel;
        } else if (age < 100) {
            return starWars;
        } else if (age > 100) {
            return rings;
        }

        return hitchhikers;
    }
}
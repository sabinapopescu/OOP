package oop.practice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    File inputFile = new File("./lab-papers-please/java-classifcation/src/main/resources/test-input.json");
    JsonNode data = mapper.readTree(inputFile).get("data");

    // Create Universe objects that store AlienSpecies objects
    Universe starWars = new Universe("starWars", new ArrayList<>());
    Universe hitchhikers = new Universe("hitchHiker", new ArrayList<>());
    Universe marvel = new Universe("marvel", new ArrayList<>());
    Universe rings = new Universe("rings", new ArrayList<>());

    Scanner scanner = new Scanner(System.in);

    for (JsonNode entry : data) {
      // Extract values from the JSON, using default values if fields are missing
      int id = entry.has("id") ? entry.get("id").asInt() : -1;
      boolean isHumanoid = entry.has("isHumanoid") && entry.get("isHumanoid").asBoolean();
      String planet = entry.has("planet") ? entry.get("planet").asText() : "Unknown";
      int age = entry.has("age") ? entry.get("age").asInt() : -1;

      // Extract traits as a list
      List<String> traits = new ArrayList<>();
      if (entry.has("traits")) {
        for (JsonNode trait : entry.get("traits")) {
          traits.add(trait.asText());
        }
      }

      // Create an AlienSpecies object
      AlienSpecies alien = new AlienSpecies(id, isHumanoid, planet, age, traits);
      alien.displayInfo();  // Show the alien's info

      System.out.println("Assign to a universe: 1 for Star Wars, 2 for Hitchhiker's, 3 for Marvel, 4 for Rings");
      String userInput = scanner.nextLine();

      // Add the alien species object to the appropriate universe
      switch (userInput) {
        case "1":
          starWars.individuals().add(alien);  // Add AlienSpecies object
          break;
        case "2":
          hitchhikers.individuals().add(alien);  // Add AlienSpecies object
          break;
        case "3":
          marvel.individuals().add(alien);  // Add AlienSpecies object
          break;
        case "4":
          rings.individuals().add(alien);  // Add AlienSpecies object
          break;
        default:
          System.out.println("Invalid input");
      }
    }

    scanner.close();

    // Get the absolute path to ensure we're in the right directory
    File outputDir = new File("src/main/resources/output").getAbsoluteFile();
    if (!outputDir.exists()) {
      outputDir.mkdirs();  // Create the directory if it doesn't exist
    }

    // Print out the absolute path for debugging
    System.out.println("Saving files to: " + outputDir.getAbsolutePath());

    // Save the classified universes (Jackson will now serialize the AlienSpecies objects correctly)
    mapper.writeValue(new File(outputDir, "starwars.json"), starWars);
    mapper.writeValue(new File(outputDir, "hitchhiker.json"), hitchhikers);
    mapper.writeValue(new File(outputDir, "rings.json"), rings);
    mapper.writeValue(new File(outputDir, "marvel.json"), marvel);
  }
}

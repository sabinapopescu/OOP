package oop.practice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.text.Normalizer;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    File inputFile = new File("./lab-papers-please/java-classifcation/src/main/resources/input.json");
    JsonNode data = mapper.readTree(inputFile).get("data");

    Universe starWars = new Universe("starWars", new ArrayList<>());
    Universe hitchhikers = new Universe("hitchHiker", new ArrayList<>());
    Universe marvel = new Universe("marvel", new ArrayList<>());
    Universe rings = new Universe("rings", new ArrayList<>());

    Map<String, List<AlienSpecies>> aliensByPlanet = new HashMap<>();

    Scanner scanner = new Scanner(System.in);

    for (JsonNode entry : data) {
      int id = entry.has("id") ? entry.get("id").asInt() : -1;
      boolean isHumanoid = entry.has("isHumanoid") && entry.get("isHumanoid").asBoolean();

      String planet = "intergalactic";  // Default to "intergalactic"
      if (entry.has("planet")) {
        String planetValue = entry.get("planet").asText().trim();
        if (!planetValue.isEmpty()) {
          planet = planetValue;
        }
      }

      int age = entry.has("age") ? entry.get("age").asInt() : -1;

      List<String> traits = new ArrayList<>();
      if (entry.has("traits")) {
        for (JsonNode trait : entry.get("traits")) {
          traits.add(trait.asText());
        }
      }

      AlienSpecies alien = new AlienSpecies(id, isHumanoid, planet, age, traits);
      alien.displayInfo();

      System.out.println("Assign to a universe: 1 for Star Wars, 2 for Hitchhiker's, 3 for Marvel, 4 for Rings: ");
      String userInput = scanner.nextLine();

      switch (userInput) {
        case "1":
          starWars.getIndividuals().add(alien);
          break;
        case "2":
          hitchhikers.getIndividuals().add(alien);
          break;
        case "3":
          marvel.getIndividuals().add(alien);
          break;
        case "4":
          rings.getIndividuals().add(alien);
          break;
        default:
          System.out.println("Invalid input");
      }


      String planetKey = alien.getPlanet();


      aliensByPlanet.computeIfAbsent(planetKey, k -> new ArrayList<>());


      aliensByPlanet.get(planetKey).add(alien);
    }

    scanner.close();


    List<AlienSpecies> allAliens = new ArrayList<>();
    allAliens.addAll(starWars.getIndividuals());
    allAliens.addAll(hitchhikers.getIndividuals());
    allAliens.addAll(marvel.getIndividuals());
    allAliens.addAll(rings.getIndividuals());


    File outputDir = new File("./lab-papers-please/java-classifcation/src/main/resources/output").getAbsoluteFile();
    if (!outputDir.exists()) {
      outputDir.mkdirs();
    }

    File planetOutputDir = new File(outputDir, "planet");
    if (!planetOutputDir.exists()) {
      planetOutputDir.mkdirs();
    }


    System.out.println("Saving universe files to: " + outputDir.getAbsolutePath());
    System.out.println("Saving planet files to: " + planetOutputDir.getAbsolutePath());


    mapper.writeValue(new File(outputDir, "starwars.json"), starWars);
    mapper.writeValue(new File(outputDir, "hitchhiker.json"), hitchhikers);
    mapper.writeValue(new File(outputDir, "rings.json"), rings);
    mapper.writeValue(new File(outputDir, "marvel.json"), marvel);


    for (Map.Entry<String, List<AlienSpecies>> entry : aliensByPlanet.entrySet()) {
      String planetName = entry.getKey();
      List<AlienSpecies> aliens = entry.getValue();

      String sanitizedPlanetName = sanitizeFilename(planetName);


      File planetFile = new File(planetOutputDir, sanitizedPlanetName + ".json");


      mapper.writeValue(planetFile, aliens);
    }
  }

  private static String sanitizeFilename(String inputName) {
    String normalized = Normalizer.normalize(inputName, Normalizer.Form.NFD);
    normalized = normalized.replaceAll("[^\\p{ASCII}]", "");
    return normalized.replaceAll("[^a-zA-Z0-9\\.\\-]", "_");
  }
}

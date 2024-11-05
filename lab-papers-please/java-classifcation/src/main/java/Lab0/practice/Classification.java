package oop.practice;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.io.IOException;

public class Classification {

    private String path;
    //String path = "./lab-papers-please/java-classifcation/src/main/resources/input.json";
    Classification(String path) {
        this.path = path;
    }
    public Universe[] test(JsonNode data) {

        Universe starWars = new Universe("starWars", new ArrayList<>());
        Universe hitchhikers = new Universe("hitchHiker", new ArrayList<>());
        Universe marvel = new Universe("marvel", new ArrayList<>());
        Universe rings = new Universe("rings", new ArrayList<>());

        for (JsonNode entry : data) {
            String universe = classifyEntry(entry);
            switch (universe) {
                case "starWars":
                    starWars.individuals().add(entry);
                    break;
                case "hitchHiker":
                    hitchhikers.individuals().add(entry);
                    break;
                case "marvel":
                    marvel.individuals().add(entry);
                    break;
                case "rings":
                    rings.individuals().add(entry);
                    break;
                default:
                    System.out.println("Entry does not match any known universe: " + entry.toString());
            }
        }

        return new Universe[] { starWars, hitchhikers, marvel, rings };
    }

    private String classifyEntry(JsonNode entry) {
        String isHumanoid = entry.has("isHumanoid") ? entry.get("isHumanoid").asText() : "null";
        String planet = entry.has("planet") ? entry.get("planet").asText() : "null";
        String age = entry.has("age") ? entry.get("age").asText() : "null";
        String traits = entry.has("traits") ? entry.get("traits").toString() : "null";

        if (isStarWars(isHumanoid, planet, age, traits)) {
            return "starWars";
        } else if (isMarvel(isHumanoid, planet, age, traits)) {
            return "marvel";
        } else if (isHitchHiker(isHumanoid, planet, age, traits)) {
            return "hitchHiker";
        } else if (isRings(isHumanoid, planet, age, traits)) {
            return "rings";
        }
        return "unknown";
    }

    private static boolean isStarWars(String isHumanoid, String planet, String age, String traits) {
        if (!(isHumanoid.equals("null") || isHumanoid.equals("false"))) {
            return false;
        }
        if (!(planet.equals("null") || planet.contains("Kashyyyk") || planet.contains("Endor"))) {
            return false;
        }
        if (!(age.equals("null") || Integer.parseInt(age) <= 400)) {
            return false;
        }
        if (!(traits.equals("null") || traits.contains("HAIRY") || traits.contains("TALL")
                || traits.contains("SHORT"))) {
            return false;
        }
        return true;
    }

    private static boolean isMarvel(String isHumanoid, String planet, String age, String traits) {
        if (!(isHumanoid.equals("null") || isHumanoid.equals("true"))) {
            return false;
        }
        if (!(planet.equals("null") || planet.contains("Asgard"))) {
            return false;
        }
        if (!(age.equals("null") || Integer.parseInt(age) <= 5000)) {
            return false;
        }
        if (!(traits.equals("null") || traits.contains("BLONDE") || traits.contains("TALL"))) {
            return false;
        }
        return true;
    }

    private static boolean isHitchHiker(String isHumanoid, String planet, String age, String traits) {
        if (!(isHumanoid.equals("null") || isHumanoid.equals("true") || isHumanoid.equals("false"))) {
            return false;
        }
        if (!(planet.equals("null") || planet.contains("Betelgeuse") || planet.contains("Vogsphere"))) {
            return false;
        }
        if (!(age.equals("null") || Integer.parseInt(age) <= 200)) {
            return false;
        }
        if (!(traits.equals("null") || traits.contains("EXTRA_ARMS") || traits.contains("EXTRA_HEAD")
                || traits.contains("GREEN") || traits.contains("BULKY"))) {
            return false;
        }
        return true;
    }

    private static boolean isRings(String isHumanoid, String planet, String age, String traits) {
        if (!(isHumanoid.equals("null") || isHumanoid.equals("true"))) {
            return false;
        }
        if (!(planet.equals("null") || planet.contains("Earth"))) {
            return false;
        }
        if (!(age.equals("null") || Integer.parseInt(age) <= 10000)) {
            return false;
        }
        if (!(traits.equals("null") || traits.contains("BLONDE") || traits.contains("POINTY_EARS")
                || traits.contains("SHORT") || traits.contains("BULKY"))) {
            return false;
        }
        return true;
    }

}
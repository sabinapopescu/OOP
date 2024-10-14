package oop.practice;

import java.util.List;

public class AlienSpecies {
    private int id;
    private boolean isHumanoid;
    private String planet;
    private int age;
    private List<String> traits;

    // Constructor
    public AlienSpecies(int id, boolean isHumanoid, String planet, int age, List<String> traits) {
        this.id = id;
        this.isHumanoid = isHumanoid;
        this.planet = planet;
        this.age = age;
        this.traits = traits;
    }

    // Getters for all fields
    public int getId() {
        return id;
    }

    public boolean isHumanoid() {
        return isHumanoid;
    }

    public String getPlanet() {
        return planet;
    }

    public int getAge() {
        return age;
    }

    public List<String> getTraits() {
        return traits;
    }

    public void displayInfo() {
        System.out.println("Alien ID: " + id);
        System.out.println("Humanoid: " + isHumanoid);
        System.out.println("Planet: " + (planet != null ? planet : "Unknown"));
        System.out.println("Age: " + age);
        System.out.println("Traits: " + traits);
    }
}

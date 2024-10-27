package oop.practice;

import java.util.List;

public class AlienSpecies {
    private int id;
    private boolean isHumanoid;
    private String planet;
    private int age;
    private List<String> traits;

    public AlienSpecies(int id, boolean isHumanoid, String planet, int age, List<String> traits) {
        this.id = id;
        this.isHumanoid = isHumanoid;
        this.planet = planet;
        this.age = age;
        this.traits = traits;
    }

    // Getters
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

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setHumanoid(boolean humanoid) {
        isHumanoid = humanoid;
    }

    public void setPlanet(String planet) {
        this.planet = planet;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setTraits(List<String> traits) {
        this.traits = traits;
    }

    public void displayInfo() {
        System.out.println("Alien ID: " + id);
        System.out.println("Humanoid: " + isHumanoid);
        System.out.println("Planet: " + planet);
        System.out.println("Age: " + age);
        System.out.println("Traits: " + traits);
    }

    @Override
    public String toString() {
        return "AlienSpecies{" +
                "id=" + id +
                ", isHumanoid=" + isHumanoid +
                ", planet='" + planet + '\'' +
                ", age=" + age +
                ", traits=" + traits +
                '}';
    }
}

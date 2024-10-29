package Lab0.practice;

import java.util.List;

public class Universe {
    private String name;
    private List<AlienSpecies> individuals;

    public Universe(String name, List<AlienSpecies> individuals) {
        this.name = name;
        this.individuals = individuals;
    }

    public String getName() {
        return name;
    }

    public List<AlienSpecies> getIndividuals() {
        return individuals;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIndividuals(List<AlienSpecies> individuals) {
        this.individuals = individuals;
    }
}

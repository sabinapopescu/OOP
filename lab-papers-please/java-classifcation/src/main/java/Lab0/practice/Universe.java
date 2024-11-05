package Lab0.practice;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Universe {
    private String name;
    private List<AlienSpecies> individuals;
    private String filename;  // Add filename attribute for saving

    public Universe(String name, List<AlienSpecies> individuals, String filename) {
        this.name = name;
        this.individuals = individuals;
        this.filename = filename;
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

    // Method to save the universe's individuals to a file
    public void saveToFile(File outputDir) throws IOException {
        ObjectMapper mapper = new ObjectMapper().enable(com.fasterxml.jackson.databind.SerializationFeature.INDENT_OUTPUT);
        File file = new File(outputDir, filename);
        mapper.writeValue(file, this.individuals);
    }
}

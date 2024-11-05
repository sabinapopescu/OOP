package Lab0.practice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;
import java.text.Normalizer;
import java.util.List;
import java.util.Map;

public class View {
    private static final ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    // Writes a list of aliens to a specified file in the output directory
    public static void writeAliensToFile(List<AlienSpecies> aliens, String fileName, File outputDir) throws IOException {
        File file = new File(outputDir, fileName);
        mapper.writeValue(file, aliens);
    }

    public static void writeAliensByPlanetToFile(Map<String, List<AlienSpecies>> aliensByPlanet, File outputDir) throws IOException {
        for (Map.Entry<String, List<AlienSpecies>> entry : aliensByPlanet.entrySet()) {
            String sanitizedPlanetName = sanitizeFilename(entry.getKey());
            File file = new File(outputDir, sanitizedPlanetName + ".json");
            mapper.writeValue(file, entry.getValue());
        }
    }

    // Helper method to sanitize filenames
    private static String sanitizeFilename(String inputName) {
        String normalized = Normalizer.normalize(inputName, Normalizer.Form.NFD);
        normalized = normalized.replaceAll("[^\\p{ASCII}]", "");
        return normalized.replaceAll("[^a-zA-Z0-9\\.\\-]", "_");
    }
}

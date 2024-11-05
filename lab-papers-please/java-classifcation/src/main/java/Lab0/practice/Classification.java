package Lab0.practice;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.ArrayList;
import java.io.IOException;

public class Classification {

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

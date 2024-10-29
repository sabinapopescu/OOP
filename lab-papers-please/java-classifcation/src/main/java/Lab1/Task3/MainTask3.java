package Lab1.Task3;

import Lab1.Task1.Display;
import java.util.List;
import java.util.ArrayList;

public class MainTask3 {
    public static void main(String[] args) {
        // Create some Display objects
        Display display1 = new Display(1920, 1080, 96.0f, "Display 1");
        Display display2 = new Display(2560, 1440, 109.0f, "Display 2");
        Display display3 = new Display(1920, 1080, 90.0f, "Display 3");

        // Create an Assistant and assign displays
        Assistant assistant = new Assistant("Tech Assistant");
        assistant.assignDisplay(display1);
        assistant.assignDisplay(display2);
        assistant.assignDisplay(display3);

        // Perform comparisons
        System.out.println("\nAssisting with comparisons:");
        assistant.assist();

        // Buy a display and check remaining list
        System.out.println("\nBuying a display:");
        assistant.buyDisplay(display2);

        System.out.println("\nAssisting with comparisons after buying:");
        assistant.assist();
    }
}

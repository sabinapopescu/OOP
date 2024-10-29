package Lab1;

public class Main {
    public static void main(String[] args) {
        // Instantiate Display objects
        Display display1 = new Display(1920, 1080, 96.0f, "Display 1");
        Display display2 = new Display(2560, 1440, 109.0f, "Display 2");
        Display display3 = new Display(1920, 1080, 90.0f, "Display 3");

        // Compare displays
        System.out.println("Comparing Display 1 and Display 2:");
        display1.compareWithMonitor(display2);

        System.out.println("\nComparing Display 2 and Display 3:");
        display2.compareWithMonitor(display3);

        System.out.println("\nComparing Display 1 and Display 3:");
        display1.compareWithMonitor(display3);
    }
}

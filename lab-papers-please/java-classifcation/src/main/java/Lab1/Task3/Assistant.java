package Lab1.Task3;

import Lab1.Task1.Display;
import java.util.ArrayList;
import java.util.List;

public class Assistant {
    private String assistantName;
    private List<Display> assignedDisplays;

    // Constructor
    public Assistant(String assistantName) {
        this.assistantName = assistantName;
        this.assignedDisplays = new ArrayList<>();
    }

    // Adds a Display object to the assignedDisplays list
    public void assignDisplay(Display d) {
        assignedDisplays.add(d);
        System.out.println(d.getModel() + " has been assigned to " + assistantName);
    }

    // Iterates through the assignedDisplays list, comparing each Display object sequentially
    public void assist() {
        for (int i = 0; i < assignedDisplays.size() - 1; i++) {
            Display currentDisplay = assignedDisplays.get(i);
            Display nextDisplay = assignedDisplays.get(i + 1);
            System.out.println("Comparing " + currentDisplay.getModel() + " with " + nextDisplay.getModel());
            currentDisplay.compareWithMonitor(nextDisplay);
        }
    }

    // Removes a Display object from the list and returns it
    public Display buyDisplay(Display d) {
        if (assignedDisplays.remove(d)) {
            System.out.println(d.getModel() + " has been bought and removed from the list.");
            return d;
        } else {
            System.out.println(d.getModel() + " is not in the assigned list.");
            return null;
        }
    }
}

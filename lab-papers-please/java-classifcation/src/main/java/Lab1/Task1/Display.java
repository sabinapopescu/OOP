package  Lab1.Task1;

public class Display {
    private int width;
    private int height;
    private float ppi;
    private String model;

    public Display(int width, int height, float ppi, String model) {
        this.width = width;
        this.height = height;
        this.ppi = ppi;
        this.model = model;
    }

    public void compareSize(Display m) {
        int thisSize = this.width * this.height;
        int otherSize = m.width * m.height;
        if (thisSize > otherSize) {
            System.out.println(this.model + " has a larger size than " + m.model);
        } else if (thisSize < otherSize) {
            System.out.println(m.model + " has a larger size than " + this.model);
        } else {
            System.out.println(this.model + " and " + m.model + " have the same size.");
        }
    }

    public void compareSharpness(Display m) {
        if (this.ppi > m.ppi) {
            System.out.println(this.model + " is sharper than " + m.model);
        } else if (this.ppi < m.ppi) {
            System.out.println(m.model + " is sharper than " + this.model);
        } else {
            System.out.println(this.model + " and " + m.model + " have the same sharpness.");
        }
    }

    public void compareWithMonitor(Display m) {
        compareSize(m);
        compareSharpness(m);
    }

    public String getModel() {
        return model;
    }
}

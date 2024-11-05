package Lab2.Task2;

public class Coffee {
    protected Intensity coffeeIntensity;
    protected String name;

    public Coffee(Intensity coffeeIntensity) {
        this.coffeeIntensity = coffeeIntensity;
        this.name = "Coffee"; // Default name for the base Coffee class
    }

    public void printCoffeeDetails() {
        System.out.println("Making " + name);
        System.out.println("Intensity set to " + coffeeIntensity);
    }
}


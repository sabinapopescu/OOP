package Lab2.Task3;

public class Americano extends Coffee {
    private int mlOfWater;

    public Americano(Intensity coffeeIntensity, int mlOfWater) {
        super(coffeeIntensity);
        this.mlOfWater = mlOfWater;
        this.name = "Americano";
    }

    public final Americano makeAmericano() {
        super.makeCoffee();  // Call base class method
        System.out.println("Adding " + mlOfWater + " mls of water");
        return this;
    }
}




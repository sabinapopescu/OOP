package Lab2.Task3;

public class Cappuccino extends Coffee {
    private int mlOfMilk;

    public Cappuccino(Intensity coffeeIntensity, int mlOfMilk) {
        super(coffeeIntensity);
        this.mlOfMilk = mlOfMilk;
        this.name = "Cappuccino";
    }

    public final Cappuccino makeCappuccino() {
        super.makeCoffee();  // Call base class method
        System.out.println("Adding " + mlOfMilk + " mls of milk");
        return this;
    }
}


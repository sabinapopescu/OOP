package Lab2.Task4;

class Cappuccino extends Coffee {
    private int mlOfMilk;

    public Cappuccino(Intensity coffeeIntensity, int mlOfMilk) {
        super(coffeeIntensity);
        this.mlOfMilk = mlOfMilk;
        this.name = "Cappuccino";
    }

    public final Cappuccino makeCappuccino() {
        super.makeCoffee();
        System.out.println("Adding " + mlOfMilk + " mls of milk");
        return this;
    }
}


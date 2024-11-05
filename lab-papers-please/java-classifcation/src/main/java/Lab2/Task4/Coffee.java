package Lab2.Task4;

class Coffee {
    protected Intensity coffeeIntensity;
    protected String name;

    public Coffee(Intensity coffeeIntensity) {
        this.coffeeIntensity = coffeeIntensity;
        this.name = "Coffee";
    }

    public final Coffee makeCoffee() {
        System.out.println("Making " + name);
        System.out.println("Intensity set to " + coffeeIntensity);
        return this;
    }
}

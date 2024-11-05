package Lab2.Task3;

public class PumpkinSpiceLatte extends Cappuccino {
    private int mgOfPumpkinSpice;

    public PumpkinSpiceLatte(Intensity coffeeIntensity, int mlOfMilk, int mgOfPumpkinSpice) {
        super(coffeeIntensity, mlOfMilk);
        this.mgOfPumpkinSpice = mgOfPumpkinSpice;
        this.name = "Pumpkin Spice Latte";
    }

    public final PumpkinSpiceLatte makePumpkinSpiceLatte() {
        super.makeCappuccino();  // Call Cappuccino's method
        System.out.println("Adding " + mgOfPumpkinSpice + " mls of pumpkin spice");
        return this;
    }
}



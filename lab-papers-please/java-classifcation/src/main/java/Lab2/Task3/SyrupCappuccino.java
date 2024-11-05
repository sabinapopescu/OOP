package Lab2.Task3;

public class SyrupCappuccino extends Cappuccino {
    private SyrupType syrup;

    public SyrupCappuccino(Intensity coffeeIntensity, int mlOfMilk, SyrupType syrup) {
        super(coffeeIntensity, mlOfMilk);
        this.syrup = syrup;
        this.name = "Syrup Cappuccino";
    }

    public final SyrupCappuccino makeSyrupCappuccino() {
        super.makeCappuccino();  // Call Cappuccino's method
        System.out.println("Adding syrup: " + syrup);
        return this;
    }
}


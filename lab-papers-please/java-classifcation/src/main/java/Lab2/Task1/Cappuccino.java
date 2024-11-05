package Lab2.Task1;
public class Cappuccino extends Coffee {
    private int mlOfMilk;
    protected final String coffee = "Cappuccino";

    public Cappuccino(Intensity intensity, int mlOfMilk) {
        super(intensity);
        this.mlOfMilk = mlOfMilk;
    }

    public int getMlOfMilk() {
        return mlOfMilk;
    }

    @Override
    public String getName() {
        return coffee;
    }
}

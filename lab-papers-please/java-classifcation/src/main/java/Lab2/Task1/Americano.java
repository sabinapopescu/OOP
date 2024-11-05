package Lab2.Task1;

public class Americano extends Coffee {
    private int mlOfWater;
    protected final String coffeeName = "Americano";

    public Americano(Intensity intensity, int mlOfWater) {
        super(intensity);
        this.mlOfWater = mlOfWater;
    }

    public int getMlOfWater() {
        return mlOfWater;
    }

    @Override
    public String getName() {
        return coffeeName;
    }
}

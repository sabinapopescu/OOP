package Lab2.Task3;

public class Main {
    public static void main(String[] args) {
        Cappuccino cappuccino = new Cappuccino(Intensity.MEDIUM, 50);
        cappuccino.makeCappuccino();
        System.out.println();

        PumpkinSpiceLatte pumpkinSpiceLatte = new PumpkinSpiceLatte(Intensity.MEDIUM, 100, 50);
        pumpkinSpiceLatte.makePumpkinSpiceLatte();
        System.out.println();

        Americano americano = new Americano(Intensity.MEDIUM, 200);
        americano.makeAmericano();
        System.out.println();

        SyrupCappuccino syrupCappuccino = new SyrupCappuccino(Intensity.STRONG, 150, SyrupType.VANILLA);
        syrupCappuccino.makeSyrupCappuccino();
        System.out.println();
    }
}

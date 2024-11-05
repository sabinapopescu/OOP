package Lab2.Task2;

public class Main {
    public static void main(String[] args) {
        Coffee basicCoffee = new Coffee(Intensity.MEDIUM);
        basicCoffee.printCoffeeDetails();
        System.out.println();

        Cappuccino cappuccino = new Cappuccino(Intensity.MEDIUM, 50);
        cappuccino.printCoffeeDetails();
        System.out.println();

        PumpkinSpiceLatte pumpkinSpiceLatte = new PumpkinSpiceLatte(Intensity.MEDIUM, 100, 50);
        pumpkinSpiceLatte.printCoffeeDetails();
        System.out.println();

        Americano americano = new Americano(Intensity.MEDIUM, 200);
        americano.printCoffeeDetails();
        System.out.println();

        SyrupCappuccino syrupCappuccino = new SyrupCappuccino(Intensity.STRONG, 150, SyrupType.VANILLA);
        syrupCappuccino.printCoffeeDetails();
        System.out.println();
    }
}

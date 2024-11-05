package Lab2.Task1;
public class Main {
    public static void main(String[] args) {
        // Creating instances of each coffee type
        Coffee basicCoffee = new Coffee(Intensity.NORMAL);
        Cappuccino cappuccino = new Cappuccino(Intensity.STRONG, 150);
        PumpkinSpiceLatte pumpkinSpiceLatte = new PumpkinSpiceLatte(Intensity.LIGHT, 120, 50);
        Americano americano = new Americano(Intensity.NORMAL, 200);
        SyrupCappuccino syrupCappuccino = new SyrupCappuccino(Intensity.STRONG, 150, SyrupType.VANILLA);

        // Printing details of each coffee type
        System.out.println("Basic Coffee:");
        System.out.println("Name: " + basicCoffee.getName());
        System.out.println("Intensity: " + basicCoffee.getCoffeeIntensity());

        System.out.println("\nCappuccino:");
        System.out.println("Name: " + cappuccino.getName());
        System.out.println("Intensity: " + cappuccino.getCoffeeIntensity());
        System.out.println("Milk (ml): " + cappuccino.getMlOfMilk());

        System.out.println("\nPumpkin Spice Latte:");
        System.out.println("Name: " + pumpkinSpiceLatte.getName());
        System.out.println("Intensity: " + pumpkinSpiceLatte.getCoffeeIntensity());
        System.out.println("Milk (ml): " + pumpkinSpiceLatte.getMlOfMilk());
        System.out.println("Pumpkin Spice (mg): " + pumpkinSpiceLatte.getMgOfPumpkinSpice());

        System.out.println("\nAmericano:");
        System.out.println("Name: " + americano.getName());
        System.out.println("Intensity: " + americano.getCoffeeIntensity());
        System.out.println("Water (ml): " + americano.getMlOfWater());

        System.out.println("\nSyrup Cappuccino:");
        System.out.println("Name: " + syrupCappuccino.getName());
        System.out.println("Intensity: " + syrupCappuccino.getCoffeeIntensity());
        System.out.println("Milk (ml): " + syrupCappuccino.getMlOfMilk());
        System.out.println("Syrup: " + syrupCappuccino.getSyrup());
    }
}

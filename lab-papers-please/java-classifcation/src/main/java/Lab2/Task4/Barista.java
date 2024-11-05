package Lab2.Task4;

import java.util.List;

public class Barista {

    // Method to prepare a list of coffees
    public void prepareCoffees(List<String> coffeeOrders) {
        for (String order : coffeeOrders) {
            switch (order.toLowerCase()) {
                case "cappuccino":
                    Cappuccino cappuccino = new Cappuccino(Intensity.MEDIUM, 50);
                    cappuccino.makeCappuccino();
                    break;
                case "pumpkin spice latte":
                    PumpkinSpiceLatte pumpkinSpiceLatte = new PumpkinSpiceLatte(Intensity.MEDIUM, 100, 50);
                    pumpkinSpiceLatte.makePumpkinSpiceLatte();
                    break;
                case "americano":
                    Americano americano = new Americano(Intensity.MEDIUM, 200);
                    americano.makeAmericano();
                    break;
                case "syrup cappuccino":
                    SyrupCappuccino syrupCappuccino = new SyrupCappuccino(Intensity.STRONG, 150, SyrupType.VANILLA);
                    syrupCappuccino.makeSyrupCappuccino();
                    break;
                default:
                    System.out.println("Unknown coffee type: " + order);
            }
            System.out.println(); // Separate output for each coffee
        }
    }
}

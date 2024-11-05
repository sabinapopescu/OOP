package Lab2.Task4;

import java.util.HashMap;
import java.util.Map;

public class Barista {

    // Method to prepare multiple coffees based on user input
    public void prepareMultipleCoffees(HashMap<String, Map<String, Object>> coffeeOrders) {
        for (String coffeeType : coffeeOrders.keySet()) {
            Map<String, Object> params = coffeeOrders.get(coffeeType);

            switch (coffeeType.toLowerCase()) {
                case "americano":
                    Intensity americanoIntensity = (Intensity) params.get("intensity");
                    int mlOfWater = (int) params.get("mlOfWater");
                    makeAmericano(americanoIntensity, mlOfWater);
                    break;

                case "cappuccino":
                    Intensity cappuccinoIntensity = (Intensity) params.get("intensity");
                    int mlOfMilk = (int) params.get("mlOfMilk");
                    makeCappuccino(cappuccinoIntensity, mlOfMilk);
                    break;

                case "syrup cappuccino":
                    Intensity syrupCappuccinoIntensity = (Intensity) params.get("intensity");
                    int mlOfMilkForSyrup = (int) params.get("mlOfMilk");
                    SyrupType syrupType = (SyrupType) params.get("syrupType");
                    makeSyrupCappuccino(syrupCappuccinoIntensity, mlOfMilkForSyrup, syrupType);
                    break;

                case "pumpkin spice latte":
                    Intensity pumpkinSpiceIntensity = (Intensity) params.get("intensity");
                    int mlOfMilkForPumpkin = (int) params.get("mlOfMilk");
                    int mgOfPumpkinSpice = (int) params.get("mgOfPumpkinSpice");
                    makePumpkinSpiceLatte(pumpkinSpiceIntensity, mlOfMilkForPumpkin, mgOfPumpkinSpice);
                    break;

                default:
                    System.out.println("Unknown coffee type: " + coffeeType);
                    break;
            }
        }
    }

    // Method to make an Americano
    private Coffee makeAmericano(Intensity intensity, int mlOfWater) {
        Americano americano = new Americano(intensity, mlOfWater);
        return americano.makeAmericano();
    }

    // Method to make a Cappuccino
    private Coffee makeCappuccino(Intensity intensity, int mlOfMilk) {
        Cappuccino cappuccino = new Cappuccino(intensity, mlOfMilk);
        return cappuccino.makeCappuccino();
    }

    // Method to make a Syrup Cappuccino
    private Coffee makeSyrupCappuccino(Intensity intensity, int mlOfMilk, SyrupType syrupType) {
        SyrupCappuccino syrupCappuccino = new SyrupCappuccino(intensity, mlOfMilk, syrupType);
        return syrupCappuccino.makeSyrupCappuccino();
    }

    // Method to make a Pumpkin Spice Latte
    private Coffee makePumpkinSpiceLatte(Intensity intensity, int mlOfMilk, int mgOfPumpkinSpice) {
        PumpkinSpiceLatte pumpkinSpiceLatte = new PumpkinSpiceLatte(intensity, mlOfMilk, mgOfPumpkinSpice);
        return pumpkinSpiceLatte.makePumpkinSpiceLatte();
    }
}

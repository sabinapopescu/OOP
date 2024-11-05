package Lab2.Task4;


import Lab2.Task4.Barista;
import Lab2.Task4.Intensity;
import Lab2.Task4.SyrupType;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Barista barista = new Barista();
        HashMap<String, Map<String, Object>> coffeeOrders = new HashMap<>();

        System.out.println("Welcome to the Coffee Shop!");

        while (true) {
            int choice = getCoffeeChoice();

            if (choice == 5) {
                System.out.println("Exiting order process.");
                break;
            }

            Map<String, Object> coffeeParams = new HashMap<>();
            addCoffeeParameters(choice, coffeeParams);
            confirmOrder(choice, coffeeParams, coffeeOrders);
        }

        displayOrderSummary(coffeeOrders);

        if (!coffeeOrders.isEmpty()) {
            System.out.print("Would you like to prepare all orders now? (yes/no): ");
            if (scanner.nextLine().equalsIgnoreCase("yes")) {
                barista.prepareMultipleCoffees(coffeeOrders);
                System.out.println("Thank you for your order! Enjoy your coffee!");
            } else {
                System.out.println("Order canceled. Thank you for visiting the Coffee Shop!");
            }
        } else {
            System.out.println("No orders were placed. Thank you for visiting!");
        }

        scanner.close();
    }

    private static int getCoffeeChoice() {
        System.out.println("\nSelect coffee type:");
        System.out.println("1 - Americano");
        System.out.println("2 - Cappuccino");
        System.out.println("3 - Syrup Cappuccino");
        System.out.println("4 - Pumpkin Spice Latte");
        System.out.println("5 - Exit");

        System.out.print("Enter your choice: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid choice. Please enter a number between 1 and 5: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static void addCoffeeParameters(int choice, Map<String, Object> params) {
        scanner.nextLine();  // Consume newline
        System.out.print("Enter intensity (LIGHT, NORMAL, STRONG): ");
        params.put("intensity", Intensity.valueOf(scanner.nextLine().toUpperCase()));

        switch (choice) {
            case 1 -> {
                System.out.print("Enter ml of water: ");
                params.put("mlOfWater", getIntInput());
            }
            case 2 -> {
                System.out.print("Enter ml of milk: ");
                params.put("mlOfMilk", getIntInput());
            }
            case 3 -> {
                System.out.print("Enter ml of milk: ");
                params.put("mlOfMilk", getIntInput());
                System.out.print("Enter Syrup Type (MACADAMIA, VANILLA, COCONUT, CARAMEL, CHOCOLATE, POPCORN): ");
                params.put("syrupType", SyrupType.valueOf(scanner.nextLine().toUpperCase()));
            }
            case 4 -> {
                System.out.print("Enter ml of milk: ");
                params.put("mlOfMilk", getIntInput());
                System.out.print("Enter mg of pumpkin spice: ");
                params.put("mgOfPumpkinSpice", getIntInput());
            }
            default -> System.out.println("Invalid selection.");
        }
    }

    private static int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a number: ");
            scanner.next();
        }
        int input = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        return input;
    }

    private static void confirmOrder(int choice, Map<String, Object> coffeeParams, HashMap<String, Map<String, Object>> coffeeOrders) {
        String coffeeType = switch (choice) {
            case 1 -> "americano";
            case 2 -> "cappuccino";
            case 3 -> "syrup cappuccino";
            case 4 -> "pumpkin spice latte";
            default -> throw new IllegalStateException("Unexpected value: " + choice);
        };

        System.out.println("\nReview your order:");
        System.out.println("Coffee Type: " + coffeeType.substring(0, 1).toUpperCase() + coffeeType.substring(1));
        coffeeParams.forEach((param, value) -> System.out.println(param + ": " + value));

        System.out.print("Confirm this order? (yes/no): ");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            coffeeOrders.put(coffeeType, coffeeParams);
            System.out.println("Order added!");
        } else {
            System.out.println("Order canceled.");
        }
    }

    private static void displayOrderSummary(HashMap<String, Map<String, Object>> coffeeOrders) {
        if (coffeeOrders.isEmpty()) {
            System.out.println("\nYou have no orders in the queue.");
            return;
        }

        System.out.println("\nOrder Summary:");
        coffeeOrders.forEach((coffeeType, params) -> {
            System.out.println("Coffee Type: " + coffeeType.substring(0, 1).toUpperCase() + coffeeType.substring(1));
            params.forEach((param, value) -> System.out.println("  " + param + ": " + value));
            System.out.println();
        });
    }
}

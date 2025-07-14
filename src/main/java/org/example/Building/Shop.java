package org.example.Building;
import org.example.Product;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Shop extends Building {
    private final List<Product> inventory;

    public Shop(String name) {
        super(name, "Shop");
        inventory = List.of(
                new Product("Soft Drink", 30),
                new Product("Popcorn", 50),
                new Product("Plush Toy", 120),
                new Product("Keychain", 45),
                new Product("Bottle Cap Accessory", 150)
        );
    }

    public void enter() {
        Scanner scanner = new Scanner(System.in);
        List<Product> cart = new ArrayList<>();
        System.out.println("=== 🛒 Zoo Shop ===");
        System.out.println("Available Products:");

        for (int i = 0; i < inventory.size(); i++) {
            Product p = inventory.get(i);
            System.out.printf("%d. %s – ₱%.2f%n", i + 1, p.getName(), p.getPrice());
        }

        System.out.print("\nEnter the numbers of the items you want to buy (comma-separated): ");
        String input = scanner.nextLine();
        String[] selections = input.split(",");

        double total = 0;
        System.out.println("\nSelected:");

        for (String s : selections) {
            try {
                int index = Integer.parseInt(s.trim()) - 1;
                if (index >= 0 && index < inventory.size()) {
                    Product selected = inventory.get(index);
                    cart.add(selected);
                    total += selected.getPrice();
                    System.out.printf("- %s (₱%.2f)%n", selected.getName(), selected.getPrice());
                }
            } catch (NumberFormatException ignored) {
            }
        }

        System.out.printf("Total: ₱%.2f%n", total);

        System.out.print("\nProceed to checkout? (yes/no): ");
        String confirm = scanner.nextLine();

        if (confirm.equalsIgnoreCase("yes")) {
            System.out.println("\nPayment successful!");
            System.out.println("Receipt:");
            for (Product p : cart) {
                System.out.printf("- %s: ₱%.2f%n", p.getName(), p.getPrice());
            }
            System.out.printf("Total Paid: ₱%.2f%n", total);
        } else {
            System.out.println("🛒 Checkout cancelled.");
        }

        System.out.print("\nWhat would you like to do next?");
    }
}


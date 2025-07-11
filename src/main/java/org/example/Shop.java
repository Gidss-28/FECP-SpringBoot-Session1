package org.example;

import java.util.List;

public class Shop {
    private static List<Product> inventory = List.of(
            new Product("Zoo Hat", 100),
            new Product("Elephant Plushie", 200),
            new Product("Giraffe Keychain", 50)
    );

    public static void displayProducts() {
        // TODO: Show all products
    }

    public static List<Product> getUserSelection() {
        // TODO: Accept multiple selections from user
        return null;
    }

    public static void checkout(List<Product> cart, String visitorName) {
        // TODO: Confirm payment and call ReceiptPrinter
    }
}


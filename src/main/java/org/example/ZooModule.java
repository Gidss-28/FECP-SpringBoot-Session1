package org.example;

import org.example.Animal.Animal;
import org.example.Building.Enclosure;
import org.example.Building.Hospital;
import org.example.Building.Shop;

import java.util.ArrayList;
import java.util.Scanner;

public class ZooModule {
    public static void startVisitorFlow(Zoo zoo, Ticket ticket) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=== Zoo Visitor Menu ===");
            System.out.println("1. Visit Enclosure");
            System.out.println("2. Visit Shop");
            System.out.println("3. Visit Hospital");
            System.out.println("4. Exit Zoo");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();
            System.out.println();

            switch (choice) {
                case "1":
                    System.out.println("🦁 You are now visiting the animal enclosures!");
                    ArrayList<Enclosure<? extends Animal>> enclosures = zoo.getEnclosures();

                    // Display enclosures
                    System.out.println("Choose Enclosure:");
                    for (int i = 0; i < enclosures.size(); i++) {
                        System.out.println((i + 1) + ". " + enclosures.get(i).getSpecies());
                    }

                    System.out.print("Choose an option: ");
                    int enclosureIndex;
                    try {
                        enclosureIndex = Integer.parseInt(scanner.nextLine()) - 1;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input.");
                        break;
                    }

                    if (enclosureIndex < 0 || enclosureIndex >= enclosures.size()) {
                        System.out.println("Invalid enclosure choice.");
                        break;
                    }

                    Enclosure<? extends Animal> selectedEnclosure = enclosures.get(enclosureIndex);
                    ArrayList<? extends Animal> animals = selectedEnclosure.getAllAnimals();

                    // Display animals in selected enclosure
                    System.out.println("\nAnimals in " + selectedEnclosure.getSpecies() + " Enclosure:");
                    for (int i = 0; i < animals.size(); i++) {
                        System.out.println((i + 1) + ". " + animals.get(i).getName());
                    }

                    System.out.print("Choose an animal to feed: ");
                    int animalIndex;
                    try {
                        animalIndex = Integer.parseInt(scanner.nextLine()) - 1;
                    } catch (NumberFormatException e) {
                        System.out.println("❌ Invalid input.");
                        break;
                    }

                    if (animalIndex < 0 || animalIndex >= animals.size()) {
                        System.out.println("❌ Invalid animal choice.");
                        break;
                    }

                    Animal selectedAnimal = animals.get(animalIndex);
                    System.out.print("Would you like to feed " + selectedAnimal.getName() + "? (yes/no): ");
                    String confirm = scanner.nextLine();

                    if (confirm.equalsIgnoreCase("yes")) {
                        selectedAnimal.eat();
                        selectedAnimal.makeSound();
                        System.out.println("✅ " + selectedAnimal.getName() + " has been fed!");
                    } else {
                        System.out.println("⏭️ Feeding skipped.");
                    }
                    break;
                case "2":
                    ArrayList<Shop> shops = zoo.getShops();
                    Shop shop = shops.get(0);

                    System.out.println("🛍️ Entering " + shop.getName() + "...");
                    shop.enter();  // launch shop interface
                    break;

                case "3":
                    System.out.println("🏥 Visiting the animal hospital...");

                    Hospital hospital = zoo.getHospitals().get(0);
                    hospital.enter();
                    break;

                case "4":
                    System.out.println("👋 Thanks for visiting, " + ticket.getVisitorName() + "!");
                    return;
                default:
                    System.out.println("❌ Invalid option. Please try again.");
            }
            System.out.println();
        }
    }
}

package org.example;

import org.example.modules.HandlerModule;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo("Wildlife Safari Zoo");
        Scanner scanner = new Scanner(System.in);

        System.out.println("🦁 Welcome to the Zoo Management System! 🦁");
        System.out.println();

        while (true) {
            System.out.println("=== Main Menu ===");
            System.out.println("1. View Zoo Information");
            System.out.println("2. Open/Close Zoo");
            System.out.println("3. View All Animals");
            System.out.println("4. View All Buildings");
            System.out.println("5. Feed All Animals");
            System.out.println("6. Handler Module");
            System.out.println("7. Ticketing System");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            System.out.println();

            switch (choice) {
                case 1:
                    zoo.displayZooInfo();
                    break;
                case 2:
                    if (zoo.isOpen()) {
                        zoo.closeZoo();
                    } else {
                        zoo.openZoo();
                    }
                    System.out.println();
                    break;
                case 3:
                    zoo.displayAllAnimals();
                    break;
                case 4:
                    zoo.displayAllBuildings();
                    break;
                case 5:
                    zoo.feedAllAnimals();
                    System.out.println();
                    break;
                case 6:
                    System.out.println("=== Handler Module ===");
                    HandlerModule handlerModule = new HandlerModule(zoo);
                    handlerModule.main();
                    System.out.println();
                    break;
                case 7:
                    zoo.startTicketingSystem();
                    System.out.println();
                    break;
                case 8:
                    System.out.println("Thank you for using the Zoo Management System!");
                    zoo.closeZoo();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
                    System.out.println();
            }
        }
    }
}
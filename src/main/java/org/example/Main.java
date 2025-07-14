package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo("Wildlife Safari Zoo");
        ZooAdminConsole adminConsole = new ZooAdminConsole(zoo);
        Scanner scanner = new Scanner(System.in);

        // Step 1: Admin must start and open the zoo first
        System.out.println("=== Zoo Admin Console ===");
        adminConsole.start();

        // Step 2: Check if zoo is open before continuing
        if (!zoo.isOpen()) {
            System.out.println("🚫 Zoo is still closed. Please open the zoo first.");
        }

        // Step 3: Show main menu after admin console
        while (true) {
            System.out.println("\n=== Main Menu ===");
            System.out.println("1. Admin Console");
            System.out.println("2. Enter Zoo as Visitor");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Try again.");
                continue;
            }

            switch (choice) {
                case 1:
                    adminConsole.start();
                    break;
                case 2:
                    if (zoo.isOpen()) {
                        zoo.startTicketingSystem(); // ✅ Enters visitor ticketing flow
                    } else {
                        System.out.println("🚫 Zoo is closed. Please contact the admin.");
                    }
                    break;
                case 3:
                    System.out.println("👋 Thank you for visiting the Wildlife Safari Zoo!!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

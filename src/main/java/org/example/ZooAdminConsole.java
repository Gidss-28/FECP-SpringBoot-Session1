package org.example;

import org.example.Zoo;
import org.example.modules.HandlerModule;
import java.util.Scanner;


public class ZooAdminConsole {
    private Zoo zoo;
    private final Scanner scanner;

    public ZooAdminConsole(Zoo zoo) {
        this.zoo = zoo;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("=== Welcome to the Zoo Admin Console ===");
        System.out.println("\nPlease log in.");

        while (true) {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            if (username.equals("admin") && password.equals("password")) {
                System.out.println("\nLogin successful. Welcome!\n");
                break;
            } else {
                System.out.println("Invalid credentials. Please try again.\n");
            }
        }

        loop();
    }

    private void loop() {
        int choice;
        do {
            System.out.println("========== 🦁 ZOO ADMIN MAIN MENU ==========");
            System.out.println("1. Setup Zoo Staff");
            System.out.println("2. Access Handler Module");
            System.out.println("3. Open Zoo to Visitors");
            System.out.println("4. Close Zoo to Visitors");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            String input = scanner.nextLine();
            choice = input.matches("\\d") ? Integer.parseInt(input) : -1;

            switch (choice) {
                case 1 -> zoo.createStaff();
                case 2 -> {
                    HandlerModule handlerModule = new HandlerModule(zoo);
                    handlerModule.main();
                }
                case 3 -> zoo.openZoo();
                case 4 -> zoo.closeZoo();
                case 5 -> System.out.println("👋 Exiting Zoo Admin Console. Goodbye!");
                default -> System.out.println("❗ Invalid option. Please try again.\n");
            }
        } while (choice != 5);
    }
}

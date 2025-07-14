package org.example;

import java.util.*;

public class TicketingSystem {
    private final Scanner scanner;
    private final Map<String, Ticket> tickets;
    private final Zoo zoo;

    public TicketingSystem(Zoo zoo) {
        this.scanner = new Scanner(System.in);
        this.tickets = new HashMap<>();
        this.zoo = zoo;
    }

    public boolean isValidTicket(String ticketCode) {
        Ticket ticket = tickets.get(ticketCode);
        return ticket != null && ticket.isValid();
    }

    public void startTicketingSystem() {
        System.out.println("=== 🎫 WELCOME TO THE ZOO TICKET SHOP ===\n");
        System.out.println("Here's what you can experience in the zoo:");
        System.out.println("Visit Animal Enclosures (Elephant, Lion, Owl)");
        System.out.println("Buy snacks and gifts from our shop");
        System.out.println("Listen to science lectures at the Hospital");

        displayTicketingMenu();
    }

    private void displayTicketingMenu() {
        System.out.print("Would you like to buy a ticket? (yes/no): ");
        String choice = scanner.nextLine();

        if (choice.equals("yes")) {
            System.out.print("Enter your name: ");
            String visitorName = scanner.nextLine();
            System.out.print("Enter your age: ");
            int visitorAge = scanner.nextInt();
            scanner.nextLine();

            Ticket ticket = new Ticket(visitorName, visitorAge);
            ticket.displayTicketInfo();

            System.out.print("Proceed with purchase? (yes/no) ");
            choice = scanner.nextLine();

            if (choice.equals("yes")) {
                System.out.println("Ticket purchased!");
                System.out.println("Your ticket code is: " + ticket.getTicketCode());
                System.out.println();
                System.out.println("[Ticket added to system]");
                System.out.println();

                tickets.put(ticket.getTicketCode(), ticket);

                handleVisitorEntry();
            }
        }
    }

    private void handleVisitorEntry() {
        System.out.println("=== 🎫 Visitor Entry ===");
        System.out.print("Enter your ticket code: ");
        String ticketCode = scanner.nextLine();

        Ticket ticket = tickets.get(ticketCode);

        if (ticket != null && ticket.isValid()) {
            System.out.println("Welcome to the Zoo! Enjoy your visit!");
            ticket.setValid(false);
            ZooModule.startVisitorFlow(zoo, ticket);
        } else if (ticket != null && !ticket.isValid()) {
            System.out.println("This ticket has already been used or is invalid.");
        } else {
            System.out.println("Invalid ticket code. Please try again.");
        }
    }
}
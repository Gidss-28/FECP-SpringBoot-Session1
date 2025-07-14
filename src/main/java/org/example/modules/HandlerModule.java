package org.example.modules;

import org.example.Animal.Animal;
import org.example.Animal.AnimalFactory;
import org.example.Animal.Feline.Feline;
import org.example.Building.BuildingFactory;
import org.example.Building.Enclosure;
import org.example.Person.Staff.Handler;
import org.example.Zoo;

import java.util.ArrayList;
import java.util.Scanner;

public class HandlerModule {
    private final Zoo zoo;

    public HandlerModule(Zoo zoo) {
        this.zoo = zoo;
    }

    public void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name (Handler): ");
        String name = sc.nextLine();

        Handler<? extends Animal> assignedHandler = null;
        for (Handler<? extends Animal> handler : zoo.getHandlers()) {
            if (handler.getName().equalsIgnoreCase(name)) {
                assignedHandler = handler;
                break;
            }
        }

        if (assignedHandler == null) {
            System.out.println("No handler found with that name.");
            return;
        }

        System.out.println("Welcome, Handler " + name + "!\n");

        while (true) {
            System.out.println("--- Animal Duty Menu ---");
            var assignedAnimals = assignedHandler.getAssignedEnclosure().getAllAnimals();

            System.out.println("Animals assigned to you:");
            for (int i = 0; i < assignedAnimals.size(); i++) {
                System.out.println((i + 1) + ". " + assignedAnimals.get(i).getName());
            }

            System.out.print("Choose animal number to interact with (0 to exit): ");
            int animalChoice = Integer.parseInt(sc.nextLine());

            if (animalChoice == 0) break;

            if (animalChoice < 1 || animalChoice > assignedAnimals.size()) {
                System.out.println("Invalid number.");
                continue;
            }

            Animal selected = assignedAnimals.get(animalChoice - 1);

            System.out.println("1. Feed");
            System.out.println("2. Exercise");
            System.out.println("3. Send to Vet");
            System.out.print("Choose an action: ");
            int action = Integer.parseInt(sc.nextLine());

            switch (action) {
                case 1 -> assignedHandler.feedAnimal(selected.getName());
                case 2 -> assignedHandler.exerciseAnimal(selected.getName());
                case 3 -> assignedHandler.examineToVet(selected.getName());
                default -> System.out.println("Invalid action.");
            }
        }
    }
}

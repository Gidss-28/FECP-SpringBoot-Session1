package org.example.Building;

import org.example.Animal.Animal;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Hospital extends Building {
    private final ArrayList<Animal> animals;

    protected Hospital(String name) {
        super(name, "hospital");
        this.animals = new ArrayList<>();
    }

    public ArrayList<Animal> getSickAnimals() {
        ArrayList<Animal> sickAnimals = new ArrayList<>();
        for (Animal a : this.animals) {
            if (!a.isHealthy()) sickAnimals.add(a);
        }
        return sickAnimals;
    }

    public ArrayList<Animal> getHealthyAnimals() {
        ArrayList<Animal> healedAnimals = new ArrayList<>();
        for (Animal a : this.animals) {
            if (a.isHealthy()) healedAnimals.add(a);
        }
        return healedAnimals;
    }

    public void admitAnimal(Animal animal) {
        this.animals.add(animal);
    }

    public void releaseAnimal(String animalName, Enclosure<Animal> enclosure) {
        for (Animal a : this.animals) {
            if (a.getName().equalsIgnoreCase(animalName) && a.isHealthy()) {
                enclosure.addAnimal(a);
                this.animals.remove(a);
                break;
            }
        }
    }

    //  Visitor interface
    public void enter() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=== Zoo Visitor Hospital Monitor ===");
            System.out.println("1. View Sick Animals");
            System.out.println("2. View Healed Animals");
            System.out.println("3. Attend Science Lecture");
            System.out.println("4. Heal Sick Animals");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();
            System.out.println();

            switch (choice) {
                case "1" -> {
                    ArrayList<Animal> sick = getSickAnimals();
                    if (sick.isEmpty()) {
                        System.out.println(" No sick animals currently in the hospital.");
                    } else {
                        System.out.println(" Sick Animals Currently in Hospital:");
                        for (Animal a : sick) System.out.println("- " + a.getName());
                    }
                }
                case "2" -> {
                    ArrayList<Animal> healed = getHealthyAnimals();
                    if (healed.isEmpty()) {
                        System.out.println(" No healed animals yet.");
                    } else {
                        System.out.println(" Healed Animals:");
                        for (Animal a : healed) {
                            System.out.println("- " + a.getName() + " ✅");
                        }
                    }
                }
                case "3" -> {
                    System.out.println(" You attended a science lecture on animal health and care.");
                }
                case "4" -> {
                    ArrayList<Animal> sick = getSickAnimals();
                    if (sick.isEmpty()) {
                        System.out.println(" No sick animals to heal.");
                    } else {
                        System.out.println(" Healing in progress...");
                        for (Animal a : sick) {
                            a.setHealthy(true);
                            System.out.println(" Healed: " + a.getName());
                        }
                    }
                }
                case "5" -> {
                    System.out.println("👋 Exiting Hospital. Take care!");
                    return;
                }
                default -> {
                    System.out.println("Invalid input. Please try again.");
                }
            }

            System.out.println();
        }
    }
}

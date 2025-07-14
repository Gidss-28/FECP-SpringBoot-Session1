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
    private Handler<Feline> handler;
    private Zoo zoo;

    public HandlerModule(Zoo zoo) {
        this.zoo = zoo;
    }

    public void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name (Handler): ");
        String name = sc.nextLine();

        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(AnimalFactory.createFeline("Mufasa", true, null, "lion"));
        animals.add(AnimalFactory.createFeline("Simba", true, null, "lion"));

        Enclosure<Feline> lionEnclosure = (Enclosure<Feline>) BuildingFactory.createEnclosure("Lion Enclosure", "feline", animals);
        handler = new Handler<>(lionEnclosure);
        handler.setName(name);
        
        System.out.println("Welcome, Handler " + name + "!");
        System.out.println();

        while (true) {
            System.out.println("--- Animal Duty Menu ---");
            System.out.println("Animals assigned to you:");
            
            ArrayList<Feline> assignedAnimals = handler.getAssignedEnclosure().getAllAnimals();
            for (int i = 0; i < assignedAnimals.size(); i++) {
                System.out.println((i + 1) + ". " + assignedAnimals.get(i).getName());
            }
            
            System.out.print("Choose animal number to interact with (0 to exit): ");
            int animalChoice;
            try {
                animalChoice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }
            
            if (animalChoice == 0) {
                System.out.println("Finished duties for the day.");
                break;
            }
            
            if (animalChoice < 1 || animalChoice > assignedAnimals.size()) {
                System.out.println("Invalid animal number. Please try again.");
                continue;
            }
            
            Feline selectedAnimal = assignedAnimals.get(animalChoice - 1);
            System.out.println();

            System.out.println("Choose action:");
            System.out.println("1. Feed " + selectedAnimal.getName());
            System.out.println("2. Exercise " + selectedAnimal.getName());
            System.out.println("3. Examine " + selectedAnimal.getName() + " to Vet");
            System.out.print("Choose an option: ");
            
            int actionChoice;
            try {
                actionChoice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }
            
            System.out.println();
            
            switch (actionChoice) {
                case 1:
                    handler.feedAnimal(selectedAnimal.getName());
                    break;
                case 2:
                    handler.exerciseAnimal(selectedAnimal.getName());
                    break;
                case 3:
                    System.out.println("Sending to Hospital...");
                    handler.examineToVet(selectedAnimal.getName());
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    continue;
            }
            
            System.out.println();
        }
    }
}

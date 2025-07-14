package org.example;

import org.example.Animal.Animal;
import org.example.Animal.AnimalFactory;
import org.example.Animal.Bird.Bird;
import org.example.Animal.Feline.Feline;
import org.example.Animal.Pachyderm.Pachyderm;
import org.example.Building.*;
import org.example.Person.Staff.Handler;
import org.example.Person.Staff.Veterinarian;

import java.util.*;

public class Zoo {
    private String name;
    private boolean isOpen;
    private ArrayList<Animal> animals;
    private ArrayList<Building> buildings;
    private ArrayList<Enclosure<? extends Animal>> enclosures;
    private ArrayList<Shop> shops;
    private ArrayList<Hospital> hospitals;
    private ArrayList<Handler<? extends Animal>> handlers;
    private ArrayList<Veterinarian> veterinarians;
    private ArrayList<Visitor> visitors;
    private TicketingSystem ticketingSystem;
    private Map<String, Integer> animalCounts;

    public Zoo() {
        this("Default Zoo");
    }

    public Zoo(String name) {
        this.name = name;
        this.isOpen = false;
        this.animals = new ArrayList<>();
        this.buildings = new ArrayList<>();
        this.enclosures = new ArrayList<>();
        this.shops = new ArrayList<>();
        this.hospitals = new ArrayList<>();
        this.handlers = new ArrayList<>();
        this.veterinarians = new ArrayList<>();
        this.visitors = new ArrayList<>();
        this.ticketingSystem = new TicketingSystem(this);
        this.animalCounts = new HashMap<>();
        initializeZoo();
    }

    private void initializeZoo() {
        createSampleAnimals();
        createEnclosures();
        createBuildings();
        randomlyMakeAnimalsSick();
    }

    private void createSampleAnimals() {
        animals.add(AnimalFactory.createFeline("Mufasa", true, null, "lion"));
        animals.add(AnimalFactory.createFeline("Simba", true, null, "lion"));
        animals.add(AnimalFactory.createFeline("Shere Khan", true, null, "tiger"));

        animals.add(AnimalFactory.createPachyderm("Dumbo", true, null, "elephant"));
        animals.add(AnimalFactory.createPachyderm("Babar", true, null, "elephant"));
        animals.add(AnimalFactory.createPachyderm("Gloria", true, null, "hippo"));

        animals.add(AnimalFactory.createBird("Hedwig", true, null, "owl"));
        animals.add(AnimalFactory.createBird("Polly", true, null, "parrot"));
        animals.add(AnimalFactory.createBird("Falco", true, null, "falcon"));
        
        updateAnimalCounts();
    }

    private void randomlyMakeAnimalsSick() {
        Random rand = new Random();
        for (Animal animal : new ArrayList<>(animals)) {
            if (rand.nextDouble() < 0.3 && animal.isHealthy()) {
                animal.setHealthy(false);

                // Remove from enclosure
                if (animal.getEnclosure() != null) {
                    animal.getEnclosure().getAllAnimals().remove(animal);
                }

                // Admit to hospital
                if (!hospitals.isEmpty()) {
                    hospitals.get(0).admitAnimal(animal);
                }
            }
        }
    }

    private void createEnclosures() {
        ArrayList<Animal> felines = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal.species().equalsIgnoreCase("feline")) {
                felines.add(animal);
            }
        }
        if (!felines.isEmpty()) {
            Enclosure<Feline> felineEnclosure = (Enclosure<Feline>) BuildingFactory.createEnclosure("Lion Enclosure", "feline", felines);
            enclosures.add(felineEnclosure);
            buildings.add(felineEnclosure);
        }

        ArrayList<Animal> pachyderms = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal.species().equalsIgnoreCase("pachyderm")) {
                pachyderms.add(animal);
            }
        }
        if (!pachyderms.isEmpty()) {
            Enclosure<Pachyderm> pachydermEnclosure = (Enclosure<Pachyderm>) BuildingFactory.createEnclosure("Elephant Enclosure", "pachyderm", pachyderms);
            enclosures.add(pachydermEnclosure);
            buildings.add(pachydermEnclosure);
        }

        ArrayList<Animal> birds = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal.species().equalsIgnoreCase("bird")) {
                birds.add(animal);
            }
        }
        if (!birds.isEmpty()) {
            Enclosure<Bird> birdEnclosure = (Enclosure<Bird>) BuildingFactory.createEnclosure("Aviary", "bird", birds);
            enclosures.add(birdEnclosure);
            buildings.add(birdEnclosure);
        }
    }

    private void createBuildings() {
        Shop giftShop = new Shop("Gift Shop");
        Shop snackBar = new Shop("Snack Bar");
        shops.add(giftShop);
        shops.add(snackBar);
        buildings.add(giftShop);
        buildings.add(snackBar);

        Hospital animalHospital = BuildingFactory.createHospital("Animal Hospital");
        hospitals.add(animalHospital);
        buildings.add(animalHospital);
    }

    public void createStaff() {
        handlers.clear();
        veterinarians.clear();

        Scanner sc = new Scanner(System.in);
        System.out.println("\n--- Zoo Setup ---");

        System.out.print("Enter your name, Manager: ");
        String managerName = sc.nextLine();

        System.out.print("Enter Veterinarian's name: ");
        String vetName = sc.nextLine();
        if (!hospitals.isEmpty()) {
            Veterinarian vet = new Veterinarian(hospitals.get(0));
            vet.setName(vetName);
            veterinarians.add(vet);
        }

        for (Enclosure<? extends Animal> enclosure : enclosures) {
            System.out.print("Enter Handler for " + enclosure.getSpecies() + " Enclosure: ");
            String handlerName = sc.nextLine();

            switch (enclosure.getSpecies().toLowerCase()) {
                case "feline" -> {
                    Handler<Feline> handler = new Handler<>((Enclosure<Feline>) enclosure);
                    handler.setName(handlerName);
                    handlers.add(handler);
                }
                case "pachyderm" -> {
                    Handler<Pachyderm> handler = new Handler<>((Enclosure<Pachyderm>) enclosure);
                    handler.setName(handlerName);
                    handlers.add(handler);
                }
                case "bird" -> {
                    Handler<Bird> handler = new Handler<>((Enclosure<Bird>) enclosure);
                    handler.setName(handlerName);
                    handlers.add(handler);
                }
            }
        }

        System.out.println("\nZoo staff setup complete.");
        System.out.println("Veterinarian: " + veterinarians.get(0).getName());
        for (Handler<? extends Animal> h : handlers) {
            System.out.println("Handler for " + h.getAssignedEnclosure().getSpecies() + ": " + h.getName());
        }
    }


    private void updateAnimalCounts() {
        animalCounts.clear();
        for (Animal animal : animals) {
            String species = animal.species();
            animalCounts.put(species, animalCounts.getOrDefault(species, 0) + 1);
        }
    }

    public void openZoo() {
        this.isOpen = true;
        System.out.println("🎉 " + name + " is now OPEN!");
        System.out.println("Welcome visitors!");
    }

    public void closeZoo() {
        this.isOpen = false;
        System.out.println("🌙 " + name + " is now CLOSED.");
        System.out.println("Thank you for visiting!");
    }

    public void displayZooInfo() {
        System.out.println("=== 🦁 " + name + " Information ===");
        System.out.println("Status: " + (isOpen ? "OPEN" : "CLOSED"));
        System.out.println("Total Animals: " + animals.size());
        System.out.println("Total Buildings: " + buildings.size());
        System.out.println("Total Staff: " + (handlers.size() + veterinarians.size()));
        System.out.println();
        
        System.out.println("Animal Count by Species:");
        for (Map.Entry<String, Integer> entry : animalCounts.entrySet()) {
            System.out.println("- " + entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();
    }

    public void displayAllAnimals() {
        System.out.println("=== 🐾 All Animals in " + name + " ===");
        for (Animal animal : animals) {
            System.out.println("- " + animal.getName() + " (" + animal.type() + ") - " + 
                             (animal.isHealthy() ? "Healthy" : "Sick"));
        }
        System.out.println();
    }

    public void displayAllBuildings() {
        System.out.println("=== 🏢 All Buildings in " + name + " ===");
        for (Building building : buildings) {
            System.out.println("- " + building.getName() + " (" + building.type() + ")");
        }
        System.out.println();
    }

    public void feedAllAnimals() {
        System.out.println("🍽️ Feeding time for all animals!");
        for (Animal animal : animals) {
            animal.eat();
            System.out.println(" ✓ " + animal.getName());
        }
        System.out.println("All animals have been fed!");
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
        updateAnimalCounts();
        System.out.println("Added " + animal.getName() + " to the zoo.");

        for (Enclosure<? extends Animal> enclosure : enclosures) {
            if (enclosure.getSpecies().equalsIgnoreCase(animal.species())) {
                enclosure.addAnimal(animal);
                animal.setLocation(enclosure);
                break;
            }
        }
    }

    public Animal findAnimal(String name) {
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(name)) {
                return animal;
            }
        }
        return null;
    }

    public void addVisitor(Visitor visitor) {
        visitors.add(visitor);
        System.out.println("Welcome " + visitor.getName() + " to " + name + "!");
    }

    public void startTicketingSystem() {
        ticketingSystem.startTicketingSystem();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public ArrayList<Building> getBuildings() {
        return buildings;
    }

    public ArrayList<Enclosure<? extends Animal>> getEnclosures() {
        return enclosures;
    }

    public ArrayList<Shop> getShops() {
        return shops;
    }

    public ArrayList<Hospital> getHospitals() {
        return hospitals;
    }

    public ArrayList<Handler<? extends Animal>> getHandlers() {
        return handlers;
    }

    public ArrayList<Veterinarian> getVeterinarians() {
        return veterinarians;
    }

    public ArrayList<Visitor> getVisitors() {
        return visitors;
    }

    public TicketingSystem getTicketingSystem() {
        return ticketingSystem;
    }

    public Map<String, Integer> getAnimalCounts() {
        return animalCounts;
    }
}

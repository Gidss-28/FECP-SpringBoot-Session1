package org.example;

import org.example.Animal.Animal;
import org.example.Animal.AnimalFactory;
import org.example.Animal.Bird.Bird;
import org.example.Animal.Feline.Feline;
import org.example.Animal.Pachyderm.Pachyderm;
import org.example.Building.*;
import org.example.Person.Staff.Handler;
import org.example.Person.Staff.Veterinarian;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        this.ticketingSystem = new TicketingSystem();
        this.animalCounts = new HashMap<>();
        initializeZoo();
    }

    private void initializeZoo() {
        // Create sample animals
        createSampleAnimals();
        
        // Create enclosures
        createEnclosures();
        
        // Create other buildings
        createBuildings();
        
        // Create staff
        createStaff();
    }

    private void createSampleAnimals() {
        // Create felines
        animals.add(AnimalFactory.createFeline("Mufasa", true, null, "lion"));
        animals.add(AnimalFactory.createFeline("Simba", true, null, "lion"));
        animals.add(AnimalFactory.createFeline("Shere Khan", true, null, "tiger"));
        
        // Create pachyderms
        animals.add(AnimalFactory.createPachyderm("Dumbo", true, null, "elephant"));
        animals.add(AnimalFactory.createPachyderm("Babar", true, null, "elephant"));
        animals.add(AnimalFactory.createPachyderm("Gloria", true, null, "hippo"));
        
        // Create birds
        animals.add(AnimalFactory.createBird("Hedwig", true, null, "owl"));
        animals.add(AnimalFactory.createBird("Polly", true, null, "parrot"));
        animals.add(AnimalFactory.createBird("Falco", true, null, "falcon"));
        
        updateAnimalCounts();
    }

    private void createEnclosures() {
        // Create feline enclosure
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

        // Create pachyderm enclosure
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

        // Create bird enclosure
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
        // Create shops
        Shop giftShop = new Shop("Gift Shop");
        Shop snackBar = new Shop("Snack Bar");
        shops.add(giftShop);
        shops.add(snackBar);
        buildings.add(giftShop);
        buildings.add(snackBar);

        // Create hospital
        Hospital animalHospital = BuildingFactory.createHospital("Animal Hospital");
        hospitals.add(animalHospital);
        buildings.add(animalHospital);
    }

    private void createStaff() {
        // Create handlers for each enclosure
        for (Enclosure<? extends Animal> enclosure : enclosures) {
            if (enclosure.getSpecies().equalsIgnoreCase("feline")) {
                Handler<Feline> felineHandler = new Handler<>((Enclosure<Feline>) enclosure);
                felineHandler.setName("John Handler");
                handlers.add(felineHandler);
            } else if (enclosure.getSpecies().equalsIgnoreCase("pachyderm")) {
                Handler<Pachyderm> pachydermHandler = new Handler<>((Enclosure<Pachyderm>) enclosure);
                pachydermHandler.setName("Jane Handler");
                handlers.add(pachydermHandler);
            } else if (enclosure.getSpecies().equalsIgnoreCase("bird")) {
                Handler<Bird> birdHandler = new Handler<>((Enclosure<Bird>) enclosure);
                birdHandler.setName("Bob Handler");
                handlers.add(birdHandler);
            }
        }

        // Create veterinarians
        if (!hospitals.isEmpty()) {
            Veterinarian vet = new Veterinarian(hospitals.get(0));
            vet.setName("Dr. Smith");
            veterinarians.add(vet);
        }
    }

    private void updateAnimalCounts() {
        animalCounts.clear();
        for (Animal animal : animals) {
            String species = animal.species();
            animalCounts.put(species, animalCounts.getOrDefault(species, 0) + 1);
        }
    }

    // Basic Zoo Operations
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

    // Animal Management
    public void addAnimal(Animal animal) {
        animals.add(animal);
        updateAnimalCounts();
        System.out.println("Added " + animal.getName() + " to the zoo.");
        
        // Try to add to appropriate enclosure
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

    // Visitor Management
    public void addVisitor(Visitor visitor) {
        visitors.add(visitor);
        System.out.println("Welcome " + visitor.getName() + " to " + name + "!");
    }

    public void startTicketingSystem() {
        ticketingSystem.startTicketingSystem();
    }

    // Getters and Setters
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

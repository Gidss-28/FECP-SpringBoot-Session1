package org.example.Building;

import org.example.Animal.Animal;

import java.util.ArrayList;

public class Hospital extends Building{
    private final ArrayList<Animal> animals;

    protected Hospital(String name){
        super(name, "hospital");
        this.animals = new ArrayList<>();
    }

    public ArrayList<Animal> getSickAnimals() {
        ArrayList<Animal> sickAnimals = new ArrayList<>();
        for (Animal a: this.animals) {
            if (!a.isHealthy()) sickAnimals.add(a);
        }
        return sickAnimals;
    }

    public ArrayList<Animal> getHealthyAnimals() {
        ArrayList<Animal> sickAnimals = new ArrayList<>();
        for (Animal a: this.animals) {
            if (a.isHealthy()) sickAnimals.add(a);
        }
        return sickAnimals;
    }

    public void admitAnimal(Animal animal) {
        this.animals.add(animal);
    }

    public void releaseAnimal(String animalName, Enclosure<Animal> enclosure) {
        for (Animal a: this.animals) {
            if (a.getName().equalsIgnoreCase(animalName) && a.isHealthy()) enclosure.addAnimal(a);
        }
    }
}

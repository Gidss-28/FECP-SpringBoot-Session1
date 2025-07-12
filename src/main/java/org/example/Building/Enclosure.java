package org.example.Building;

import java.util.ArrayList;
import org.example.Animal.Animal;
import org.example.Person.Staff.Handler;

public class Enclosure<T extends Animal> extends Building{
    private final String species;
    private final ArrayList<T> animals;

    Enclosure(String name, String species, ArrayList<T> animals){
        super(name, "eclosure");
        this.animals = animals;
        this.species = species;
    }

    public void addAnimal(Animal animal) {
        if (animal.species().equalsIgnoreCase(this.species)) this.animals.add((T) animal);
    }

    public String getSpecies(){
        return this.species;
    }

    public ArrayList<T> getAllAnimals(){
        return this.animals;
    }

    public T getAnimal(String name){
        for (T a: animals){
            if (a.getName().equalsIgnoreCase(name)) return a;
        }
        return null;
    }
}

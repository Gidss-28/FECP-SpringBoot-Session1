package org.example.Building;

import java.util.ArrayList;
import org.example.Animal.Animal;

public class Enclosure<T extends Animal> extends Building{
    private final String species;
    private ArrayList<T> animals;

    Enclosure(String name, String species, ArrayList<T> animals){
        super(name, "eclosure");
        this.animals = animals;
        this.species = species;
    }
}

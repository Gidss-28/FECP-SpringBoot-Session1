package org.example.Building;

import java.util.ArrayList;
import org.example.Animal.Animal;

public class Enclosure<T extends Animal> extends Building{
    private String type;
    private ArrayList<T> animals;

    Enclosure(ArrayList<T> animals){
        this.animals = animals;
        this.type = animals.getFirst().toString();
    }
}

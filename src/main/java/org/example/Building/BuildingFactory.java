package org.example.Building;

import org.example.Animal.Animal;
import org.example.Animal.Bird.Bird;
import org.example.Animal.Feline.Feline;
import org.example.Animal.Pachyderm.Pachyderm;

import java.util.ArrayList;

public class BuildingFactory {

    public static Enclosure<? extends Animal> createEnclosure (String name, String species, ArrayList<Animal> animals) {
        if(species.equalsIgnoreCase("pachyderm")) {
            ArrayList<Pachyderm> pachyderms = new ArrayList<>();
            for (Animal a: animals){
                if (a.species().equalsIgnoreCase("pachyderm")) {
                    pachyderms.add((Pachyderm)a);
                }
            }
            return new Enclosure<Pachyderm>(name, species, pachyderms);
        } else if (species.equalsIgnoreCase("feline")) {
            ArrayList<Feline> felines = new ArrayList<>();
            for (Animal a: animals){
                if (a.species().equalsIgnoreCase("feline")) {
                    felines.add((Feline)a);
                }
            }
            return new Enclosure<Feline>(name, species, felines);
        } else if (species.equalsIgnoreCase("bird")) {
            ArrayList<Bird> birds = new ArrayList<>();
            for (Animal a: animals){
                if (a.species().equalsIgnoreCase("bird")) {
                    birds.add((Bird)a);
                }
            }
            return new Enclosure<Bird>(name, species, birds);
        }
        else return null;
    }

    public static Hospital createHospital(String name){return new Hospital(name);}

}

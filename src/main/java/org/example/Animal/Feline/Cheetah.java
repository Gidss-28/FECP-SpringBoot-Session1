package org.example.Animal.Feline;

import org.example.Building.Building;

public class Cheetah extends Feline{
    public Cheetah (String name, boolean isHealthy, Building location) {
        super(name, isHealthy, location);
    }

    public void makeSound() {
        switch ((int) (Math.random() * 2)){
            case 0: System.out.print("Chirp! Chirp!"); break;
            case 1: System.out.print("Rrrrrr..."); break;
        }
    }

    public String type() {return "cheetah";}
}

package org.example.Animal.Pachyderm;

import org.example.Building.Building;

public class Elephant extends Pachyderm{
    public Elephant (String name, boolean isHealthy, Building location) {
        super(name, isHealthy, location);
    }

    public void makeSound() {
        switch ((int) (Math.random() * 2)){
            case 0: System.out.print("Pawoooh!"); break;
            case 1: System.out.print("Rrrrrrrrr..."); break;
        }
    }

    public String type() {return "elephant";}
}

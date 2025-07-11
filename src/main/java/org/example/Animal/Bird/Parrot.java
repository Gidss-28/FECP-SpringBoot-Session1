package org.example.Animal.Bird;

import org.example.Building.Building;

public class Parrot extends Bird{
    public Parrot (String name, boolean isHealthy, Building location) {
        super(name, isHealthy, location);
    }

    public void makeSound() {

        switch ((int) (Math.random() * 2)){
            case 0: System.out.print("Hello! I'm a parrot."); break;
            case 1: System.out.print("How are you?"); break;
        }
    }

    public String type() {return "parrot";}
}

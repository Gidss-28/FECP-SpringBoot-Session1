package org.example.Animal.Bird;

import org.example.Building.Building;

public class Owl extends Bird{
    public Owl (String name, boolean isHealthy, Building location) {
        super(name, isHealthy, location);
    }

    public void makeSound() {
        switch ((int) (Math.random() * 2)){
            case 0: System.out.print("Hoo-hoo-hooooo!"); break;
            case 1: System.out.print("Keeeeeer!"); break;
        }
    }

    public String type() {return "owl";}
}

package org.example.Animal.Pachyderm;

import org.example.Building.Building;

public class Hippo extends Pachyderm{
    public Hippo (String name, boolean isHealthy, Building location) {
        super(name, isHealthy, location);
    }

    public void makeSound() {
        switch ((int) (Math.random() * 2)){
            case 0: System.out.print("Hrrr-hrrr-hrrrah!"); break;
            case 1: System.out.print("Pffft! Snork!"); break;
        }
    }

    public String type() {return "hippo";}
}

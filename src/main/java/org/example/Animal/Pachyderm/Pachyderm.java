package org.example.Animal.Pachyderm;

import org.example.Animal.Animal;
import org.example.Building.Building;

public abstract class Pachyderm extends Animal{
    protected Pachyderm (String name, boolean isHealthy, Building location) {
        super(name, isHealthy, location);
    }
    public void roam() {
        System.out.print("walking...");
    }
    public String species () {return "pachyderm";}
}

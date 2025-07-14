package org.example.Animal.Feline;

import org.example.Animal.Animal;
import org.example.Building.Building;

public abstract class Feline extends Animal {
    protected Feline (String name, boolean isHealthy, Building location) {
        super(name, isHealthy, location, null);
    }
    public void roam() {
        System.out.print("sprinting...");
    }
    public String species () {return "feline";}
}

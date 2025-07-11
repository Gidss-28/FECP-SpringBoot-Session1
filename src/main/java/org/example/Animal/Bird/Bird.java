package org.example.Animal.Bird;

import org.example.Animal.Animal;
import org.example.Building.Building;

public abstract class Bird extends Animal {
    protected Bird (String name, boolean isHealthy, Building location) {
        super(name, isHealthy, location);
    }
    public void roam() {
        System.out.print("flying...");
    }
    public String species () {return "bird";}
}
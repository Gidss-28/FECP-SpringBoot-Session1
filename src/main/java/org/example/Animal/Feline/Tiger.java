package org.example.Animal.Feline;

import org.example.Building.Building;

public class Tiger extends Feline{
    public Tiger (String name, boolean isHealthy, Building location) {
        super(name, isHealthy, location);
    }

    public void makeSound() {
        switch ((int) (Math.random() * 2)){
            case 0: System.out.print("RROOAARRR!"); break;
            case 1: System.out.print("Pffft-chuff... pffft-chuff..."); break;
        }
    }

    public String type() {return "tiger";}
}

package org.example.Animal.Feline;

import org.example.Building.Building;

public class Lion extends Feline{
    public Lion (String name, boolean isHealthy, Building location) {
        super(name, isHealthy, location);
    }

    public void makeSound() {
        switch ((int) (Math.random() * 2)){
            case 0: System.out.print("ROAAAAR!! Grrrrrr..."); break;
            case 1: System.out.print("Urrhh... grrhh..."); break;
        }
    }

    public String type() {return "lion";}
}

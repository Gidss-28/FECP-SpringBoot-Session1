package org.example.Animal.Bird;

import org.example.Building.Building;


public class Falcon extends Bird{
    public Falcon (String name, boolean isHealthy, Building location) {
        super(name, isHealthy, location);
    }

    public void makeSound() {
        switch ((int) (Math.random() * 2)){
            case 0: System.out.print("Kak-kak-kak!"); break;
            case 1: System.out.print("Kreee! Kreee!"); break;
        }
    }

    public String type() {return "falcon";}
}

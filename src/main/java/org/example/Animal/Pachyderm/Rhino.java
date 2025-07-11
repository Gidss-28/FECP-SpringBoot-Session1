package org.example.Animal.Pachyderm;

import org.example.Building.Building;

public class Rhino extends Pachyderm{
    public Rhino (String name, boolean isHealthy, Building location) {
        super(name, isHealthy, location);
    }

    public void makeSound() {
        switch ((int) (Math.random() * 2)){
            case 0: System.out.print("Grrrhh... huhhh..."); break;
            case 1: System.out.print("Pffft! Snrrrk!"); break;
        }
    }

    public String type() {return "rhino";}
}

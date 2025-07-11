package org.example.Animal;

import org.example.Building.Building;

public abstract class Animal {
    private String name;
    private boolean isHealthy ;
    private Building location;

    protected Animal(String name, boolean isHealthy, Building location ){
        this.name = name;
        this.isHealthy = isHealthy;
        this.location = location;
    }

    public void eat(){
        System.out.print(name + " is eating...");
    }

    public void sleep(){
        System.out.print(name + " is sleeping...");
    }

    public abstract void roam();
    public abstract void makeSound();
    public abstract String species();
    public abstract String type();
}

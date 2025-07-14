package org.example.Animal;

import org.example.Building.Building;
import org.example.Building.Enclosure;

public abstract class Animal {
    private String name;
    private boolean isHealthy ;
    private Building location;
    private Enclosure<?> enclosure;

    protected Animal(String name, boolean isHealthy, Building location, Enclosure<?> enclosure){
        this.name = name;
        this.isHealthy = isHealthy;
        this.location = location;
        this.enclosure = enclosure;
    }

    public Enclosure<?> getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(Enclosure<?> enclosure) {
        this.enclosure = enclosure;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHealthy() {
        return isHealthy;
    }

    public void setHealthy(boolean healthy) {
        isHealthy = healthy;
    }

    public Building getLocation() {
        return location;
    }

    public void setLocation(Building location) {
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

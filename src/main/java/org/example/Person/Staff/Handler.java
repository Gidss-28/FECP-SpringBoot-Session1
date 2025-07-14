package org.example.Person.Staff;

import org.example.Animal.Animal;
import org.example.Building.Enclosure;
import org.example.Person.Person;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Handler <T extends Animal> extends Person{
    Enclosure<T> assignedEnclosure;

    public Handler(Enclosure<T> enclosure){
        this.assignedEnclosure = enclosure;
    }

    public void feedAnimal(String animalName) {
        T animal = assignedEnclosure.getAnimal(animalName);
        System.out.println(this.getName() + " is feeding " + animal.getName());
    }

    public void exerciseAnimal(String animalName) {
        T animal = assignedEnclosure.getAnimal(animalName);
        System.out.println(this.getName() + " is exercising " + animal.getName());
    }

    public void examineToVet(String animalName) {
        T animal = assignedEnclosure.getAnimal(animalName);
        // TODO: implement transfer of animal to hospital
        System.out.println(animal.getName() + " admitted at " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
    }

    public Enclosure<T> getAssignedEnclosure() {
        return assignedEnclosure;
    }

}

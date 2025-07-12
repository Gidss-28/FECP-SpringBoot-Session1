package org.example.Animal;

import org.example.Animal.Bird.*;
import org.example.Animal.Feline.*;
import org.example.Animal.Pachyderm.*;
import org.example.Building.Building;

public class AnimalFactory {

    public static Bird createBird(String name, boolean isHealthy, Building location, String type) {
        return switch (type.toLowerCase()) {
            case "falcon" -> new Falcon(name, isHealthy, location);
            case "owl" -> new Owl(name, isHealthy, location);
            case "parrot" -> new Parrot(name, isHealthy, location);
            default -> null;
        };
    }

    public static Feline createFeline(String name, boolean isHealthy, Building location, String type) {
        return switch (type.toLowerCase()) {
            case "cheetah" -> new Cheetah(name, isHealthy, location);
            case "lion" -> new Lion(name, isHealthy, location);
            case "tiger" -> new Tiger(name, isHealthy, location);
            default -> null;
        };
    }

    public static Pachyderm createPachyderm(String name, boolean isHealthy, Building location, String type) {
        return switch (type.toLowerCase()) {
            case "elephant" -> new Elephant(name, isHealthy, location);
            case "hippo" -> new Hippo(name, isHealthy, location);
            case "rhino" -> new Rhino(name, isHealthy, location);
            default -> null;
        };
    }
}

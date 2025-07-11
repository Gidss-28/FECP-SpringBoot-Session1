package org.example.Building;

public abstract class Building {
    private String name;
    private final String TYPE;

    protected Building(String name, String type) {
        this.name = name;
        this.TYPE = type;
    }

}

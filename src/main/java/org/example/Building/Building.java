package org.example.Building;

public abstract class Building {
    private String name;
    private final String TYPE;

    protected Building(String name, String type) {
        this.name = name;
        this.TYPE = type;
    }

    public String type() {return this.TYPE;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

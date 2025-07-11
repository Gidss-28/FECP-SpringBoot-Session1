package org.example.Staff;

import org.example.Building.Building;
import org.example.Building.Enclosure;


public class Handler extends Staff{
    private Enclosure assignedEnclosure;

    Handler(String name, Building location) {
        super(name, location);
    }
}

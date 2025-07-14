package org.example;

public class Visitor {
    private String name;
    private String ticketCode;

    public Visitor() {
    }

    public Visitor(String name) {
        this.name = name;
    }

    public Visitor(String name, String ticketCode) {
        this.name = name;
        this.ticketCode = ticketCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "name='" + name + '\'' +
                ", ticketCode='" + ticketCode + '\'' +
                '}';
    }
}

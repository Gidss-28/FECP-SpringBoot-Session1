package org.example;

public class Ticket {
    private final String ticketCode;
    private final String visitorName;
    private final int visitorAge;
    private final String ticketType;
    private final double price;
    private boolean isValid;

    public Ticket(String visitorName, int visitorAge) {
        this.visitorName = visitorName;
        this.visitorAge = visitorAge;
        this.ticketType = AgeBasedTicketType.determineTicketType(visitorAge);
        this.price = AgeBasedTicketType.getPrice(visitorAge);
        this.ticketCode = generateTicketCode();
        this.isValid = true;
    }

    private String generateTicketCode() {
        int randomCode = (int) (Math.random() * 9000) + 1000;
        return "ZOO-" + randomCode;
    }

    public void displayTicketInfo(){
        System.out.println("You qualify for a " + ticketType + " .");
        System.out.println("Ticket Price: ₱" + price);
    }

    public String getTicketCode() { return ticketCode; }
    public String getVisitorName() { return visitorName; }
    public int getVisitorAge() { return visitorAge; }
    public String getTicketType() { return ticketType; }
    public double getPrice() { return price; }
    public boolean isValid() { return isValid; }
    public void setValid(boolean valid) { this.isValid = valid; }
}

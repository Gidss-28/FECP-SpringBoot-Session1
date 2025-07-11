package org.example;


public class AgeBasedTicketType {
    public static final String CHILD = "Child";
    public static final String STUDENT = "Student";
    public static final String ADULT = "Adult";
    public static final String SENIOR = "Senior";

    public static final double CHILD_PRICE = 0.00;
    public static final double STUDENT_PRICE = 75.00;
    public static final double ADULT_PRICE = 150.00;
    public static final double SENIOR_PRICE = 50.00;

    public static String determineTicketType(int age) {
        if (age >= 0 && age <= 5) {
            return CHILD;
        } else if (age >= 6 && age <= 17) {
            return STUDENT;
        } else if (age >= 18 && age <= 59) {
            return ADULT;
        } else if (age >= 60) {
            return SENIOR;
        } else {
            throw new IllegalArgumentException("Invalid age: " + age);
        }
    }

    public static double getPrice(int age) {
        String ticketType = determineTicketType(age);
        switch (ticketType) {
            case CHILD:
                return CHILD_PRICE;
            case STUDENT:
                return STUDENT_PRICE;
            case ADULT:
                return ADULT_PRICE;
            case SENIOR:
                return SENIOR_PRICE;
            default:
                throw new IllegalArgumentException("Unknown ticket type: " + ticketType);
        }
    }

    public static void displayPricingChart() {

    }
}

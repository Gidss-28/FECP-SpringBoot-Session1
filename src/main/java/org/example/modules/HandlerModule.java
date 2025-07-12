package org.example.modules;

import org.example.Animal.Animal;
import org.example.Person.Staff.Handler;
import org.example.Zoo;

import java.util.Scanner;

public class HandlerModule {
    private Handler<Animal> handler;
    private Zoo zoo;

    HandlerModule(Zoo zoo) {
        this.zoo = zoo;
    }

    public void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name (Handler): ");
        String name = sc.nextLine();
    }
}

package org.example.designPatterns.strategyDesignPattern;

public class SportsCar extends Vehicle{

    public SportsCar() {
        super(new SportsStrategy());
    }
}
